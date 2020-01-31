package mybatis_study_teacher.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.CourseStat;
import mybatis_study_teacher.mappers.impl.CourseMapperImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {
	private static CourseMapper dao;
	protected static final Log log = LogFactory.getLog(CourseMapperTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = CourseMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tutorId", 1);
       
        List<Course> courses = dao.selectCoursesByCondition(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
	}

	@Test
	public void test02SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseName", "%java%");
       
        List<Course> courses = dao.selectCoursesByCondition(map);
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
       
        List<Course> courses = dao.selectCoursesByCondition(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
	}
	
	@Test
    public void test04SelectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchBy", "Tutor");
        map.put("tutorId", 1);
        List<Course> courses = dao.selectCaseCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.replace("searchBy", "CourseName");
        map.remove("tutorId");
        map.put("courseName", "%java%");
        courses = dao.selectCaseCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
    }
	
    @Test
    public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Map<String, Object> map = new HashMap<String, Object>();

        List<Course> courses = dao.selectWhereCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.put("tutorId", 1);
        courses = dao.selectWhereCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.put("courseName", "%java%");
        courses = dao.selectWhereCourses(map);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.clear();
        map.put("endDate", new Date());
        courses = dao.selectWhereCourses(map);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
    }

    @Test
    public void test06SelectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Map<String, Object> map = new HashMap<String, Object>();
        List<Course> courses = dao.selectTrimCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.put("tutorId", 1);
        courses = dao.selectTrimCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.clear();
        map.put("courseName", "%java%");
        courses = dao.selectTrimCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
        
        map.clear();
        map.put("tutorId", 1);
        map.put("courseName", "%java%");
        courses = dao.selectTrimCourses(map);
        Assert.assertNotNull(courses);
        for(Course c : courses) {
        	log.trace(c.toString());
        }
    }
    
    @Test
    public void test07SelectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        List<Integer> tutorIds = new ArrayList<Integer>();
        tutorIds.add(1);
        tutorIds.add(2);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tutorIds", tutorIds);
        
        List<Course> courses = dao.selectCoursesForeachByTutors(map);
        Assert.assertNotNull(courses);
        
        for(Course c : courses) {
        	log.trace(c.toString());
        }
    }

    @Test
    public void test08insertCourses() {
    	log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        List<Course> tutors = new ArrayList<Course>();
        tutors.add(new Course(4, "mysql", "database", new Date(), new Date(), 3));
        tutors.add(new Course(5, "mssql", "database", new Date(), new Date(), 3));
        tutors.add(new Course(6, "mariaDb", "database", new Date(), new Date(), 4));
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tutors", tutors);
        
        int res = dao.insertCourses(map);
        Assert.assertEquals(3, res);
    }
    
    @Test
    public void test10DeleteCourseGreaterId() {
    	log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    	int res = dao.deleteCourseGreaterId(2);
    	Assert.assertNotEquals(0, res);
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    @Test
    public void test11getCourseCountByTutor() {
       log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
       Map<String, Object> param = new HashMap<>();
       param.put("tutor_id", 1);
       Map<String,Object> map= dao.getCourseCountByTutor(param);
       Assert.assertNotEquals(0, map.size());
    }

    @Test
    public void test12getCourseCountByTutor2() {
       log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
       Map<String, Object> param = new HashMap<>();
       param.put("tutor_id", 1);
       Map<String,Object> map= dao.getCourseCountByTutor2(param);
       Assert.assertNotEquals(0, map.size());
    }

    @Test
    public void test12getCourseCountByTutor3() {
       log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
       CourseStat stat = dao.getCourseCountByTutor3(1);
       Assert.assertNotNull(stat);

    }
}
