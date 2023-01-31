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

import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.dto.Plan;
import ksmart42.khtour.service.AccommodationService;
import ksmart42.khtour.service.CosService;
import ksmart42.khtour.service.FileService;
import ksmart42.khtour.service.PlanService;


@Controller
@RequestMapping("/plan")
public class PlanController {

	private PlanService planService;
	private AccommodationService accommodationService; 
	private CosService cosService;
	
	
	public PlanController(PlanService planService,FileService fileService,CosService cosService, AccommodationService accommodationService) {
		this.planService = planService;
		this.accommodationService = accommodationService;
		this.cosService = cosService;
		
	}
/////POST 방식////	조회 -> 등록 -> 수정 -> 삭제 순	
	
	/* 1. 등록
	*  작성자 : 김민석
	*  입  력 : Plan(여행계획 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행계획 정보 등록(관리자페이지) - post방식 전달
	*/
	@PostMapping("/planInsert")
	public String addPlan(Plan plan) {
		
		planService.addPlan(plan);
		
		return "redirect:/plan/planListSt";
	}
	
	/* 2. 수정
	*  작성자 : 김민석
	*  입  력 : Plan(여행계획 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행계획 정보 수정(관리자페이지) - post방식 전달
	*/
	@PostMapping("/planModify")
	public String modifyPlan(Plan plan) {
		
		planService.modifyPlan(plan);
		System.out.println("정보 수정 포스트 전달" + planService.modifyPlan(plan));
		
		return "redirect:/plan/planListSt";
	}
	
	
	
	
	
	
	
	
////GET 방식	////	
	
	/* 1. 리스트 조회 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : Model, @Requestparam
	*  출  력 : String (주소)
	*  설  명 : 여행 계획 조회(관리자페이지), 키워드별 검색 - get방식 전달
	*/
	@GetMapping("/planListSt")
	public String getPlanListSt(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
			if("memberId".equals(searchKey)) {
				searchKey = "member_id";
			}else if("planCode".equals(searchKey)) {
				searchKey = "plan_code";
			}else if("memberId".equals(searchKey)) {
				searchKey = "member_id";
			}else if("planName".equals(searchKey)) {
				searchKey = "plan_name";
			}else if("soloParty".equals(searchKey)) {
				searchKey = "solo_party";
			}else if("planMaterials".equals(searchKey)) {
				searchKey = "plan_materials";
			}else if("planMaterials".equals(searchKey)) {
					searchKey = "plan_materials";
			}else if("planLocation".equals(searchKey)) {
				searchKey = "plan_location";
			}
	}
	
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<Plan> planList = planService.getPlanList(paramMap);
		
		paramMap = null;
		
		model.addAttribute("title", "여행 일정 관리페이지");
		model.addAttribute("planList", planList);
		
		return "plan/planListSt";
	}
	
	/* 2. 여행 일정 등록(유저 권한)
	*  작성자 : 김민석
	*  입  력 : Model
	*  출  력 : String (주소)
	*  설  명 : 숙박업소, 코스 리스트조회, 여행일정 등록 - Get방식 전달
	*/
	@GetMapping("/planInsert")
	public String addPlan(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Accommodation> accommodationList = accommodationService.getAccommodationList(paramMap);
		List<Cos> cosHistory = cosService.cosHistory();
		
		model.addAttribute("title", "여행 계획 등록");
		model.addAttribute("accommodationList", accommodationList);
		model.addAttribute("cosHistory", cosHistory);
		
		return "plan/planInsert";
	}
	
	/* 3. 정보 수정 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : @RequestParam, Model
	*  출  력 : String (주소)
	*  설  명 : 여행 계획 정보 수정(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/planModify")
	public String modifyPlan(
			@RequestParam(value="planCode", required = false) String planCode
			,Model model) {
		Plan plan = planService.getPlanByCode(planCode);
		
		model.addAttribute("title", "여행 계획 수정 페이지");
		model.addAttribute("plan", plan);
		
		System.out.println("정보 수정 겟방식 전달" + plan);
		
		return "plan/planModify";
	}	
	
	/* 4. 정보 삭제 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : Plan(여행 계획 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행 계획 정보 삭제(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/planRemove")
	public String removePlan(Plan plan) {
		String planCode = plan.getPlanCode();
		
		planService.removePlan(planCode);
		
		System.out.println("정보 삭제 포스트 전달" + planService.removePlan(planCode));
		
		return "redirect:/plan/planListSt";
	}
			
}
