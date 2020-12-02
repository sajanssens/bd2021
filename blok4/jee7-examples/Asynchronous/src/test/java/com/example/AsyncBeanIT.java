package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class AsyncBeanIT {

    @Inject
    private AsyncBean asyncBean;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(AsyncBean.class.getPackage());
        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void testProcessWork() throws Exception {
        long elapsedTime = asyncBean.processWork("Very important data");
        assertTrue(elapsedTime >= 3000);
    }

}
