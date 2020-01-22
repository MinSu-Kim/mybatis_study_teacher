package mybatis_study_teacher.mappers;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import mybatis_study_teacher.dto.Student;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperTest {
	private static SqlSession sqlSession;
	private static StudentMapper dao;
	protected static final Log log = LogFactory.getLog(StudentMapperTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao = new StudentMapperImpl();
	}

	@Test
	public void testSelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	    Student student = new Student();
	    student.setStudId(1);
		Student selectStudent = dao.selectStudentByNo(sqlSession, student);
	    log.debug(selectStudent.toString());
	    Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}

}
