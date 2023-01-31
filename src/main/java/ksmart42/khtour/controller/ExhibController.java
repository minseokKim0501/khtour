package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Exhib;
import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.mapper.ExhibMapper;
import ksmart42.khtour.service.ExhibService;
import ksmart42.khtour.service.MusService;

@Controller
@RequestMapping("/exhib")
public class ExhibController {
	private static final Logger log = LoggerFactory.getLogger(MusController.class);

	private MusService musService; 
	private ExhibService exhibService; 
	private ExhibMapper exhibMapper; 
	
	public ExhibController(ExhibService exhibService,ExhibMapper exhibMapper,MusService musService) {
		this.musService = musService;
		this.exhibService = exhibService;
		this.exhibMapper = exhibMapper;
	}
	
	/* 
	 * 전시회 조회 (유저 권한)
	*/
	@GetMapping("/exhibBoardList")
	public String getExhibBoardList(Model model) {

		List<Exhib> exhibList = exhibService.getExhibList();
		List<Exhib> ingExhib = exhibService.ingExhib();
		List<Exhib> expectedExhib = exhibService.expectedExhib();
		List<Exhib> endExhib = exhibService.endExhib();
		
		model.addAttribute("title", "전시회 조회 페이지");
		model.addAttribute("exhibList",exhibList);
		model.addAttribute("ingExhib",ingExhib);
		model.addAttribute("expectedExhib",expectedExhib);
		model.addAttribute("endExhib",endExhib);
		
		return "exhib/exhibBoardList";
	}
	
	/*
	 * 전시회 수정 및 조회 페이지 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/exhibList")
	public String getExhibList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
			if("exhibCode".equals(searchKey)) {
				searchKey = "exhib_code";
			}else if("exhibCateName".equals(searchKey)) {
				searchKey = "exhib_cate_name";
			}else if("exhibName".equals(searchKey)) {
				searchKey = "exhib_name";
			}else if("exhibCon".equals(searchKey)) {
			searchKey = "exhib_con";
			}else if("musCode".equals(searchKey)) {
				searchKey = "mus_code";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		List<Exhib> exhibList = exhibService.getExhibList();
		
		paramMap = null;
		
		model.addAttribute("title", "전시회 수정 및 조회 페이지");
		model.addAttribute("exhibList", exhibList);
		return "exhib/exhibList";
	}	
	/*
	 * 전시회 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyExhib")
	public String modifyExhib(Exhib exhib) {
		
		if (exhib.getExhibCateName().equals("테마전시")) {
			exhib.setExhibCate("exhib_theme");
		} else if (exhib.getExhibCateName().equals("특별전시")) {
			exhib.setExhibCate("exhib_special");
		}
		exhibService.modifyExhib(exhib);
		System.out.println("정보 수정 포스트 전달" + exhibService.modifyExhib(exhib));
		return "redirect:/exhib/exhibList";
	}
	
	/*
	 * 전시회 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/exhibModify")
	public String modifyExhib(
			@RequestParam(value="exhibCode", required = false) String exhibCode
			,Model model) {
		Exhib exhib = exhibService.getExhibByCode(exhibCode);
		
		model.addAttribute("title", "전시회 수정 페이지");
		model.addAttribute("exhib", exhib);
		System.out.println("정보 수정 겟방식 전달" + exhib);
		
		return "exhib/exhibModify";
	}	
	
	/*
	 * 전시회 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/exhibRemove")
	public String removeExhib(Exhib exhib) {
		String exhibCode = exhib.getExhibCode();
		
		exhibService.removeExhib(exhibCode);
		System.out.println("정보 삭제 포스트 전달" + exhibService.removeExhib(exhibCode));
		
		return "redirect:/exhib/exhibList";
		
	}
			
	/*
	 * 전시회 등록(Post 정보 전달)
	 */
	@PostMapping("/exhibInsert")
	public String addExhib(Exhib exhib, @RequestParam MultipartFile[] exhibImageFiles
            , HttpServletRequest request) {
		if(exhib.getExhibCate().equals("exhib_theme")) {
			exhib.setExhibCateName("테마전시");
		} else if(exhib.getExhibCate().equals("exhib_special")) {
			exhib.setExhibCateName("특별전시");
		}
		
		String serverName = request.getServerName();
	    String fileRealPath = "";
	      if("localhost".equals(serverName)) {            
	         fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
	         //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }else {
	         fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }
		exhibService.addExhib(exhib, exhibImageFiles, fileRealPath);
		
		return "redirect:/exhib/exhibList";
	}
	
	/*
    * 전시회 중복 체크
    */
	   
     @PostMapping("/isNameCheck")
     @ResponseBody 
     public boolean isNameCheck(@RequestParam(value = "exhibName") String exhibName) { 
        boolean isNameCheck = false;
        log.info("전시회 체크 클릭시 요청 받는 exhibName 값 : {}", exhibName);
        boolean result = exhibMapper.isNameCheck(exhibName);
        if(result) isNameCheck = true;
        
        return isNameCheck;
     }
	
	/*
	 * 전시회 등록(Get 정보 전달)
	 */
	@GetMapping("/exhibInsert")
	public String addExhib(Model model) {
		List<Mus> musList = musService.getMusList();
		model.addAttribute("title", "전시회  등록");
		model.addAttribute("musList", musList);
		return "exhib/exhibInsert";
	}
	
}
