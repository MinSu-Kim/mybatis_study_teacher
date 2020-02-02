package mybatis_study_teacher.mappers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Student;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;
import mybatis_study_teacher.mappers.StudentMapper;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "mybatis_study_teacher.mappers.StudentMapper";
	private static final StudentMapperImpl instance = new StudentMapperImpl();

	private StudentMapperImpl() {
		// TODO Auto-generated constructor stub
	}

	public static StudentMapperImpl getInstance() {
		return instance;
	}

	@Override
	public Student selectStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
		}
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectStudentByAll");
		}
	}

	@Override
	public int insertStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int insertStudentAutoInc(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertStudentAutoInc", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteStudent(int id) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace + ".deleteStudent", id);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace + ".updateStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<Student> selectStudentByAllForResutlMap() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectStudentByAllForResutlMap");
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectStudentByAllForHashMap");
		}
	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectStudentByNoAssociation", student);
		}
	}

	@Override
	public int insertEnumStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertEnumStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Student selectAllStudentByMap(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectAllStudentByMap", map);
		}
	}

	@Override
	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student.getName());
			}
		};
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
			return map;
		}
	}

	@Override
	public int updateSetStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace + ".updateSetStudent", student);
			sqlSession.commit();
			return res;
		}
	}

}
