package by.masha.cha.dao;

import by.masha.cha.model.*;
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

    @Autowired
    CarDao carDao;
    @Autowired
    BrandDao brandDao;
    @Autowired
    ModelDetailDao modelDetailDao;
    @Autowired
    FuelTypeDao fuelTypeDao;
    @Autowired
    TransmissionTypeDao transmissionTypeDao;
    @Autowired
    BodyTypeDao bodyTypeDao;
    @Autowired
    AppUserDao appUserDao;

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

        Brand brand = new Brand();
        brand.setBrandName("audi");
        brandDao.create(brand);

        BodyType bodyType = new BodyType();
        bodyType.setBodyTypeName("sedan");
        bodyTypeDao.create(bodyType);

        ModelDetail modelDetail = new ModelDetail();
        modelDetail.setModelName("a4");
        modelDetailDao.create(modelDetail);

        TransmissionType transmissionType = new TransmissionType();
        transmissionType.setTransmissionTypeName("automatic");
        transmissionTypeDao.create(transmissionType);

        FuelType fuelType = new FuelType();
        fuelType.setFuelTypeName("petrol");
        fuelTypeDao.create(fuelType);

        CarPhoto carPhoto = new CarPhoto();

        Car car = new Car();
        carPhoto.setCar(car);
        car.setPrice(20.0);
        car.setBrand(brand);
        car.setModelDetail(modelDetail);
        car.setBodyType(bodyType);
        car.setCarPhoto(carPhoto);
        car.setTransmissionType(transmissionType);
        car.setFuelType(fuelType);
        carDao.create(car);

        AppUser appUser = new AppUser();
        appUser.setUsername("masha1990");
        appUser.setPassword("qwerty");
        appUser.setEmail("masha1990@gmail.com");
        appUser.setFirstName("Masha");
        appUser.setLastName("Ivanova");
        appUserDao.create(appUser);


        AppOrder appOrder = new AppOrder();
        appOrder.setCar(car);
        appOrder.setAppUser(appUser);
        appOrder.setStartDate(Date.valueOf("2023-02-09"));
        appOrder.setEndDate(Date.valueOf("2023-02-12"));
        appOrder.setCancellation(false);
        appOrder.setTimeOfCancellation(Timestamp.valueOf("2000-01-01 03:00:00"));

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
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }

    @Test
    @SneakyThrows
    public void findAllByUserId() {
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppOrderDaoImplTest.class.getResourceAsStream(
                        "AppOrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<AppOrder> appOrderList = targetObject.findAllByUserId("12300000" +
                "-0000-0000-0000-000000000123");

        //Then
        assertEquals(2, appOrderList.size());

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }

    @Test
    @SneakyThrows
    public void findAllByCarId() {
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AppOrderDaoImplTest.class.getResourceAsStream(
                        "AppOrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<AppOrder> appOrderList = targetObject.findAllActiveByCarId("12300000" +
                "-0000-0000-0000-000000000111");


        //Then
        assertEquals(1, appOrderList.size());

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }


}
