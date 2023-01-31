package ksmart42.khtour.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.service.CosService;

@Controller
@RequestMapping("/cos")
public class CosController {
	private static final Logger log = LoggerFactory.getLogger(CosController.class);
	private CosService cosService; 

	public CosController(CosService cosService) {
		this.cosService = cosService;
	}
	
	/* 
	 * 코스 조회 (유저 권한)
	*/
	@GetMapping("/cosBoardList")
	public String getCosBoardList(Model model) {

		List<Cos> cosList = cosService.getCosList();
		List<Cos> cosHistory = cosService.cosHistory();
		List<Cos> cosHumanities = cosService.cosHumanities();
		List<Cos> cosWar = cosService.cosWar();
		List<Cos> cosReligion = cosService.cosReligion();
		List<Cos> cosFolklore = cosService.cosFolklore();
		
		
		model.addAttribute("title", "코스 조회 페이지");
	    model.addAttribute("cosHistory", cosHistory);
	    model.addAttribute("cosHumanities", cosHumanities);
	    model.addAttribute("cosWar", cosWar);
	    model.addAttribute("cosReligion", cosReligion);
	    model.addAttribute("cosFolklore", cosFolklore);
	    model.addAttribute("cosList", cosList);
	    log.info("코스유저:{}",cosList);
	    log.info("카테고리 별 코스 조회:{}",cosHistory);
		return "cos/cosBoardList";
	}
	
	/*
	 * 코스  조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/cosList")
	public String getCosList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
			if("cosCode".equals(searchKey)) {
				searchKey = "cos_code";
			}else if("memberId".equals(searchKey)) {
				searchKey = "m.member_id";
			}else if("cosArea1".equals(searchKey)) {
				searchKey = "cos_area1";
			}else if("themeCategory".equals(searchKey)) {
			searchKey = "theme_category";
			}else if("cosName".equals(searchKey)) {
				searchKey = "cos_name";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		log.info("입력 데이터 값 : {}",paramMap);		
		List<Cos> cosList = cosService.getCosList();
		
		paramMap = null;
		
		model.addAttribute("title", "코스 조회 및 수정 페이지");
		model.addAttribute("cosList", cosList);
		
		return "cos/cosList";
	}
	
	/*
	 * 코스 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyCos")
	public String modifyCos(Cos cos) {
		
		cosService.modifyCos(cos);
		System.out.println("정보 수정 포스트 전달" + cosService.modifyCos(cos));
		
		return "redirect:/cos/cosList";
	}
	
	/*
	 * 코스 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/cosModify")
	public String modifyCos(
			@RequestParam(value="cosCode", required = false) String cosCode
			,Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Mus> musList = cosService.getMusList();//박물관 리스트
		List<Cos> cosInsert = cosService.categoryList();//코스 카테고리
		paramMap.put("searchKey", "cos_code");
		paramMap.put("searchValue", cosCode);
		List<Cos> cosModifyList = cosService.getCosList();//코스 선택한 리스트
		Cos cos = cosService.getCosByCode(cosCode);
		model.addAttribute("title", "코스  수정 페이지");
		model.addAttribute("cos", cos);
		model.addAttribute("cosInsert", cosInsert);
		model.addAttribute("musList", musList);
		model.addAttribute("cosModify", cosModifyList.get(0));
		System.out.println("정보 수정 겟방식 전달" + cos);
		log.info("입력 데이터 값   : {}",cosInsert);
		return "cos/cosModify";
	}	
	
	/*
	 * 코스 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/cosRemove")
	public String removeCos(Cos cos, HttpServletRequest request) throws IOException {
		
		  String cosCode = cos.getCosCode();
		  String serverName = request.getServerName();
		
	      String fileRealPath = "";
	      if("localhost".equals(serverName)) {            
	         fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
	         //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }else {
	         fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }
	      
	      int result = cosService.removeCos(cosCode, fileRealPath);
	      
	      System.out.println("정보 삭제 포스트 전달" + result);
	
	      return "redirect:/cos/cosList";
	}

			
	/*
	 * 코스 등록(Post 정보 전달)
	 */
	@PostMapping("/cosInsert")
	public String addCos(Cos cos
						, @RequestParam MultipartFile[] cosImageFiles
			            , HttpServletRequest request) {
		if (cos.getThemeCategory().equals("역사")){cos.setThemeCategoryCode("theme_cate_code001");} 
		else if (cos.getThemeCategory().equals("인문")){cos.setThemeCategoryCode("theme_cate_code002");} 
		else if (cos.getThemeCategory().equals("전쟁")){cos.setThemeCategoryCode("theme_cate_code003");} 
		else if (cos.getThemeCategory().equals("종교사")){cos.setThemeCategoryCode("theme_cate_code004");} 
		else if (cos.getThemeCategory().equals("민속")){cos.setThemeCategoryCode("theme_cate_code005");}
		String serverName = request.getServerName();
	    String fileRealPath = "";
	      if("localhost".equals(serverName)) {            
	         fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
	         //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }else {
	         fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }
		
	    cosService.addCos(cos, cosImageFiles, fileRealPath);
		
	    return "redirect:/cos/cosBoardList";
	}
	
	/*
	 * 코스 등록(Get 정보 전달)
	 */
	@GetMapping("/cosInsert")
	public String addCos(Model model) {
		List<Cos> cosInsert = cosService.categoryList();//코스 카테고리
		List<Mus> musList = cosService.getMusList();//박물관 리스트
		model.addAttribute("title", "코스등록");
		model.addAttribute("cosInsert", cosInsert);
		model.addAttribute("musList", musList);
		log.info("입력 데이터 값 : {}",musList);		

		return "cos/cosInsert";
	}
}

