package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.UserPic;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "mybatis_study_teacher.mappers.UserPicMapper";
	private static final UserPicMapperImpl instance = new UserPicMapperImpl();

	private UserPicMapperImpl() {
		// TODO Auto-generated constructor stub
	}

	public static UserPicMapperImpl getInstance() {
		return instance;
	}

	@Override
	public int insertUserPic(UserPic userPic) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertUserPic", userPic);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public UserPic getUserPic(int id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".getUserPic", id);
		}
	}

}
