package mybatis_study_teacher.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Course;

public interface CourseMapper {
	List<Course> selectCoursesByCondition(SqlSession sqlSession, Map<String, Object> map);
	List<Course> selectCaseCourses(SqlSession sqlSession, Map<String, Object> map);
	List<Course> selectWhereCourses(SqlSession sqlSession, Map<String, Object> map);
	List<Course> selectTrimCourses(SqlSession sqlSession, Map<String, Object> map);

}
