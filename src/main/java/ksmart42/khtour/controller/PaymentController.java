package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.Payment;
import ksmart42.khtour.mapper.PaymentMapper;
import ksmart42.khtour.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	
	private PaymentService paymentService;
	private PaymentMapper paymentMapper;
	
	public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
		this.paymentService = paymentService;
		this.paymentMapper = paymentMapper;
	}
	/*
	 * 결제 정보 등록 화면
	 */
	@GetMapping("/payInsert")
	public String getPayInsert(Model model) {
		
		model.addAttribute("title", "결제 정보 등록 페이지");
		
		return "payment/payInsert";
	}
	
	/*
	 * 결제 세부 정보 화면
	 */
	@GetMapping("/payDetail")
	public String getPayDetail(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();

		if(searchKey != null) {
			if("memberId".equals(searchKey)) {
				searchKey = "member_id";
			}else if("pmtCode".equals(searchKey)) {
				searchKey = "room_pmt_code";
			}else if("pmtResvCode".equals(searchKey)) {
				searchKey = "room_resv_code";
			}else if("pmtWayCode".equals(searchKey)) {
				searchKey = "pmt_way_code";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<Payment> payDetail = paymentService.getPayDetail(paramMap);
		
		model.addAttribute("title", "결제 세부 정보 페이지");
		
		return "payment/payDetail";
	}
}