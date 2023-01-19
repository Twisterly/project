package by.masha.cha.dao;

import by.masha.cha.model.AppUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppUserDaoImplTest extends BaseDaoTest {

    @Autowired
    AppUserDao targetObject;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    public void findByUserName() {
        //When
        List<AppUser> userList = targetObject.findByUserName("root");
        //Then
        assertNotNull(userList);
        assertEquals(1, userList.size());

    }
    @Test
    public void create() throws SQLException {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from app_user;");
        rs.next();
        int initialSize = rs.getInt(1);
//        assertEquals(1, initialSize);
       AppUser appUser = new AppUser();
       appUser.setUsername("bublik2018");
       appUser.setPassword("qwerty");

        //When
        targetObject.create(appUser);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "app_user;");
        rs.next();
        int actualSize = rs.getInt(1);
//        assertEquals(2, actualSize);


        conn.createStatement().executeUpdate("delete AppUser where username='bublik2018';");
        conn.close();
    }

}
