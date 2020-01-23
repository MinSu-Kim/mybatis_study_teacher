package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Address;

public interface AddressMapper {
	List<Address> selectAddressByAll(SqlSession sqlSession, RowBounds rowBounds);
}
