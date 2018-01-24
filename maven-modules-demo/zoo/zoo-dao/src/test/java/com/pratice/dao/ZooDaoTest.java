package com.pratice.dao;

import org.junit.Assert;
import org.junit.Test;

public class ZooDaoTest {
	
	@Test
	public void test1(){
		ZooDao dao = new ZooDao();
		Assert.assertNotNull(dao.getZoo());
	}
	
}
