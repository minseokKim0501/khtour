package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.RefundDetail;
import ksmart42.khtour.dto.RefundList;
import ksmart42.khtour.mapper.RefundMapper;

@Service
@Transactional
public class RefundService {
	
	private RefundMapper refundMapper;
	
	@Autowired
	public RefundService(RefundMapper refundMapper) {
		this.refundMapper = refundMapper;
	}

	public List<RefundList> getRefundList(Map<String, Object> paramMap) {
		
		List<RefundList> refundList = refundMapper.getRefundList();
		
		return refundList;
	} 
	
	public List<RefundDetail> getRefundDetail(Map<String, Object> paramMap) {
		
		List<RefundDetail> refundDetail = refundMapper.getRefundDetail();
		
		return refundDetail;
	} 
	
	
	
}
