package t06;


import org.springframework.beans.factory.annotation.Autowired;

import com.luotianyi.t06.dao.RolesMapper;
import com.luotianyi.t06.entity.Roles;


//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(value = { "classpath:spring/applicationContext_base.xml",
//		"classpath:spring/applicationContext_dao.xml", "classpath:spring/applicationContext_service.xml" })
public class RolesTest {

	@Autowired
	RolesMapper rolesMapper;
	
//	@Test
	public void test() {
		Roles roles = rolesMapper.selectByUserId(1);
		System.out.println(roles);
	}

}
