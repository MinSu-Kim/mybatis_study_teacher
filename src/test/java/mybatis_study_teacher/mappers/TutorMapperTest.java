package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.Tutor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorMapperTest {
	private static TutorMapperImpl dao;
	protected static final Log log = LogFactory.getLog(TutorMapperTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = TutorMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = dao.selectTutorByTutorId(findTutor);

		Assert.assertEquals(tutor.getTutorId(), findTutor.getTutorId());
		
		log.trace(tutor.getTutorId() + " : " + tutor.getName());
		List<Course> courses = tutor.getCourses();
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	@Test
	public void test02InsertTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Tutor tutor = new Tutor();
		tutor.setTutorId(6);
		tutor.setName("test");
		tutor.setEmail("test@tset.co.kr");
		
		int res = dao.insertTutor(tutor);

		Assert.assertEquals(1, res);
		
	}
	
	@Test
	public void test03DeleteTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Tutor tutor = new Tutor();
		tutor.setTutorId(6);
		
		int res = dao.deleteTutor(tutor.getTutorId());

		Assert.assertEquals(1, res);
	}
	
}
