package com.pratice.server;

import com.pratice.dao.ZooDao;

/**
 * Hello world!
 *
 */
public class ZooServer 
{
    public String getZoo(){
    	ZooDao dao = new ZooDao();
    	return dao.getZoo();
    }
}
