package ch.maxant.demo.swarmproblems;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = buildSwarm();

        swarm.start();

        JAXRSArchive deployment = buildDeployment();

        swarm.deploy(deployment);
    }

    static JAXRSArchive buildDeployment() throws Exception {
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "appName.war"); //provides default Application and @ApplicationPath
        deployment.addPackages(true, Main.class.getPackage());
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()), "classes/META-INF/persistence.xml");
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/beans.xml", Main.class.getClassLoader()), "classes/META-INF/beans.xml"); //needed otherwise it doesnt seem to be able to create cdi beans
        deployment.addResource(EmployeeResource.class);
        deployment.addAllDependencies();

        return deployment;
    }

    static Swarm buildSwarm() throws Exception {
        Swarm swarm = new Swarm();
        return swarm;
    }


}
