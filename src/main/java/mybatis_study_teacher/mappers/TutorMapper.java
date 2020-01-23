package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(SqlSession sqlSession, Tutor tutor);
	
	/* transaction */
	int insertTutor(SqlSession sqlSession, Tutor tutor);
	int deleteTutor(SqlSession sqlSession, int tutorId);
}
