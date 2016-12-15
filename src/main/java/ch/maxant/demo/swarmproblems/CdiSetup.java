package ch.maxant.demo.swarmproblems;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class CdiSetup {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    /** required by springdata */
    @Produces
    public EntityManager em(){
        return em;
    }

}