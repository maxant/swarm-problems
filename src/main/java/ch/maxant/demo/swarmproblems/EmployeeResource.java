package ch.maxant.demo.swarmproblems;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
@RequestScoped
@Transactional
public class EmployeeResource {

    @Inject
    private EmployeeService service;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<Employee> get() {
        return service.getAll();
    }

}