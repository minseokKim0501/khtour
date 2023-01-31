package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Exhib;
import ksmart42.khtour.dto.FileDto;

@Mapper
public interface ExhibMapper {

	// 전시회 목록조회
	public List<Exhib> getExhibList();
	
	// 전시회 등록
	public int addExhib(Exhib exhib);

	// 전시회 조회(전시회 코드)
	public Exhib getExhibByCode(String exhibCode);

	// 유저 진행별 전시회 조회 
	public List<Exhib> ingExhib();
	public List<Exhib> expectedExhib();
	public List<Exhib> endExhib();
	
	// 전시회 수정(전시회코드)
	public int modifyExhib(Exhib exhib);
	
	// 전시회 삭제
	public int removeExhib(String exhibCode);
	
	//전시회 중복체크
   public boolean isNameCheck(String exhibName);
   
   	// 전시회 이미지 등록 파일 정보 조회
	public FileDto fileInfoByFileIdx(String exhibCode);
}
