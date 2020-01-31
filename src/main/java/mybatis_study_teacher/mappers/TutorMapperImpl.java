package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Tutor;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

public class TutorMapperImpl implements TutorMapper {
	private String namespace = "mybatis_study_teacher.mappers.TutorMapper";
	private static final TutorMapperImpl instance = new TutorMapperImpl();
	
	private TutorMapperImpl() {}
	
	public static TutorMapperImpl getInstance() {
		return instance;
	}

	@Override
	public Tutor selectTutorByTutorId(Tutor tutor) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectTutorByTutorId", tutor);
		}
	}

	@Override
	public int insertTutor(Tutor tutor) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+ ".insertTutor", tutor);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteTutor(int tutorId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace+ ".deleteTutor", tutorId);
			sqlSession.commit();
			return res;
		}
	}

}
