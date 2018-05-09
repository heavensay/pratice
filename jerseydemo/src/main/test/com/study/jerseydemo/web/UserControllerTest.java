package com.study.jerseydemo.web;

import com.study.jerseydemo.jersey.JerseyBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class UserControllerTest extends JerseyBaseTest{

    @Test
    public void testGetUser() {

        WebTarget target = target().path("/user/getUser").queryParam("userName", "ly")
                .queryParam("city", "440300");

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).header("mobile", "15900000012").get();
        System.out.println(response.readEntity(String.class));
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
