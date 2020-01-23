package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.Tutor;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

public class TutorMapperTest {
	private static SqlSession sqlSession;
	private static TutorMapper dao;
	protected static final Log log = LogFactory.getLog(TutorMapperTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao = new TutorMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sqlSession.close();
		dao = null;
	}

	@Test
	public void testSelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = dao.selectTutorByTutorId(sqlSession, findTutor);

		Assert.assertEquals(tutor.getTutorId(), findTutor.getTutorId());
		
		log.trace(tutor.getTutorId() + " : " + tutor.getName());
		List<Course> courses = tutor.getCourses();
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}

}
