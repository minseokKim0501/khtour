package ksmart42.khtour.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.LoginHistory;
import ksmart42.khtour.dto.Member;
import ksmart42.khtour.dto.MemberLevel;
import ksmart42.khtour.mapper.MemberMapper;
import ksmart42.khtour.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	
	
	//DI 의존성 주입 생성자 메소드 주입방식
	private MemberService memberService;
	private MemberMapper memberMapper;
		
	public MemberController(MemberService memberService, MemberMapper memberMapper) {
		this.memberService = memberService;
		this.memberMapper = memberMapper;
	}
	/*
	 * 로그인 화면
	 */
	@GetMapping("/loginMain")
	public String loginMain(Model model, @RequestParam(value="result", required = false) String result) {
		System.out.println("회원 로그인 화면 GetMapping");
		model.addAttribute("title", "회원 로그인");
		
		if(result != null) model.addAttribute("result", result);
		
		 return "member/loginMain"; 
	}
	
	@PostMapping("/loginMain")
	public String loginMain(Member member, HttpSession session, RedirectAttributes reAttr) {
		System.out.println("회원 로그인 처리 PostMapping");
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();
		
		Member checkMember = memberMapper.getMemberInfoById(memberId);
		
		
		
		log.info("비밀번호" + memberPw);
		log.info("아이디" + memberId);
		log.info("비밀번호2" + checkMember);
		if(checkMember != null && checkMember.getMemberPw() != null && memberPw.equals(checkMember.getMemberPw())) {
			String sessionName = checkMember.getMemberName();
			String sessionLevel = checkMember.getMemberLevel();
			
			session.setAttribute("SID", memberId);
			session.setAttribute("SNAME", sessionName);
			session.setAttribute("SLEVEL", sessionLevel);
			session.setAttribute("SEMAIL", checkMember.getMemberEmail());
			session.setAttribute("SCONTACT", checkMember.getMemberContact());
			session.setAttribute("SUSERNAME", checkMember.getMemberUserName());
			log.info("로그인 성공");
			
			return "redirect:/";
		}
		
		reAttr.addAttribute("result", "등록된 회원이 없습니다.");
		
		return "redirect:/member/loginMain";
	}
	
	/*
	 * 로그인 정보 화면
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/loginHistory")
	public String getLoginHistory(Model model) {
		
		Map<String, Object> resultMap = memberService.getLoginHistory();
		
		List<LoginHistory> loginList  = (List<LoginHistory>) resultMap.get("loginList");
		List<Map<String, Object>> loginMapList = (List<Map<String, Object>>) resultMap.get("loginMapList");
		
		model.addAttribute("title", "로그인 이력");
		model.addAttribute("loginList",		loginList);
		model.addAttribute("loginMapList",	loginMapList);
		
		return "member/loginHistory";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	
		session.invalidate();
		
		return "redirect:/member/loginMain";
	}
		
	/*
	 * 회원가입 화면
	 */
	@GetMapping("/memberInsert")
	public String memberInsert(Model model) {
		
		//회원등급 목록 데이터
		List<Member> memberList = memberService.getMemberList();
		
		model.addAttribute("title", "회원가입");
		model.addAttribute("memberList", memberList);
		
		return "member/memberInsert";
	}
	
	/**
	 * /memberInsert method 방식이 다르기 때문에 주소를 중복해서 사용가능
	 * @param member(회원가입 폼 전송시 요소의 name 속성의 값과  dto의 멤머변수의 이름과 같으면 자동으로 바인딩하는 객체)
	 *        커맨드객체
	 * @return redirect: -> request.sendRedirect("")
	 */
	@PostMapping("/memberInsert")
	public String memberInsert(Member member, RedirectAttributes reAttr) {
		
		 
		log.info("회원가입폼에서 입력받은 데이터: {}", member);
		
		memberService.memberInsert(member);
		/* reAttr.addAttribute("result", member.getMemberId() + "아이디로 회원가입되셨습니다"); */
		
		return "redirect:/member/loginMain";
	}
	
	/*
	 * 회원 정보 검색 및 전체 리스트 화면
	 */
	@GetMapping("/memberList")
	public String getMemberList(Model model
							   ,@RequestParam(value="searchKey", required = false) String searchKey
							   ,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		
		log.info("회원목록 요청");
		log.info("searchValue:{}", searchValue);
		//searchKey = memberId memberId -> m_id     => searchKey = m_id
		//searchKey = memberName memberName -> m_name  => searchKey = m_name
		//searchKey = memberAddr memberAddr -> m_addr  => searchKey = m_addr
		if(searchKey != null) {
			if("memberId".equals(searchKey)) {
				searchKey = "member_id";
			}else if("memberName".equals(searchKey)) {
				searchKey = "member_name";
			}else if("memberBirthday".equals(searchKey)) {
				searchKey = "birthday";
			}
		}
		
		List<Member> memberList = memberService.getMemberList();

		model.addAttribute("title", "회원목록조회");
		model.addAttribute("memberList", memberList);
		
		return "member/memberList";
	}
	
	
	/*
	 * 아이디 중복 체크
	 */
	
	  @PostMapping("/idCheck")
	  @ResponseBody 
	  public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) { 
		  boolean idCheck = false;
		  log.info("아이디 중복 체크 클릭시 요청 받는 memberId 값 : {}", memberId);
	  
		  boolean result = memberMapper.isIdCheck(memberId);
		  if(result) idCheck = true;
		  
		  log.info("아이디 중복 체크 여부 : {}", result);
		  return idCheck;
	  }
	 
	/**
	 * 회원수정처리
	 */
	@PostMapping("/memberModify")
	public String memberModify(Member member) {
		log.info("회원 수정화면에서 입력받은 값: {}", member);
		memberService.memberModify(member);
		return "redirect:/member/memberList";
	}
	
	/**
	 * 회원 수정화면
	 */
	@GetMapping("/memberModify")
	public String memberModify(Model model
							  ,@RequestParam(name="memberId", required = false) String memberId
							  ,@RequestParam(name="memberName", required = false) String memberName) {
		log.info("회원 수정화면 폼 쿼리스트링 memberId : {}", memberId);
		log.info("회원 수정화면 폼 쿼리스트링 memberName : {}", memberName);
		
		Member member = memberService.getMemberInfoById(memberId);
		List<Member> memberList = memberService.getMemberList();
		
		model.addAttribute("title", "회원수정화면");
		model.addAttribute("member", member);
		model.addAttribute("levelList", memberList);
		
		return "member/memberModify";
	}
	
	/*
	 * 회원 이메일 찾기 화면
	 */
	@GetMapping("/memberIdV")
	public String getMemberIdV(Model model) {
		
		model.addAttribute("title", "회원 이메일 찾기 페이지");
		
		return "/member/memberIdV";
	}
	/*
	 * 회원 비밀번호 찾기 화면
	 */
	@GetMapping("/memberPwV")
	public String getMemberPwV(Model model) {
		
		model.addAttribute("title", "회원 비밀번호 찾기 페이지");
		
		return "/member/memberPwV";
	}
	
	/*
	 * 회원 탈퇴 화면
	 */
	@GetMapping("/memberDelete")
	public String memberDelete(Model model
			,@RequestParam(name="memberId", required= false) String memberId
			,@RequestParam(name="result", required = false) String result) {
		
		model.addAttribute("title", "회원 탈퇴 화면");
		model.addAttribute("memberId", memberId);
		if(result != null) model.addAttribute("result", result);
		
		return "member/memberDelete";

	}
	
	/**
	 *  회원 탈퇴 처리
	 */
	@PostMapping("/memberDelete")
	public String memberList(@RequestParam(name="memberId", required = false) String memberId
							  ,@RequestParam(name="memberPw", required = false, defaultValue = "") String memberPw
							  ,RedirectAttributes reAttr) {
		
		log.info("회원 탈퇴 처리 memberId: {}", memberId);
		log.info("회원 탈퇴 처리 memberPw: {}", memberPw);
		Member member = memberMapper.getMemberInfoById(memberId);
		
		if(member != null && member.getMemberPw() != null && memberPw.equals(member.getMemberPw())) {
			log.info("회원 탈퇴 성공");
			return "redirect:/";
			
		}
		
		reAttr.addAttribute("memberId", memberId);
		reAttr.addAttribute("result", "회원정보가 일치하지 않습니다");
		log.info("회원 탈퇴 실패");
		
		
		return "redirect:/member/memberDelete";
	
	}
}