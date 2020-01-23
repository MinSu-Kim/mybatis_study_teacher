package mybatis_study_teacher.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.UserPic;

public interface UserPicMapper {
    int insertUserPic(SqlSession sqlSession, UserPic userPic);
    UserPic getUserPic(SqlSession sqlSession, int id);
}
