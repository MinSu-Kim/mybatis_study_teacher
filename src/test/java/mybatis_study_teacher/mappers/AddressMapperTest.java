package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import mybatis_study_teacher.dto.Address;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

public class AddressMapperTest {
	private static SqlSession sqlSession;
	private static AddressMapper dao;
	protected static final Log log = LogFactory.getLog(AddressMapperTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao = new AddressMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sqlSession.close();
		dao = null;
	}

	@Test
	public void testSelectAddressByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		RowBounds rowBounds_0 = new RowBounds(0, 2);
		List<Address> lists = dao.selectAddressByAll(sqlSession, rowBounds_0);
		Assert.assertNotNull(lists);
		for(Address addr : lists) {
			log.trace(addr.toString());
		}
			
		RowBounds rowBounds_2 = new RowBounds(2, 2);
		lists = dao.selectAddressByAll(sqlSession, rowBounds_2);
	    Assert.assertNotNull(lists);
	    for(Address addr : lists) {
			log.trace(addr.toString());
		}
	}

}
