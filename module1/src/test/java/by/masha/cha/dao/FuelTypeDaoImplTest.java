package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.FuelType;
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
public class FuelTypeDaoImplTest extends BaseDaoTest{

    @Autowired
    FuelTypeDao targetObject;

    @Before
    public void setUp() throws SQLException {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_fuel_type;");
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
                "from t_fuel_type;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        FuelType fuelType = new FuelType();
        fuelType.setFuelTypeName("petrol");

        //When
        targetObject.create(fuelType);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_fuel_type;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from t_fuel_type;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(FuelTypeDaoImplTest.class.getResourceAsStream(
                        "FuelTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        FuelType fuelType = targetObject.findById(100);

        //Then
        assertEquals("petrol", fuelType.getFuelTypeName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(FuelTypeDaoImplTest.class.getResourceAsStream(
                        "FuelTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        FuelType fuelType1 = targetObject.findById(100);
        FuelType fuelType2 = targetObject.findById(101);
        FuelType fuelType3 = targetObject.findById(102);
        FuelType fuelType4 = targetObject.findById(103);
        assertNotNull(fuelType1);
        assertNotNull(fuelType2);
        assertNotNull(fuelType3);
        assertNotNull(fuelType4);
        targetObject.delete(fuelType1);
        targetObject.delete(fuelType2);
        targetObject.delete(fuelType3);
        targetObject.delete(fuelType4);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_fuel_type;");
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
                .build(FuelTypeDaoImplTest.class.getResourceAsStream(
                        "FuelTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<FuelType> fuelTypeList = targetObject.findAll();

        //Then
        assertEquals(4, fuelTypeList.size());
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }

    @Test
    @SneakyThrows
    public void findAllBodyTypeNames() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(FuelTypeDaoImplTest.class.getResourceAsStream(
                        "FuelTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<String> fuelTypeNames = targetObject.findAllFuelTypeNames();

        //Then
        assertEquals(4, fuelTypeNames.size());
        assertEquals("electricity", fuelTypeNames.get(3));

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

}

