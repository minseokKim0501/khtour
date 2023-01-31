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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.dto.HeritageCategory;
import ksmart42.khtour.mapper.HeritageMapper;
import ksmart42.khtour.service.HeritageService;

@Controller
@RequestMapping("/heritage")
public class HeritageController {
   private static final Logger log = LoggerFactory.getLogger(CommunityController.class);
   private HeritageService heritageService;
   private HeritageMapper heritageMapper;
   
   public HeritageController(HeritageService heritageService, HeritageMapper heritageMapper) {
      this.heritageService = heritageService;
      this.heritageMapper = heritageMapper;

   }
   
/////POST 방식////   조회 -> 등록 -> 수정 -> 삭제 순
   
   /* 1. 등록
   *  작성자 : 김민석
   *  입  력 : Heritage(문화재 리스트), @RequestParam, HttpServletRequest
   *  출  력 : String (주소)
   *  설  명 : 문화재 정보 등록, 사진 파일 등록(관리자페이지) - post방식 전달
   */
   @PostMapping("/heritageListByItem")
   public String addHeritage(Heritage heritage
                     , @RequestParam MultipartFile[] heritageImageFiles
                     , HttpServletRequest request) {
      
      log.info("{}",heritage);
      String serverName = request.getServerName();
      String fileRealPath = "";
      if("localhost".equals(serverName)) {            
         fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
         //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
      }else {
         fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
      }
      
      heritageService.addHeritage(heritage, heritageImageFiles, fileRealPath);
      
      return "redirect:/heritage/heritageListByItem";
   }
   
   /* 2. 문화재 명 중복 체크
   *  작성자 : 김민석
   *  입  력 : @RequestParam, heritageName
   *  출  력 : boolean
   *  설  명 : 문화재 명 중복 체크 - post방식 전달
   */
   
     @PostMapping("/isHeritageNameCheck")
     @ResponseBody 
     public boolean isHeritageNameCheck(@RequestParam(value = "heritageName") String heritageName) { 
        boolean isHeritageNameCheck = false;
        log.info("문화재 이름 클릭시 요청 받는 heritageName 값 : {}", heritageName);
     
        boolean result = heritageMapper.isHeritageNameCheck(heritageName);
        if(result) isHeritageNameCheck = true;
        
        log.info("문화재 이름  중복 체크 여부 : {}", isHeritageNameCheck);
        return isHeritageNameCheck;
     }
   
   /* 3. 수정
   *  작성자 : 김민석
   *  입  력 : Heritage(문화재 리스트)
   *  출  력 : String (주소)
   *  설  명 : 문화재 정보 수정(관리자페이지) - post방식 전달
   */
   @PostMapping("/modifyHeritage")
   public String modifyHeritage(Heritage heritage) {
      
      heritageService.modifyHeritage(heritage);
      System.out.println("정보 수정 포스트 전달" + heritageService.modifyHeritage(heritage));
      
      return "redirect:/heritage/heritageListSt";
   }
   
   
   
   
   
   
   
   
   
   
   
   
//// GET 방식   ////
   
   /* 1. 리스트 조회 (관리자 권한)
   *  작성자 : 김민석
   *  입  력 : Model, searchKey 검색키워드 종류, searchValue 검색키워드 값
   *  출  력 : String(주소)
   *  설  명 : 문화재 조회 (관리자페이지) + 검색기능 - get방식 전달
   */
   @GetMapping("/heritageListSt")
   public String getHeritageListSt(Model model
         ,@RequestParam(name="searchKey", required=false) String searchKey
         ,@RequestParam(name="searchValue", required=false) String searchValue) {
      
      Map<String, Object> paramMap = new HashMap<String , Object>();
      
      if(searchKey != null) {
         if("memberId".equals(searchKey)) {
            searchKey = "member_id";
         }else if("heritageName".equals(searchKey)) {
            searchKey = "heritage_name";
         }else if("heritageLocation".equals(searchKey)) {
            searchKey = "heritage_location";
         }else if("heritagEra".equals(searchKey)) {
         searchKey = "heritage_era";
         }else if("heritageOwner".equals(searchKey)) {
            searchKey = "heritage_owner";
         }else if("heritageManager".equals(searchKey)) {
            searchKey = "heritage_manager";
         }
      }
      
      paramMap.put("searchKey", searchKey);
      paramMap.put("searchValue", searchValue);
      log.info("입력 데이터 값 : {}",paramMap);
      
      
      List<Heritage> heritageList = heritageService.getHeritageList(paramMap);
      
      paramMap = null;
      
      model.addAttribute("title", "문화재 종목별 검색 페이지");
      model.addAttribute("heritageList", heritageList);
      
      return "heritage/heritageListSt";
   }   
   
   /* 2. 리스트 조회 (유저 권한), 리스트 등록(관리자 권한)
   *  작성자 : 김민석
   *  입  력 : Model, searchKey 검색키워드 종류, searchValue 검색키워드 값
   *  출  력 : String(주소)
   *  설  명 : 문화재 조회 + 검색기능 - get방식 전달
   */
   @GetMapping("/heritageListByItem")
   public String getHeritageListByItem(Model model
         ,@RequestParam(name="searchKey", required=false) String searchKey
         ,@RequestParam(name="searchValue", required=false) String searchValue
         ) {
      
      Map<String, Object> paramMap = new HashMap<String , Object>();
      
      if(searchKey != null) {
         if("memberId".equals(searchKey)) {
            searchKey = "member_id";
         }else if("heritageName".equals(searchKey)) {
            searchKey = "heritage_name";
         }else if("heritageLocation".equals(searchKey)) {
            searchKey = "heritage_location";
         }else if("heritagEra".equals(searchKey)) {
         searchKey = "heritage_era";
         }else if("heritageOwner".equals(searchKey)) {
            searchKey = "heritage_owner";
         }else if("heritageManager".equals(searchKey)) {
            searchKey = "heritage_manager";
         }
      }
      
      paramMap.put("searchKey", searchKey);
      paramMap.put("searchValue", searchValue);
      log.info("입력 데이터 값 : {}",paramMap);

      List<Heritage> heritageList = heritageService.getHeritageList(paramMap);
      List<HeritageCategory> heritageCategory = heritageService.getHeritageCategoryList();
      
      paramMap = null;
      
      System.out.println(heritageCategory + "<- heritageCategory getHeritageListByItem HeritageController.java");
      model.addAttribute("title", "문화재 종목별 검색 페이지");
      model.addAttribute("heritageList", heritageList);
      model.addAttribute("heritageCategory", heritageCategory);
      
      return "heritage/heritageListByItem";
   }   
   
   /* 3. 상세보기 페이지 조회(유저 권한)
   *  작성자 : 김민석
   *  입  력 : @RequestParam, Model
   *  출  력 : String(주소)
   *  설  명 : 문화재 상세페이지(코드번호에따른) - get방식 전달
   */
   @GetMapping("/heritageDetail")
   public String getHeritaDetail(
         @RequestParam(value="heritageCode", required = false) String heritageCode,
         Model model) {
      
      Heritage heritage = heritageService.getHeritageByCode(heritageCode);
      
      model.addAttribute("title", "문화재 상세 페이지");
      model.addAttribute("heritage", heritage);
      
      System.out.println("정보 수정 겟방식 전달" + heritage);
      
      return "/heritage/heritageDetail";
   }
   
   /* 4. 정보 수정 (관리자 권한)
   *  작성자 : 김민석
   *  입  력 : @RequestParam, Model
   *  출  력 : String (주소)
   *  설  명 : 문화재 정보 수정(관리자페이지) - Get방식 전달
   */
   @GetMapping("/heritageModify")
   public String modifyHeritage(
         @RequestParam(value="heritageCode", required = false) String heritageCode
         ,Model model) {
      
      Heritage heritage = heritageService.getHeritageByCode(heritageCode);
      List<HeritageCategory> heritageCategory = heritageService.getHeritageCategoryList();
      
      model.addAttribute("title", "문화재 수정 페이지");
      model.addAttribute("heritage", heritage);
      model.addAttribute("heritageCategory", heritageCategory);      
      System.out.println("정보 수정 겟방식 전달" + heritage);
      
      return "heritage/heritageModify";
   }      
   
   /* 5. 정보 삭제 (관리자 권한)
   *  작성자 : 김민석
   *  입  력 : Heritage(문화재 리스트), HttpServletRequest
   *  출  력 : String (주소)
   *  설  명 : 문화재 정보 삭제(관리자페이지) - Get방식 전달
   */
   @GetMapping("/heritageRemove")
   public String removeHeritage(Heritage heritage, HttpServletRequest request) throws IOException {
      String heritageCode = heritage.getHeritageCode();
      
      String serverName = request.getServerName();
      String fileRealPath = "";
      
      if("localhost".equals(serverName)) {            
         fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
         //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
      }else {
         fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
      }
      
      int result = heritageService.removeHeritage(heritageCode, fileRealPath);
      
      
      System.out.println("정보 삭제 포스트 전달" + result);
      
      return "redirect:/heritage/heritageListSt";
   }   
   
   /* 6. 카테고리 항목에 체크된 문화재 정보 조회
   *  작성자 : 김민석
   *  입  력 : @RequestParam, List<String>
   *  출  력 : heritageList(문화재 리스트)
   *  설  명 : 카테고리 항목에 체크된 문화재 정보 조회 - Post방식 전달
   */
   @PostMapping("/itemSearchHeritageList")
   @ResponseBody
   public List<Heritage> getItemSearchHeritageList(@RequestParam(value="checkArr[]", required = false) List<String> checkList) {
	   System.out.println(checkList);
	   List<Heritage> heritageList = heritageService.getHeritageByItem(checkList);
	   System.out.println(heritageList);
	   return heritageList;
   }
   
}