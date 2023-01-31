package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member2")
public class MemberController2 {
	/**
	 * URI(통합 자원 식별자(Uniform Resource Identifier)) vs URL(리소스 위치)
	 * 
	 */

	
	/**
	 *  member2/memberInsert2 -> 회원가입폼을 사용자 요청할 때의 주소
	 *  return -> 프로젝트 내부의 웹자원 경로
	 */
	@GetMapping("/memberInsert2")
	public String memberInsert(Model model) {
		
		return "member/memberInsert"; 
	}
}
