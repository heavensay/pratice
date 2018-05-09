package com.study.jerseydemo.web;

import com.study.jerseydemo.service.UserService;
import com.study.jerseydemo.web.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/user")
@Singleton
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(/*@PathParam("param")*/@QueryParam("userName") String userName) {

        log.debug(" getUser==== "+userName+"ff");
        return userService.queryUser();
    }

    /**
     * map参数用例
     * @param map
     * @param name
     * @return
     */
    @POST
    @Consumes("application/json")
    @Path("/mapParam")
    public String mapParam(Map<String,String> map,@QueryParam("userName") String name) {
        if(map != null){
            map.forEach( (k,v) ->{ System.out.println("k:"+k+",v:"+v); } );
        }
        return "mapParam"+name;
    }

    @GET
    @Path("/gettt")
    public String gettt() {
//        if(map != null){
//            map.forEach( (k,v) ->{ System.out.println("k:"+k+",v:"+v); } );
//        }
        return "mapParam";
    }
}
