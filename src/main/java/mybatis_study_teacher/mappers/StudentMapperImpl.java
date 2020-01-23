package mybatis_study_teacher.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Student;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "mybatis_study_teacher.mappers.StudentMapper";
	
	@Override
	public Student selectStudentByNo(SqlSession sqlSession, Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
	}

	@Override
	public Student selectStudentByNoWithResultMap(SqlSession sqlSession, Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap", student);
	}

	@Override
	public List<Student> selectStudentByAll(SqlSession sqlSession) {
		return sqlSession.selectList(namespace + ".selectStudentByAll");
	}

	@Override
	public int insertStudent(SqlSession sqlSession, Student student) {
		int res = sqlSession.insert(namespace + ".insertStudent", student);
        sqlSession.commit();
        return res;
	}

	@Override
	public int insertStudentAutoInc(SqlSession sqlSession, Student student) {
		int res = sqlSession.insert(namespace + ".insertStudentAutoInc", student);
        sqlSession.commit();
        return res;
	}

	@Override
	public int deleteStudent(SqlSession sqlSession, int id) {
		int res = sqlSession.delete(namespace + ".deleteStudent", id);
        sqlSession.commit();
        return res;
	}

	@Override
	public int updateStudent(SqlSession sqlSession, Student student) {
		int res = sqlSession.update(namespace + ".updateStudent", student);
		sqlSession.commit();
		return res;
	}

	@Override
	public List<Student> selectStudentByAllForResutlMap(SqlSession sqlSession) {
		return sqlSession.selectList(namespace + ".selectStudentByAllForResutlMap");
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap(SqlSession sqlSession) {
		return sqlSession.selectList(namespace + ".selectStudentByAllForHashMap");
	}

}
