package by.masha.cha.dao;

import by.masha.cha.DataConfig;
import by.masha.cha.MysqlJdbcDataSource;
import lombok.SneakyThrows;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:/rent_test.jdbc.properties")
@ContextConfiguration(classes = DataConfig.class)
public class BaseDaoTest {

    // JDBC data source
    static MysqlJdbcDataSource testMysqlJdbcDataSource;
    // DBUnit connection
    static IDatabaseConnection iDatabaseConnection;


    @BeforeClass
    @SneakyThrows
    public static void init() {
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("rent_test.jdbc.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "rent_test");
    }

}
