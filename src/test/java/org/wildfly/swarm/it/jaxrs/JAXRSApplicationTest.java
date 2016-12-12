package org.wildfly.swarm.it.jaxrs;

import org.jboss.arquillian.phantom.resolver.ResolvingPhantomJSDriverService;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class JAXRSApplicationTest {

    private PhantomJSDriver browser;

    @Before
    public void setup() throws IOException {
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();

        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{"--web-security=no", "--ignore-ssl-errors=true"});

        this.browser = new PhantomJSDriver(
                ResolvingPhantomJSDriverService.createDefaultService(capabilities),
                capabilities);
    }

    @Test
    public void testIt() throws InterruptedException {
        browser.navigate().to("https://localhost:8443/");
        assertTrue(browser.getPageSource().contains("Howdy at "));
    }
}