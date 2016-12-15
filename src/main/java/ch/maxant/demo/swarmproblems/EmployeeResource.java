package ch.maxant.demo.swarmproblems;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
@Stateless
public class EmployeeResource {

    @Inject
    private EmployeeService service;

    @GET
    @Path("")
    @Produces("application/json")
    public List<Employee> get() {
        return service.getAll();
    }

    @GET
    @Path("{name}")
    @Produces("application/json")
    public Employee get(@PathParam("name") String name) {
        return service.findByName(name).stream().findFirst().orElse(null);
    }

}