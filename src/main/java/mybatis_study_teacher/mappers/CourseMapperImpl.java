package mybatis_study_teacher.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.CourseStat;

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

	@Override
	public List<Course> selectTrimCourses(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectList(namespace + ".selectTrimCourses", map);
	}

	@Override
	public List<Course> selectCoursesForeachByTutors(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectList(namespace + ".selectCoursesForeachByTutors", map);
	}

	@Override
	public int insertCourses(SqlSession sqlSession, Map<String, Object> map) {
		int res = sqlSession.insert(namespace + ".insertCourses", map);
		sqlSession.commit();
		return res;
	}

	@Override
	public int insertCourse(SqlSession sqlSession, Course course) {
		int res = sqlSession.insert(namespace + ".insertCourse", course);
		sqlSession.commit();
		return res;
	}

	@Override
	public int deleteCourseGreaterId(SqlSession sqlSession, int courseId) {
		int res = sqlSession.delete(namespace + ".deleteCourseGreaterId", courseId);
		sqlSession.commit();
		return res;
	}

	@Override
	public int deleteCourse(SqlSession sqlSession, int courseId) {
		int res = sqlSession.delete(namespace + ".deleteCourse", courseId);
		sqlSession.commit();
		return res;
	}

	@Override
	public Map<String, Object> getCourseCountByTutor(SqlSession sqlSession, Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
		ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {
			@Override
			public void handleResult(ResultContext<? extends CourseStat> resultContext) {
				CourseStat state = resultContext.getResultObject();
				map.put(state.getTutor(), state.getTotal());
			}
		};

		sqlSession.select(namespace + ".getCourseCountByTutor", param, resultHandler);
		return map;

	}

	@Override
	public Map<String, Object> getCourseCountByTutor2(SqlSession sqlSession, Map<String, Object> param) {
	      Map<String, Object> map = new HashMap<>();
	      ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {
	         @Override
	         public void handleResult(ResultContext<? extends CourseStat> resultContext) {
	        	 CourseStat state = resultContext.getResultObject();
	            map.put(state.getTutor(), state.getTotal());
	         }
	      };

	      sqlSession.select(namespace + ".getCourseCountByTutor2", param, resultHandler);
	      return map;

	}

	@Override
	public CourseStat getCourseCountByTutor3(SqlSession sqlSession, int param) {
        return sqlSession.selectOne(namespace + ".getCourseCountByTutor3", param);
	}

}
