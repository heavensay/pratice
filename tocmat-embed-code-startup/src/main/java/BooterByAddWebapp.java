/*
 * Copyright 2017 Blue Lotus Software, LLC.
 * Copyright 2017 John Yeary <jyeary@bluelotussoftware.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 * 
 */
public class BooterByAddWebapp {

    static final int port = 8080;
    //用于存放tomcat embed所生产的临时文件
//    static final String docBase = "./target/tomcat-embed";
    static final String docBase = "./tomcat-embed";
    //访问路径http://ip:port/contextPath
    static final String contextPath = "/tomcat-embed-code-startup";
    //webapppath是一个web项目根路径；maven打包出来的war项目，在target会有一个相当于war解包后的文件夹，包括所有calsses，jsp,web.xml等；地址为war包也应该支持，没试过
    static String webappPath = "./tocmat-embed-code-startup";
    
    public static void main(String[] args)
            throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(docBase);
        tomcat.setPort(port);

        Context ctx = tomcat.addWebapp(contextPath, webappPath);

        tomcat.start();
        tomcat.getServer().await();
    }

}