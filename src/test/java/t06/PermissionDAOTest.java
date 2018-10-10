package t06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.luotianyi.t06.dao.PermissionMapper;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(value = { "classpath:spring/applicationContext_base.xml",
//		"classpath:spring/applicationContext_dao.xml", "classpath:spring/applicationContext_service.xml" })
public class PermissionDAOTest {

//	@Autowired
	private PermissionMapper permissionMapper;
	
//	@Test
	public void test1() {
		System.out.println(permissionMapper.selectPermisByUserId(1));
	}
}
