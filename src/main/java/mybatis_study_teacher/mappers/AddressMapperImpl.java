package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Address;

public class AddressMapperImpl implements AddressMapper {
	private String namespace = "mybatis_study_teacher.mappers.AddressMapper";
	
	@Override
	public List<Address> selectAddressByAll(SqlSession sqlSession, RowBounds rowBounds) {
		return sqlSession.selectList(namespace + ".selectAddressByAll", null, rowBounds);
	}

}
