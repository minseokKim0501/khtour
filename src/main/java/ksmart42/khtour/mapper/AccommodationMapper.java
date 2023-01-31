package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.FileDto;

@Mapper
public interface AccommodationMapper {
	
	//숙박업소 등록
	public int addAccommodation(Accommodation accommodation);
	
	//숙박업소 리스트 조회
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap);
	
	//숙박업소 리스트(숙박업소 코드)
	public Accommodation getLdgByCode(String ldgCode);
	
	//리뷰수 순 top4개의 숙박업소 조회
	public List<Accommodation> getTopAccommodationList();
	
	//숙박업소 삭제
	public int removeAccommodation(String ldgCode);
	
	//숙박업소 수정
	public int modifyAccommodation(Accommodation accommodation);
	
	//숙박업소 평균별점 조회 
	public String avgGrade(String ldgCode);
	//숙박업소 청결도평균 점수 조회
	public String avgCleanliness(String ldgCode);
	//숙박업소 친절도평균 점수 조회
	public String avgKindness(String ldgCode);
	//숙박업소 편의성평균 점수 조회
	public String avgConvenience(String ldgCode);
	//숙박업소 위치만족도평균 점수 조회
	public String avgLocation(String ldgCode);
	//숙박업소 가격만족도평균 점수 조회
	public String avgPriceSta(String ldgCode);
	
	//숙박업소 리뷰 + 
	public void addReviewCnt(String ldgCode);
	
	//숙박업소 리뷰 - 
	public void subtractReviewCnt(String ldgCode);
	
	//숙박업소 중복체크
	public boolean isNameCheck(String ldgName);
	
	//숙박업소 등록 파일 정보 조회
	public FileDto fileInfoByFileIdx(String ldgCode);
	
}
