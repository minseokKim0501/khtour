package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourCourseController {
	@GetMapping("/tourCourse/cosInsert")
	public String getCosInsert(Model model) {
		model.addAttribute("title", "코스 등록");

		return "/tourCourse/cosInsert";  
	}

	@GetMapping("/tourCourse/cosList")
	public String getCosList(Model model) {
		model.addAttribute("title", "코스검색 및 조회");

		return "/tourCourse/cosList";
	}
	
	@GetMapping("/tourCourse/cosCate")
	public String getCosCate(Model model) {
		model.addAttribute("title", "카테고리 관리");

		return "tourCourse/cosCate";
	}
}
