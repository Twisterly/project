package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.TransmissionType;
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
public class TransmissionTypeDaoImplTest extends BaseDaoTest {

    @Autowired
    TransmissionTypeDao targetObject;

    @Before
    public void setUp() throws SQLException {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_transmission_type;");
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
                "from t_transmission_type;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        TransmissionType transmissionType = new TransmissionType();
        transmissionType.setTransmissionTypeName("manual");

        //When
        targetObject.create(transmissionType);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_transmission_type;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from " +
                "t_transmission_type;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(TransmissionTypeDaoImplTest.class.getResourceAsStream(
                        "TransmissionTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        TransmissionType transmissionType = targetObject.findById(500);

        //Then
        assertEquals("automatic", transmissionType.getTransmissionTypeName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(TransmissionTypeDaoImplTest.class.getResourceAsStream(
                        "TransmissionTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        TransmissionType transmissionType1 = targetObject.findById(500);
        TransmissionType transmissionType2 = targetObject.findById(501);
        assertNotNull(transmissionType1);
        assertNotNull(transmissionType2);
        targetObject.delete(transmissionType1);
        targetObject.delete(transmissionType2);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_transmission_type;");
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
                .build(TransmissionTypeDaoImplTest.class.getResourceAsStream(
                        "TransmissionTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<TransmissionType> transmissionTypeList = targetObject.findAll();

        //Then
        assertEquals(2, transmissionTypeList.size());

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }

    @Test
    @SneakyThrows
    public void findAllBrandNames() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(TransmissionTypeDaoImplTest.class.getResourceAsStream(
                        "TransmissionTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<String> transmissionTypeNames =
                targetObject.findAllTransmissionTypeNames();

        //Then
        assertEquals(2, transmissionTypeNames.size());
        assertEquals("manual", transmissionTypeNames.get(1));

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

}


