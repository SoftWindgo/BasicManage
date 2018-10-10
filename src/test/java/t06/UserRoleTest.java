package t06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.luotianyi.t06.dao.UsersRoleMapper;
import com.luotianyi.t06.entity.UsersRole;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(value = { "classpath:spring/applicationContext_base.xml",
//		"classpath:spring/applicationContext_dao.xml", "classpath:spring/applicationContext_service.xml" })
public class UserRoleTest {

	@Autowired
	UsersRoleMapper usersRoleMapper;
	
//	@Test
	public void test1() {
		List<UsersRole> selectAll = usersRoleMapper.selectAll();
		System.out.println(selectAll);
		
	}
}
