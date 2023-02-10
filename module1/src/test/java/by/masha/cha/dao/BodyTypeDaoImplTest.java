package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class BodyTypeDaoImplTest extends BaseDaoTest {

    @Autowired
    BodyTypeDao targetObject;

    @Before
    public void setUp() throws Exception {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_body_type;");
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
                "from t_body_type;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        BodyType bodyType = new BodyType();
        bodyType.setBodyTypeName("coupe");

        //When
        targetObject.create(bodyType);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_body_type;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from t_body_type;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BodyTypeDaoImplTest.class.getResourceAsStream(
                        "BodyTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        BodyType bodyType = targetObject.findById(200);

        //Then
        assertEquals("sedan", bodyType.getBodyTypeName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BodyTypeDaoImplTest.class.getResourceAsStream(
                        "BodyTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        BodyType bodyType1 = targetObject.findById(200);
        BodyType bodyType2 = targetObject.findById(201);
        assertNotNull(bodyType1);
        assertNotNull(bodyType2);
        targetObject.delete(bodyType1);
        targetObject.delete(bodyType2);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_body_type;");
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
                .build(BodyTypeDaoImplTest.class.getResourceAsStream(
                        "BodyTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                dataSet);

        //When
        List<BodyType> bodyTypeList = targetObject.findAll();

        //Then
        assertEquals(2, bodyTypeList.size());
//        for(ModelDetail modelDetail: modelDetailList) {
//            assertTrue(modelDetail.getCar().size() > 0);
//        }
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                dataSet);
    }

    @Test
    @SneakyThrows
    public void findAllBodyTypeNames() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(BodyTypeDaoImplTest.class.getResourceAsStream(
                        "BodyTypeDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<String> bodyTypeNames = targetObject.findAllBodyTypeNames();

        //Then
        assertEquals(2, bodyTypeNames.size());
        assertEquals("sedan", bodyTypeNames.get(0));

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

}