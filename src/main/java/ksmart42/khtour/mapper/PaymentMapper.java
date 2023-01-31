package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Payment;

@Mapper
public interface PaymentMapper {

	public List<Payment> getPayDetail();

}
