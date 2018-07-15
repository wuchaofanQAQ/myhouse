import com.story.dao.UserDao;
import com.story.domain.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBC Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class TestJDBC {

    @Resource
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void getConnection() throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserInfo> allUser = userDao.getAllUser();
        for (UserInfo userInfo : allUser) {
            System.out.println(userInfo);
        }
    }

    @Resource
    UserDao userDao;

    @Test
    public void testQueryUser(){
        List<UserInfo> allUser = userDao.getAllUser();
        for (UserInfo userInfo : allUser) {
            System.out.println(userInfo);
        }

    }

}
