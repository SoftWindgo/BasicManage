package t06;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import com.luotianyi.t06.dao.UsersMapper;
import com.luotianyi.t06.entity.Users;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(value = { "classpath:spring/applicationContext_base.xml",
//		"classpath:spring/applicationContext_dao.xml", "classpath:spring/applicationContext_service.xml" })
public class UserTest {
	
//	@Autowired
	UsersMapper usersMapper;

	@Test
	public void test() {
		Users users = new Users();
		users.setUsersId(1);
		users.setUsername("admin");
		users.setPassword("123456");
		users.setPassword(new Md5Hash(users.getPassword(), "luotianyi" + users.getUsername(), 2).toString());
		System.out.println(users.getPassword());
		//		usersMapper.insertByUsers(users);
//		System.out.println();
	}

}
