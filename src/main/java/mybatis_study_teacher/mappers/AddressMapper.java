package mybatis_study_teacher.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import mybatis_study_teacher.dto.Address;


public interface AddressMapper {
	List<Address> selectAddressByAll(RowBounds rowBounds);
}
