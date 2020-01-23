package mybatis_study_teacher.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(SqlSession sqlSession, Student student);
	Student selectStudentByNoWithResultMap(SqlSession sqlSession, Student student);
	
	List<Student> selectStudentByAll(SqlSession sqlSession);
	
	int insertStudent(SqlSession sqlSession, Student student);
	int insertStudentAutoInc(SqlSession sqlSession, Student student);

	int deleteStudent(SqlSession sqlSession, int id);
	
	int updateStudent(SqlSession sqlSession, Student student);
	
	/* resultMap */
	List<Student> selectStudentByAllForResutlMap(SqlSession sqlSession);

	/* hashMap */
	List<Map<String, Object>> selectStudentByAllForHashMap(SqlSession sqlSession);

	/* 내포된 결과매핑(ResultMap)을 사용한 일대일 매핑 */
	Student selectStudentByNoAssociation(SqlSession sqlSession, Student student);

	/* enum 타입 다루기 */
    int insertEnumStudent(SqlSession sqlSession, Student student);

	/* 여러 개의 입력 파라미터 전달 */
    Student selectAllStudentByMap(SqlSession sqlSession, Map<String, String> map);

}


