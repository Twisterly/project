package by.masha.cha.dao;

import by.masha.cha.model.AppOrder;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppOrderDaoImplTest extends BaseDaoTest {

    @Autowired
    AppOrderDao targetObject;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void create() {

        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_app_order;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        AppOrder appOrder = new AppOrder();
        appOrder.setStartDate(Date.valueOf("2023-02-09"));
        appOrder.setStartTime(Time.valueOf("09:00:00"));
        appOrder.setEndDate(Date.valueOf("2023-02-12"));
        appOrder.setEndTime(Time.valueOf("09:00:00"));
        appOrder.setTotalSum(100.0);


        //When
        targetObject.create(appOrder);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_app_order;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from t_app_order;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppOrderDaoImplTest.class.getResourceAsStream(
                        "AppOrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        AppOrder appOrder = targetObject.findById("10000000-0000-0000-0000" +
                "-000000000001");

        //Then
        assertEquals(Date.valueOf("2023-02-02"), appOrder.getEndDate());
        assertEquals(Time.valueOf("21:00:00"), appOrder.getEndTime());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppOrderDaoImplTest.class.getResourceAsStream(
                        "AppOrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        AppOrder appOrder1 = targetObject.findById("10000000-0000-0000-0000" +
                "-000000000001");
        AppOrder appOrder2 = targetObject.findById("10000000-0000-0000-0000" +
                "-000000000002");
        assertNotNull(appOrder1);
        assertNotNull(appOrder2);
        targetObject.delete(appOrder1);
        targetObject.delete(appOrder2);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_app_order;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(0, actualSize);

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppOrderDaoImplTest.class.getResourceAsStream(
                        "AppOrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<AppOrder> appOrderList = targetObject.findAll();

        //Then
        assertEquals(2, appOrderList.size());
//        for(ModelDetail modelDetail: modelDetailList) {
//            assertTrue(modelDetail.getCar().size() > 0);
//        }
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }


}
