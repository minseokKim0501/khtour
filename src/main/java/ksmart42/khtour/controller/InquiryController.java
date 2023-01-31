package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InquiryController {
	
	/*
	 * Q&A게시판 리스트
	 * */
	@GetMapping("/inquiry/inquiryList")
	public String getinquiry(Model model) {
		
		model.addAttribute("title", "Q&A게시판리스트");
		
		return "/inquiry/inquiryList";
		
	}
}
