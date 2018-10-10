package t06;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.luotianyi.t06.dao.RolesPermissionMapper;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(value = { "classpath:spring/applicationContext_base.xml",
//		"classpath:spring/applicationContext_dao.xml", "classpath:spring/applicationContext_service.xml" })
public class RolesPermissionTest {

	@Autowired
	private RolesPermissionMapper rolesPermissionMapper;
	
	@Test
	private void test1() {
		
		System.out.println(rolesPermissionMapper.selectAll());
		
	}
}
