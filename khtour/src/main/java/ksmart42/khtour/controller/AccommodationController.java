package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccommodationController {
	
	/*
	 * 숙박업소 등록	
	 * */
	@GetMapping("/accommodation/accommodationInsert")
	public String addaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소등록");
		
		return "/accommodation/accommodationInsert";
	}
	
	/*
	 * 숙박업소 검색
	 * */
	@GetMapping("/accommodation/accommodationList")
	public String getaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소검색");
		
		return "/accommodation/accommodationList";
	}
	
	/*
	 * 숙박업소정보 수정
	 * */
	@GetMapping("/accommodation/accommodationModify")
	public String modifyaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소정보 수정");
		
		return "/accommodation/accommodationModify";
	}
	
	/*
	 * 숙박업소 삭제
	 * */
	@GetMapping("/accommodation/accommodationDelete")
	public String deleteaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소 삭제");
		
		return "/accommodation/accommodationDelete";
	}
}
