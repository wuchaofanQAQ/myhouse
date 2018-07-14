import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class TestJDBC {

    @Resource
    BasicDataSource dataSource;

    @Test
    public void getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
    }
}
