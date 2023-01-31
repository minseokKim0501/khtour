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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.RefundDetail;
import ksmart42.khtour.dto.RefundList;
import ksmart42.khtour.mapper.RefundMapper;
import ksmart42.khtour.service.RefundService;

@Controller
@RequestMapping("/refund")
public class RefundController {

	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	@Autowired

	private RefundService refundService;
	private RefundMapper refundMapper;

	public RefundController(RefundService refundService, RefundMapper refundMapper) {
		this.refundService = refundService;
		this.refundMapper = refundMapper;
	}

	/*
	 * 환불 정보 등록 화면
	 * 
	 * @GetMapping("/refundInsert") public String getRefundInsert(Model model) {
	 * 
	 * model.addAttribute("title", "환불 정보 등록 페이지");
	 * 
	 * return "refund/refundInsert"; }
	 */

	/*
	 * 환불 신청 내역 화면
	 */
	@GetMapping("/refundList")
	public String refundList() {
		return "refund/refundList";
		
	}
	
	@PostMapping("/refundList")
	public String getRefundList(Model model, @RequestParam(name = "searchKey", required = false) String searchKey,
			@RequestParam(name = "searchValue", required = false) String searchValue) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (searchKey != null) {
			if ("memberId".equals(searchKey)) {
				searchKey = "member_id";
			} else if ("refApplyCode".equals(searchKey)) {
				searchKey = "refund_apply_code";
			} else if ("refRuleCode".equals(searchKey)) {
				searchKey = "refund_rule_code";
			} else if ("pmtCode".equals(searchKey)) {
				searchKey = "room_pmt_code";
			} else if ("pmtWayCode".equals(searchKey)) {
				searchKey = "pmt_way_code";
			}
		}

		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

		List<RefundList> refundList = refundService.getRefundList(paramMap);
		model.addAttribute("title", "환불 신청 내역 페이지");

		return "refund/refundList";
	}

	/*
	 * 환불 세부 정보 화면
	 */
	@GetMapping("/refundDetail")
	public String refundDetail() {
		return "refund/refundDetail";
		
	}
	
	@PostMapping("/refundDetail")
	public String getRefundDetail(Model model, @RequestParam(name = "searchKey", required = false) String searchKey,
			@RequestParam(name = "searchValue", required = false) String searchValue) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (searchKey != null) {
			if ("memberId".equals(searchKey)) {
				searchKey = "member_id";
			} else if ("refCode".equals(searchKey)) {
				searchKey = "refund_code";
			}
		}

		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

		List<RefundDetail> refundDetail = refundService.getRefundDetail(paramMap);
		model.addAttribute("title", "환불 세부 정보 페이지");

		return "refund/refundDetail";
	}
}