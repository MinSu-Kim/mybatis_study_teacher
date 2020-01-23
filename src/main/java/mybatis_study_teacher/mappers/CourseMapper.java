package mybatis_study_teacher.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.CourseStat;

public interface CourseMapper {
	List<Course> selectCoursesByCondition(SqlSession sqlSession, Map<String, Object> map);
	List<Course> selectCaseCourses(SqlSession sqlSession, Map<String, Object> map);
	List<Course> selectWhereCourses(SqlSession sqlSession, Map<String, Object> map);
	List<Course> selectTrimCourses(SqlSession sqlSession, Map<String, Object> map);

	List<Course> selectCoursesForeachByTutors(SqlSession sqlSession, Map<String, Object> map);

	/* foreach */
	int insertCourses(SqlSession sqlSession, Map<String, Object> map);

	/* transaction */
	int insertCourse(SqlSession sqlSession, Course course);
	int deleteCourse(SqlSession sqlSession, int courseId);
	int deleteCourseGreaterId(SqlSession sqlSession, int courseId);
	
	/* procedure */
	Map<String, Object> getCourseCountByTutor(SqlSession sqlSession, Map<String, Object> param);
    Map<String, Object> getCourseCountByTutor2(SqlSession sqlSession, Map<String, Object> param);
    CourseStat getCourseCountByTutor3(SqlSession sqlSession, int param);

}
