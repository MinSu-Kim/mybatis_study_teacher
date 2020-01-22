package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(SqlSession sqlSession, Student student);
	Student selectStudentByNoWithResultMap(SqlSession sqlSession, Student student);
	
	List<Student> selectStudentByAll(SqlSession sqlSession);
	
	int insertStudent(SqlSession sqlSession, Student student);

}


