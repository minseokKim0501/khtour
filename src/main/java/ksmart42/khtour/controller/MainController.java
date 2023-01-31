package ksmart42.khtour.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.service.AccommodationService;
import ksmart42.khtour.service.CommunityService;
import ksmart42.khtour.service.CosService;
import ksmart42.khtour.service.FileService;
import ksmart42.khtour.service.RecordBoardService;
import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.RecordBoard;

@Controller
public class MainController {
	private RecordBoardService recordBoardService;
	private CommunityService communityService;
	private AccommodationService accommodationService;
	private CosService cosService;
	
	private FileService fileService;
	
	public MainController(RecordBoardService recordBoarService,CosService cosService, CommunityService communityService, FileService fileService, AccommodationService accommodationService) {
		this.recordBoardService = recordBoarService;
		this.communityService = communityService;
		this.accommodationService = accommodationService;
		this.cosService = cosService;
		
		
		this.fileService = fileService;
	}

////GET 방식   ////
	   
  /* 1. 메인화면 리스트 조회
  *  작성자 : 김민석
  *  입  력 : Model
  *  출  력 : String(주소)
  *  설  명 : 여행기록게시판4개, 커뮤니티 포스트4개, 코스, 숙박업소4개 리스트 조회  get방식 전달
  */
	@GetMapping("/")
	public String main(Model model) {
		
		List<RecordBoard> TopRecordBoardList = recordBoardService.getTopRecordBoardList();
		List<CommPost> dailyPostList = communityService.getDailyPostList();
		List<Cos> cosHistory = cosService.cosHistory();
		List<Accommodation> topAccomodationList = accommodationService.getTopAccommodationList();
		
		
		model.addAttribute("title", "메인 화면 이동");
		
		System.out.println(TopRecordBoardList+"<--------------TopRecordBoardList");
		model.addAttribute("TopRecordBoardList",TopRecordBoardList);
		model.addAttribute("dailyPostList",dailyPostList);
		model.addAttribute("topAccomodationList",topAccomodationList);
		model.addAttribute("cosHistory", cosHistory);
		return "main";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 파일업로드 관련
	@GetMapping("/file/upload")
	public String archiveUpload(Model model) {
		
		model.addAttribute("title", "파일 업로드 폼");
				
		return "file/uploadView";
	}
	@PostMapping("/file/upload")
	public String archiveUpload(@RequestParam MultipartFile[] uploadfile, Model model, HttpServletRequest request) {
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		fileService.fileUpload(uploadfile, fileRealPath);
		
		return "redirect:/";
	}
	
	@GetMapping("/file/downloadView")
	public String archiveDownloadView(Model model) {
		model.addAttribute("title", "파일 리스트");
		model.addAttribute("fileList", fileService.getFileList());
		return "file/downloadView";
	}
	
	@RequestMapping("/file/download")
	@ResponseBody
	public ResponseEntity<Object> archiveDownload(@RequestParam(value="fileIdx", required = false) String fileIdx
												   ,HttpServletRequest request
												   ,HttpServletResponse response) throws URISyntaxException{
		
		String serverName = request.getServerName();
		
		
		if(fileIdx != null) {
			FileDto fileDto = fileService.getFileInfoByIdx(fileIdx);
			File file;
			if("localhost".equals(serverName)) {				
				file = new File(System.getProperty("user.dir") + "/src/main/resources/static/"+ fileDto.getFilePath());
			}else {
				file = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/") + fileDto.getFilePath());
			}
		
			Path path = Paths.get(file.getAbsolutePath());
	        Resource resource;
			try {
				resource = new UrlResource(path.toUri());
				String contentType = null;
				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
				if(contentType == null) {
					contentType = "application/octet-stream";
				}
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(fileDto.getFileOriginalName(),"UTF-8") + "\";")
						.body(resource);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		URI redirectUri = new URI("/");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(redirectUri);
		
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
}