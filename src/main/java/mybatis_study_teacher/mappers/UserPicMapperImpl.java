package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.UserPic;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "mybatis_study_teacher.mappers.UserPicMapper";

	@Override
	public int insertUserPic(SqlSession sqlSession, UserPic userPic) {
		int res = sqlSession.insert(namespace + ".insertUserPic", userPic);
        sqlSession.commit();         
        return res;
	}

	@Override
	public UserPic getUserPic(SqlSession sqlSession, int id) {
		return sqlSession.selectOne(namespace + ".getUserPic", id);
	}

}
