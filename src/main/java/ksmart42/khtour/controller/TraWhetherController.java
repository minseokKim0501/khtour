package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraWhetherController {
	
	/* 1. 리스트 조회 (유저 권한)
	*  작성자 : 김민석
	*  입  력 : Model
	*  출  력 : String(주소)
	*  설  명 : API 날씨 정보 조회 (유저페이지) - get방식 전달
	*/
	@GetMapping("/traWhether/traWhetherList")
	public String getWhetherList(Model model) {
		
		model.addAttribute("title", "지역별 날씨 정보 페이지");
		
		return "/traWhether/traWhetherList";
	}
	
	// 테스트 페이지
	@GetMapping("/traWhether/test")
	public String gettestt(Model model) {
		
		model.addAttribute("title", "지역별 날씨 정보 페이지");
		
		return "/traWhether/test";
	}
}
