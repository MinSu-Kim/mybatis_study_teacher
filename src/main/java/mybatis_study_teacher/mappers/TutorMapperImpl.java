package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Tutor;

public class TutorMapperImpl implements TutorMapper {
	private String namespace = "mybatis_study_teacher.mappers.TutorMapper";

	@Override
	public Tutor selectTutorByTutorId(SqlSession sqlSession, Tutor tutor) {
		return sqlSession.selectOne(namespace + ".selectTutorByTutorId", tutor);
	}

	@Override
	public int insertTutor(SqlSession sqlSession, Tutor tutor) {
		int res = sqlSession.insert(namespace + ".insertTutor", tutor);
        sqlSession.commit();
        return res;
	}

	@Override
	public int deleteTutor(SqlSession sqlSession, int tutorId) {
		int res = sqlSession.delete(namespace + ".deleteTutor", tutorId);
        sqlSession.commit();
        return res;
	}

}
