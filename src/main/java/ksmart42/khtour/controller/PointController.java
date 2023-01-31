package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.Point;
import ksmart42.khtour.service.PointService;

@Controller
@RequestMapping("/point")
public class PointController {

	private PointService pointService; 
	
	public PointController(PointService pointService) {
		this.pointService = pointService;
	}
	
	/*
	 * 포인트 현황 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/adPointList")
	public String getPointList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Point> getAdPointList = pointService.getAdPointList(paramMap);
		
		model.addAttribute("title", "포인트 현황 조회 페이지");
		model.addAttribute("getAdPointList", getAdPointList);
		
		return "point/adPointList";
	}
	
	/*
	 * 전시회 계획 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyPoint")
	public String modifyPoint(Point point) {
		
		pointService.modifyPoint(point);
		System.out.println("정보 수정 포스트 전달" + pointService.modifyPoint(point));
		
		return "redirect:/point/pointList";
	}
	
	/*
	 * 전시회 계획 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/pointModify")
	public String modifyPoint(
			@RequestParam(value="pointCode", required = false) String pointCode
			,Model model) {
		Point point = pointService.getPointByCode(pointCode);
		
		model.addAttribute("title", "전시회 계획 수정 페이지");
		model.addAttribute("point", point);
		System.out.println("정보 수정 겟방식 전달" + point);
		
		return "point/pointModify";
	}	
	
	/*
	 * 전시회 계획 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/pointRemove")
	public String removePoint(Point point) {
		String pointCode = point.getPointCode();
		
		pointService.removePoint(pointCode);
		System.out.println("정보 삭제 포스트 전달" + pointService.removePoint(pointCode));
		
		return "redirect:/point/pointList";
		
	}
			
	/*
	 * 전시회 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/pointInsert")
	public String addPoint(Point point) {
		
		pointService.addPoint(point);
		
		return "redirect:/point/pointList";
	}
	/*
	 * 전시회 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/pointInsert")
	public String addPoint(Model model) {
		
		model.addAttribute("title", "전시회 계획 등록");
		
		return "point/pointInsert";
	}
	
}
