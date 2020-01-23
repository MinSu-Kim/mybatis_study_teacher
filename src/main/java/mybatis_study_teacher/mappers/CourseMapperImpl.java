package mybatis_study_teacher.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Course;

public class CourseMapperImpl implements CourseMapper {
	private String namespace = "mybatis_study_teacher.mappers.CourseMapper";

	@Override
	public List<Course> selectCoursesByCondition(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectList(namespace + ".selectCoursesByCondition", map);
	}

	@Override
	public List<Course> selectCaseCourses(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectList(namespace + ".selectCaseCourses", map);
	}

	@Override
	public List<Course> selectWhereCourses(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectList(namespace + ".selectWhereCourses", map);
	}

}
