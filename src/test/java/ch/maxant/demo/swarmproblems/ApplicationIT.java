package ch.maxant.demo.swarmproblems;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import io.undertow.util.StatusCodes;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApplicationIT {

    @Test
    public void testGetAll() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:8080");
        builder.setContentType(ContentType.JSON);
        builder.setAccept(ContentType.JSON);
        RequestSpecification spec = builder.build();

        //first request will use entity manager => NO problem
        given(spec).
                when().
                get("/").
                then().
                statusCode(StatusCodes.OK)
                .body("[0].name", is("Penny"));

        //second request uses SpringData Repository and FAILS
        given(spec)
                .when()
                .get("/Penny")
                .then()
                .log().body()
                .statusCode(StatusCodes.INTERNAL_SERVER_ERROR);

        //third request also uses SpringData Repository and WORKS
        given(spec)
                .when()
                .get("/Penny")
                .then()
                .log().body()
                .statusCode(StatusCodes.OK)
                .body("name", is("Penny"));
    }
}