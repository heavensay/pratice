package com.study.jerseydemo.web;

import com.study.jerseydemo.service.UserService;
import com.study.jerseydemo.web.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(/*@PathParam("param")*/ String userName) {

        log.debug(" getUser==== ");
        return userService.queryUser();
    }
}
