package mybatis_study_teacher.mappers.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_teacher.dto.Address;
import mybatis_study_teacher.jdbc.MyBatisSqlSessionFactory;
import mybatis_study_teacher.mappers.AddressMapper;

public class AddressMapperImpl implements AddressMapper {
	private String namespace = "mybatis_study_teacher.mappers.AddressMapper";
	
	private static final AddressMapperImpl instance = new AddressMapperImpl();
	
	private AddressMapperImpl() {
		// TODO Auto-generated constructor stub
	}

	public static AddressMapperImpl getInstance() {
		return instance;
	}

	

	@Override
	public List<Address> selectAddressByAll(RowBounds rowBounds) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectAddressByAll", null, rowBounds);
		}
	}

}
