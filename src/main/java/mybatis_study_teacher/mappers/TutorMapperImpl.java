package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Tutor;

public class TutorMapperImpl implements TutorMapper {
	private String namespace = "mybatis_study_teacher.mappers.TutorMapper";

	@Override
	public Tutor selectTutorByTutorId(SqlSession sqlSession, Tutor tutor) {
		return sqlSession.selectOne(namespace + ".selectTutorByTutorId", tutor);
	}

}
