package mybatis_study_teacher.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

public class HikariCPFactoryTest {
	protected static final Log log = LogFactory.getLog(HikariCPFactoryTest.class);
	
	@Test
	public void testGetDataSource() {
		HikariCPFactory factory = new HikariCPFactory();
		DataSource ds = factory.getDataSource();
		Assert.assertNotNull(ds);
		log.trace(ds.toString());
		try {
			Connection con = ds.getConnection();
			log.trace(con.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
