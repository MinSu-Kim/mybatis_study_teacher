package mybatis_study_teacher.services;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.Tutor;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;
import mybatis_study_teacher.mappers.CourseMapper;
import mybatis_study_teacher.mappers.CourseMapperImpl;
import mybatis_study_teacher.mappers.TutorMapper;
import mybatis_study_teacher.mappers.TutorMapperImpl;

public class CourseUiService {
	private CourseMapper courseDao;
	private TutorMapper tutorDao;
	private SqlSession sqlSession;

	public CourseUiService() {
		courseDao = new CourseMapperImpl();
		tutorDao = new TutorMapperImpl();

	}

	public void joinNewTutorAndCourse(Tutor tutor, Course course) {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		int res = 0;
		try {
			res += tutorDao.insertTutor(sqlSession, tutor);
			res += courseDao.insertCourse(sqlSession, course);
			if (res == 2)
				sqlSession.commit();
			else
				throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}

	public void removeTutorAndCourse(int tutorId, int courseId) {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		int res = 0;
		try {
			res += courseDao.deleteCourse(sqlSession, courseId);
			res += tutorDao.deleteTutor(sqlSession, tutorId);
			if (res == 2)
				sqlSession.commit();
			else
				throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}
}
