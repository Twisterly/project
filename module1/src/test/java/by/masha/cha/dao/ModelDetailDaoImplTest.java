package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ModelDetailDaoImplTest extends BaseDaoTest {

    @Autowired
    ModelDetailDao targetObject;

    @Before
    public void setUp() throws SQLException {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from t_model_detail;");
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
                "from t_model_detail;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        ModelDetail modelDetail = new ModelDetail();
        modelDetail.setModelName("rio");
//        List<ModelDetail> models = new ArrayList<>();
//        models.add(modelDetail);

        Brand brand = new Brand();
        brand.setBrandName("kia");

//        modelDetail.setBrand(brand);
//        brand.setModelDetails(models);

        //When
        targetObject.create(modelDetail);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from " +
                "t_model_detail;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);


        conn.createStatement().executeUpdate("delete from t_model_detail;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findAllModelNames() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(ModelDetailDaoImplTest.class.getResourceAsStream(
                        "ModelDetailDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<String> modelNames = targetObject.findAllModelNames();

        //Then
        assertEquals(2, modelNames.size());
        assertEquals("x5", modelNames.get(1));

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(ModelDetailDaoImplTest.class.getResourceAsStream(
                        "ModelDetailDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        ModelDetail modelDetail = targetObject.findById(1);

        //Then
        assertEquals("sportage", modelDetail.getModelName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(ModelDetailDaoImplTest.class.getResourceAsStream(
                        "ModelDetailDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        ModelDetail modelDetail = targetObject.findById(1);
        ModelDetail modelDetail1 = targetObject.findById(2);
        assertNotNull(modelDetail);
        assertNotNull(modelDetail1);
        targetObject.delete(modelDetail);
        targetObject.delete(modelDetail1);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) " +
                "from t_model_detail;");
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

        IDataSet modelDetailDataSet = new FlatXmlDataSetBuilder()
                .build(ModelDetailDaoImplTest.class.getResourceAsStream(
                        "ModelDetailDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection,
                modelDetailDataSet);

        //When
        List<ModelDetail> modelDetailList = targetObject.findAll();

        //Then
        assertEquals(2, modelDetailList.size());

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection,
                modelDetailDataSet);
    }

}
