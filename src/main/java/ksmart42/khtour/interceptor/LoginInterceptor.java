package ksmart42.khtour.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor{

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      
      HttpSession session = request.getSession();
      
      String sessionId = (String) session.getAttribute("SID");
      
      String requestURI = request.getRequestURI();
      
      String sessionLevel    = (String) session.getAttribute("SLEVEL");
      
      // 비회원이라면 해당 페이지에 이동 불가
      List<String> authUser = new ArrayList<String>();
      authUser.add("/heritage/heritageDetail");				// 문화재 상세 페이지
      authUser.add("/recordBoard/feedList");				// 게시글에 따른 피드 리스트 조회 페이지
      authUser.add("/recordBoard/feedModify");				// 피드 리스트 수정 페이지
      authUser.add("/recordBoard/recordBoardInsert");		// 여행 게시글 등록 페이지
      authUser.add("/cos/cosBoardList");					// 코스 리스트 조회 페이지
      authUser.add("/cos/cosInsert");						// 코스 등록 페잉지
      authUser.add("/accommodation/accomreviewList");		// 리뷰 리스트 조회 페이지
      authUser.add("/accommodation/acoommodationInfo");		// 숙박업소 리스트 조회 페이지
      authUser.add("/heritage/heritageDetail");				// 문화재 상세 페이지
      authUser.add("/heritage/heritageListSt");				// 문화재 (관리자) 리스트 조회 페이지
      authUser.add("/heritage/heritageModify");				// 문화재 리스트 수정 페이지
      authUser.add("/recordBoard/recordBoardListSt");		// 여행 일정 (관리자) 리스트 조회 페이지
      authUser.add("/recordBoard/recordBoardModify");		// 여행 일정 수정 페이지
      authUser.add("/exhib/exhibInsert");					// 전시회 등록 페이지
      authUser.add("/exhib/exhibModify");					// 전시회 수정 페이지
      authUser.add("/mus/musInsert");						// 박물관 등록 페이지
      authUser.add("/mus/musModify");						// 박물관 수정 페이지
      authUser.add("/plan/planModify");						// 여행일정 수정 페이지
      authUser.add("/plan/planListSt");						// 여행일정 (관리자) 리스트 조회 페이지
      authUser.add("/cos/cosInsert");						// 코스 등록 페이지
      authUser.add("/cos/cosModify");						// 코스 수정 페이지
      authUser.add("/heritage/heritageModify");				// 문화재 수정 페이지
      authUser.add("/accommodation/accommodationListSt");	// 숙박업소 (관리자) 리스트 조회 페이지
      authUser.add("/accommodation/accommodationModify");	// 숙박업소 수정 페이지
      authUser.add("/accommodation/accommodationInsert");	// 숙박업소 등록 페이지
      authUser.add("/room/roomModify");						// 객실 정보 수정 페이지
      authUser.add("/room/roomListSt");						// 객실 (관리자) 리스트 조회 페이지
      authUser.add("/member/memberList");					// 회원 리스트조회 페이지
      authUser.add("/mypage/mypage");						// 마이페이지
      authUser.add("/board/boardList");						// 1:1문의 게시판 리스트
      
      
      // 일반회원이라면 해당 페이지로 이동 불가
      List<String> admin = new ArrayList<String>();
      admin.add("/heritage/heritageModify");				// 문화재 리스트 수정 페이지
      admin.add("/recordBoard/recordBoardModify");			// 여행 일정 수정 페이지
      admin.add("/exhib/exhibInsert");						// 전시회 등록 페이지
      admin.add("/exhib/exhibModify");						// 전시회 수정 페이지
      admin.add("/mus/musInsert");							// 박물관 등록 페이지
      admin.add("/mus/musModify");							// 박물관 수정 페이지
      admin.add("/plan/planModify");						// 여행일정 수정 페이지
      admin.add("/cos/cosInsert");							// 코스 등록 페이지
      admin.add("/cos/cosModify");							// 코스 수정 페이지
      admin.add("/heritage/heritageModify");				// 문화재 수정 페이지
      admin.add("/accommodation/accommodationListSt");		// 숙박업소 (관리자) 리스트 조회 페이지
      admin.add("/accommodation/accommodationModify");		// 숙박업소 수정 페이지
      admin.add("/accommodation/accommodationInsert");		// 숙박업소 등록 페이지
      admin.add("/room/roomModify");						// 객실 정보 수정 페이지
      admin.add("/room/roomListSt");						// 객실 (관리자) 리스트 조회 페이지
	  admin.add("/member/memberList");						// 회원 리스트조회 페이지

      
      // 로그인 안하면 페이지 해당 접속 X , 로그인 페이지로 이동
      if(sessionId == null){
        if(authUser.contains(requestURI)) {
    	 response.sendRedirect("/member/loginMain");
         return false;
        }
      // 로그인 했을 때 일반회원이라면 해당 페이지 접속 X 메인화면으로 이동
      }else {
         //String sessionLevel = (String) session.getAttribute("SLEVEL");
         
         // 회원가입이 완료된 아이디로 로그인 후 해당 페이지 이동
         if(sessionId != null && "일반회원".equals(sessionLevel)) {
            if(admin.contains(requestURI)) {
               response.sendRedirect("/");
               return false;
            }
         }
      }
      
      return true;
   }
}