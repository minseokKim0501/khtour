package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.RefundDetail;
import ksmart42.khtour.dto.RefundList;

@Mapper
public interface RefundMapper {
	
	public List<RefundList> getRefundList();
	
	public List<RefundDetail> getRefundDetail();

}
