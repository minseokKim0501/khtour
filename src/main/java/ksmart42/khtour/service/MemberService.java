package ksmart42.khtour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.LoginHistory;
import ksmart42.khtour.dto.Member;
import ksmart42.khtour.dto.MemberLevel;
import ksmart42.khtour.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	
	//DI 의존성 주입 생성자메소드 주입방식
	private MemberMapper memberMapper; 
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	/**
	 * 로그인 이력조회
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getLoginHistory(){
		
		List<LoginHistory> loginList = memberMapper.getLoginHistory();
		List<Map<String, Object>> loginMapList = memberMapper.getLoginHistory2();

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("loginList", loginList);
		resultMap.put("loginMapList", loginMapList);
		
		return resultMap;
	}
	
	public int memberModify(Member member) {
		return memberMapper.memberModify(member);
	}
	
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	
	public List<Member> getMemberList(){
		
		List<Member> memberList = memberMapper.getMemberList();
		
		return memberList;
	}
	
	public int memberInsert(Member member) {
		
		int result = memberMapper.memberInsert(member);
		
		return result; 
	}

	public List<MemberLevel> getMemberLevelList() {
		
		List<MemberLevel> memberLevelList = memberMapper.getMemberLevelList();
		
		return memberLevelList;
	}
	//회원삭제
	public int memberDelete(Member member) {
		//회원아이디
		String memberId = member.getMemberId();
		//권한
		String memberLevel = member.getMemberLevel();
				
		
		//공통사항 삭제 프로세스
		memberMapper.removeLoginHistory(memberId);
				
		memberMapper.memberDelete(memberId);
		
		int result = memberMapper.memberDelete(memberId);
		return result;
		
	}

	

	
	
	
	
	
	
	
	
	
	
}
