package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class BrandDaoImplTest extends BaseDaoTest {

    @Autowired
    BrandDao targetObject;

    @Before
    public void setUp() throws SQLException {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_car_brand;");
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
                "from t_car_brand;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        Brand brand = new Brand();
        brand.setBrandName("FERRARI");

        //When
        targetObject.create(brand);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_car_brand;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from t_car_brand;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BrandDaoImplTest.class.getResourceAsStream(
                        "BrandDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        Brand brand = targetObject.findById(202);

        //Then
        assertEquals("FIAT", brand.getBrandName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BrandDaoImplTest.class.getResourceAsStream(
                        "BrandDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        Brand brand1 = targetObject.findById(200);
        Brand brand2 = targetObject.findById(201);
        Brand brand3 = targetObject.findById(202);
        Brand brand4 = targetObject.findById(203);
        assertNotNull(brand1);
        assertNotNull(brand2);
        assertNotNull(brand3);
        assertNotNull(brand4);
        targetObject.delete(brand1);
        targetObject.delete(brand2);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_car_brand;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(2, actualSize);

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BrandDaoImplTest.class.getResourceAsStream(
                        "BrandDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<Brand> bodyTypeList = targetObject.findAll();

        //Then
        assertEquals(4, bodyTypeList.size());

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }

    @Test
    @SneakyThrows
    public void findAllBrandNames() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BrandDaoImplTest.class.getResourceAsStream(
                        "BrandDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<String> brandNames = targetObject.findAllBrandNames();

        //Then
        assertEquals(4, brandNames.size());
        assertEquals("BMW", brandNames.get(1));

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findByBrandName() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BrandDaoImplTest.class.getResourceAsStream(
                        "BrandDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        Brand brand = targetObject.findByBrandName("FIAT");

        //Then
        assertEquals(202, brand.getId());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

}

