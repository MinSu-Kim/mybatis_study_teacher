package mybatis_study_teacher.mappers;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {
	private static SqlSession sqlSession;
	private static CourseMapper dao;
	protected static final Log log = LogFactory.getLog(CourseMapperTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao = new CourseMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sqlSession.close();
		dao = null;
	}

	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tutorId", 1);
       
        List<Course> courses = dao.selectCoursesByCondition(sqlSession, map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
	}

	@Test
	public void test02SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseName", "%java%");
       
        List<Course> courses = dao.selectCoursesByCondition(sqlSession, map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
	}
	
	@Test
	public void test03SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", cal.getTime());
       
        List<Course> courses = dao.selectCoursesByCondition(sqlSession, map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
	}
}
