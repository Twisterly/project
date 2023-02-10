package by.masha.cha.dao;

import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;
import lombok.SneakyThrows;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
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
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_app_user;");
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    public void findByUserName() throws SQLException, DatabaseUnitException {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_app_user;");
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppUserDaoImplTest.class.getResourceAsStream(
                        "AppUserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<AppUser> userList = targetObject.findByUserName("Maasha");
        //Then
        assertNotNull(userList);
        assertEquals(1, userList.size());
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    public void create() throws SQLException {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_app_user;");
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_app_user;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        AppUser appUser = new AppUser();
        appUser.setUsername("bublik2018");
        appUser.setPassword("qwerty");

        //When
        targetObject.create(appUser);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_app_user;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from t_app_user ");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_app_user;");
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppUserDaoImplTest.class.getResourceAsStream(
                        "AppUserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<AppUser> appUsers = targetObject.findAll();

        //Then
        assertEquals(appUsers.size(), 2);
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_app_user;");
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppUserDaoImplTest.class.getResourceAsStream
                        ("AppUserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        AppUser appUser = targetObject.findById("12300000-0000-0000-0000" +
                "-000000000123");
        assertNotNull(appUser);
        targetObject.delete(appUser);

        //Then
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_app_user;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void update() {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_app_user;");
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppUserDaoImplTest.class.getResourceAsStream(
                        "AppUserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        AppUser appUser = targetObject.findById("12300000-0000-0000-0000" +
                "-000000000123");
        appUser.setEmail("chachik@gmail.com");
        targetObject.update(appUser);
        //Then

        assertEquals("chachik@gmail.com", appUser.getEmail());
       DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}



