package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.mapper.MusMapper;
import ksmart42.khtour.service.MusService;

@Controller
@RequestMapping("/mus")
public class MusController {
	private static final Logger log = LoggerFactory.getLogger(MusController.class);

	private MusService musService;
	private MusMapper musMapper;
	public MusController(MusService musService,MusMapper musMapper) {
		this.musService = musService;
		this.musMapper = musMapper;
	}

	/*
	 * 박물관 조회 및 수정
	 */
	
	@GetMapping("/musList")
	public String getMusList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
			if("musCode".equals(searchKey)) {
				searchKey = "mus_code";
			}else if("musLargeCateName".equals(searchKey)) {
				searchKey = "mus_large_cate_name";
			}else if("musName".equals(searchKey)) {
				searchKey = "mus_name";
			}else if("addr1".equals(searchKey)) {
			searchKey = "mus_addr";
			}else if("musDisclose".equals(searchKey)) {
				searchKey = "mus_disclose";
			}else if("musClose".equals(searchKey)) {
				searchKey = "mus_close";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		log.info("입력 데이터 값 : {}",paramMap);		
		List<Mus> musList = musService.getMusList();
		paramMap = null;
		model.addAttribute("title", "박물관 조회 및 수정");
		model.addAttribute("musList", musList);
		
		return "mus/musList";
	}
	
	/*
	 * 박물관 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyMus")
	public String modifyMus(Mus mus) {
		if (mus.getMusLargeCateName().equals("문화재")) {
			mus.setMusLargeCateCode("large_category001");
		} else if (mus.getMusLargeCateName().equals("박물관")) {
			mus.setMusLargeCateCode("large_category002");
		}
		musService.modifyMus(mus);
		System.out.println("정보 수정 포스트 전달" + musService.modifyMus(mus));
		return "redirect:/mus/musList";
	}

	/*
	 * 박물관 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/musModify")
	public String modifyMus(@RequestParam(value = "musCode", required = false) String musCode, Model model) {
		Mus mus = musService.getMusByCode(musCode);
		
		model.addAttribute("title", "박물관 수정 페이지");
		model.addAttribute("mus", mus);
		System.out.println("정보 수정 겟방식 전달" + mus);

		return "mus/musModify";
	}

	/*
	 * 박물관 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/musRemove")
	public String removeMus(Mus mus) {
		String musCode = mus.getMusCode();

		musService.removeMus(musCode);
		System.out.println("정보 삭제 포스트 전달" + musService.removeMus(musCode));

		return "redirect:/mus/musList";

	}

	/*
	 * 박물관 등록(Post 정보 전달)
	 */
	@PostMapping("/musInsert")
	public String addMus(Mus mus) {

		if (mus.getMusLargeCateCode().equals("large_category001")) {
			mus.setMusLargeCateName("문화재");
		} else if (mus.getMusLargeCateCode().equals("large_category002")) {
			mus.setMusLargeCateName("박물관");
		}
		musService.addMus(mus);

		return "redirect:/mus/musList";
	}

	/*
    * 박물관 중복 체크
    */
	   
     @PostMapping("/isNameCheck")
     @ResponseBody 
     public boolean isNameCheck(@RequestParam(value = "musName") String musName) { 
        boolean isNameCheck = false;
        log.info("박물관 체크 클릭시 요청 받는 musName 값 : {}", musName);
     
        boolean result = musMapper.isNameCheck(musName);
        if(result) isNameCheck = true;
        
        log.info("박물관  중복 체크 여부 : {}", result);
        return isNameCheck;
     }
	
	
	/*
	 * 박물관 등록(Get 정보 전달)
	 */
	@GetMapping("/musInsert")
	public String addMus(Model model) {

		model.addAttribute("title", "박물관 등록");

		return "mus/musInsert";
	}

}
