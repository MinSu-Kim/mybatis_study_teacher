package mybatis_study_teacher.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Course;
import mybatis_study_teacher.dto.CourseStat;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

public class CourseMapperImpl implements CourseMapper {
	private String namespace = "mybatis_study_teacher.mappers.CourseMapper";
	private static final CourseMapperImpl instance = new CourseMapperImpl();
	
	private CourseMapperImpl() {
		// TODO Auto-generated constructor stub
	}

	public static CourseMapperImpl getInstance() {
		return instance;
	}

	@Override
	public List<Course> selectCoursesByCondition(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCoursesByCondition", map);
		}
	}

	@Override
	public List<Course> selectCaseCourses(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCaseCourses", map);
		}
	}

	@Override
	public List<Course> selectWhereCourses(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectWhereCourses", map);
		}
	}

	@Override
	public List<Course> selectTrimCourses(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectTrimCourses", map);
		}
	}

	@Override
	public List<Course> selectCoursesForeachByTutors(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCoursesForeachByTutors", map);
		}
	}


	@Override
	public int insertCourses(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertCourses", map);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCourseGreaterId(int courseId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace + ".deleteCourseGreaterId", courseId);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Map<String, Object> getCourseCountByTutor(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
		ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {
			@Override
			public void handleResult(ResultContext<? extends CourseStat> resultContext) {
				CourseStat state = resultContext.getResultObject();
				map.put(state.getTutor(), state.getTotal());
			}
		};
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			sqlSession.select(namespace + ".getCourseCountByTutor", param, resultHandler);
			return map;
		}

	}

	@Override
	public Map<String, Object> getCourseCountByTutor2(Map<String, Object> param) {
	      Map<String, Object> map = new HashMap<>();
	      ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {
	         @Override
	         public void handleResult(ResultContext<? extends CourseStat> resultContext) {
	        	 CourseStat state = resultContext.getResultObject();
	            map.put(state.getTutor(), state.getTotal());
	         }
	      };
	      try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
		      sqlSession.select(namespace + ".getCourseCountByTutor2", param, resultHandler);
		      return map;
	      }

	}

	@Override
	public CourseStat getCourseCountByTutor3(int param) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".getCourseCountByTutor3", param);
		}
	}

	@Override
	public int insertCourse(Course course) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertCourse", course);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCourse(int courseId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res =  sqlSession.delete(namespace + ".deleteCourse", courseId);
			sqlSession.commit();
			return res;
		}
	}

}
