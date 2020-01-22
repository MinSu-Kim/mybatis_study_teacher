package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(SqlSession sqlSession, Student student);
}


