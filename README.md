# What is this?
A repo containing reproducible bugs to back up issues raised at https://issues.jboss.org/projects/SWARM
See branches for more examples.

# Which problem is shown on this branch?

If using SpringData with CDI/EJB then the initial request to the Repository always fails with `GenericJDBCException: Unable to acquire JDBC Connection`.

See [ApplicationIT.java](/src/test/java/ch/maxant/demo/swarmproblems/ApplicationIT.java) for an example.
