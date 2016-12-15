# What is this?
A repo containing reproducible bugs to back up issues raised at https://issues.jboss.org/projects/SWARM or elsewhere.
See branches for more examples.

# Which problem is shown on this branch?

When using Spring Data with CDI/EJB then the initial request to the Repository always fails with `GenericJDBCException: Unable to acquire JDBC Connection`.

See [ApplicationIT.java](/src/test/java/ch/maxant/demo/swarmproblems/ApplicationIT.java) for an example.

See http://stackoverflow.com/questions/41174111/

# Analysis

Debugging, I found out that `org.springframework.data.jpa.respository.query.NamedQuery#lookupFrom` ends up calling
through to `org.hibernate.jpa.spi.AbstractentityManagerImpl#buildQueryfromName` which seems to throw an 
`IllegalArgumentException: No query defined for that name [Employee.findByName]`. That kind of makes sense, in that
Spring appears to be loading the named query lazily.
