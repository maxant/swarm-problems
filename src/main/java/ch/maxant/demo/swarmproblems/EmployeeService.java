package ch.maxant.demo.swarmproblems;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EmployeeService {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    @Inject
    EmployeeRepository employeeRepository;

    /** uses EM */
    public List<Employee> getAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    /** uses SpringData Repository */
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

}