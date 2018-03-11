package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boardgame.dao.GameDao;
import com.boardgame.dao.UserDao;
import com.boardgame.util.CustomException;
import com.database.model.Authority;
import com.database.model.AuthorityId;
import com.database.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test/config/applicationContext.xml")
public class JUnitTest {

	@Autowired
	GameDao gameDao;

	@Autowired
	UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private User users1;

	private Authority admin;
	private Set<Authority> adminSet = new HashSet<>();

	@Before
	public void setUp() {
		String password = passwordEncoder.encode("dkssud85!");

		// 사용자 기본 정보를 생성
		this.users1 = new User(null, "ljy8509113@nate.com", password, "관리자", null, null, 0);
		                  

		// 각 사용자마다 권한을 부여하기
		// 1. 권한 객체 생성
		this.admin = new Authority(AuthorityId.ADMIN.getAuthorityId(), AuthorityId.ADMIN.name());

		/*
		 *  2. 1번에서 생성한 권한 객체를 Set 컬렉션에 추가하기
		 *  adminSet: 관리자 권한만 부여
		 *  userSet: 사용자 권한만 부여
		 *  bothSet: 관리자 권한과 사용자 권한 둘 다 부여 
		 */
		adminSet.add(admin);

		// 3. 각 사용자에게 권한 Set 컬렉션을 저장
		this.users1.setAuthorities(adminSet);

	}

	// 사용자 추가, 가져오기 테스트
	@Test
	public void addAndGetUsers(){
		/*
		 *  글 작성한 사용자가 존재할 경우 users 테이블을 먼저 삭제 할 수 없기 때문에
		 *  board 테이블을 먼저 삭제 후 사용자를 추가해야 한다.
		 */
		try {
			gameDao.deleteAll();
			assertThat(gameDao.getCount(), is(0));

			/*
			 *  사용자의 권한이 등록되어 있기 때문에
			 *  users_authority 테이블을 먼저 삭제 후 사용자를 추가해야 한다.
			 */
			userDao.deleteAllUsersAuthority();
			assertThat(userDao.getCountUsersAuthority(), is(0));

			userDao.deleteAll();
			assertThat(userDao.getCount(), is(0));

			// 사용자 3명 입력이 정상적으로 완료됐는지 확인 테스트
			userDao.insert(users1);
			assertThat(userDao.getCount(), is(1));

			// 사용자 3명의 권한 정보를 입력하고 정상적으로 완료됐는지 확인 테스트
			userDao.insertAuthority(users1);
			assertThat(userDao.getCountUsersAuthority(), is(1)); // users3 권한이 2개라서

			/*
			 *  테이블에 저장된 각 사용자의 정보를 제대로 가져왔는지 테스트
			 *  passwordEncoder의 matches 메소드는 결과가 boolean 타입이므로
			 *  JUnit의 assertTrue 메소드를 이용하여 테스트한다.
			 */
			User usersget1 = userDao.selectByEmail(users1.getEmail());
			assertThat(usersget1.getNickname(), is(users1.getNickname()));
			String password = passwordEncoder.encode("dkssud85!");
			assertTrue(passwordEncoder.matches(password, users1.getPassword()));
		}catch(CustomException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLog());
		}
	}

	//	@Test
	//	public void addAndGetBoard() throws CustomException {
	//		gameDao.deleteAll();
	//		assertThat(gameDao.getCount(), is(0));
	//
	//		userDao.deleteAllUsersAuthority();
	//		assertThat(userDao.getCountUsersAuthority(), is(0));
	//
	//		userDao.deleteAll();
	//		assertThat(userDao.getCount(), is(0));
	//
	//		// 사용자 3명 입력이 정상적으로 완료됐는지 확인 테스트
	//		userDao.insert(users1);
	//		assertThat(userDao.getCount(), is(1));
	//
	//		Game game = new Game(null, "게임입니다.", "타이틀", null, "D", null, "1.0");
	//		
	//		gameDao.insert(game);
	//		assertThat(gameDao.getCount(), is(1));
	//
	//		Game boardget1 = gameDao.select(gameDao.selectLastInsertId().toString());
	//		assertThat(boardget1.getTitle(), is(game.getTitle()));
	//		assertThat(boardget1.getDescription(), is(game.getDescription()));
	//	}

}
