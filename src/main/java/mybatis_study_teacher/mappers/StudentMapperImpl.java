package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Student;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "mybatis_study_teacher.mappers.StudentMapper";
	
	@Override
	public Student selectStudentByNo(SqlSession sqlSession, Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
	}

}
