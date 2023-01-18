package by.masha.cha.dao;

import by.masha.cha.model.*;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarDaoImplTest extends BaseDaoTest {
    @Autowired
    CarDao targetObject;

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
                "from t_car;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        Car car = new Car();
        car.setPrice(20.0);
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        Brand brand = new Brand();
        brand.setBrandName("ferrari");

        BodyType bodyType = new BodyType();
        bodyType.setBodyTypeName("sedan");

        TransmissionType transmissionType = new TransmissionType();
        transmissionType.setTransmissionTypeName("automatic");

        FuelType fuelType = new FuelType();
        fuelType.setFuelTypeName("petrol");

        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setName("x6Photo");

        car.setBrand(brand);
        car.setBodyType(bodyType);
        car.setCarPhoto(carPhoto);
        car.setTransmissionType(transmissionType);
        car.setFuelType(fuelType);
        bodyType.setCar(cars);
        carPhoto.setCar(cars);
        brand.setCar(cars);
        transmissionType.setCar(cars);
        fuelType.setCar(cars);

        //When
        targetObject.create(car);

        rs = conn.createStatement().executeQuery("select count(*) from t_car;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table t_car_brand;");
        conn.createStatement().executeUpdate("truncate table t_body_type;");
        conn.createStatement().executeUpdate("truncate table t_car_photo;");
        conn.createStatement().executeUpdate("truncate table t_model_detail;");
        conn.createStatement().executeUpdate("truncate table t_transmission_type;");
        conn.createStatement().executeUpdate("truncate table t_fuel_type;");
        conn.createStatement().executeUpdate("truncate table t_car;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(CarDaoImplTest.class.getResourceAsStream(
                        "CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);
        Car car = targetObject.findById(101);

        //Then
        assertEquals("7434CK-7", car.getRegNumber());
        assertEquals(200, car.getCarPhoto().getId());
        assertEquals("sedan", car.getBodyType().getBodyTypeName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    @Ignore
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(CarDaoImplTest.class.getResourceAsStream
                        ("CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        Car car = targetObject.findById(102);
        assertNotNull(car);
        targetObject.delete(car);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_car;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(CarDaoImplTest.class.getResourceAsStream(
                        "CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<Car> cars = targetObject.findAll();

        //Then
        assertEquals(cars.size(), 2);
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}
