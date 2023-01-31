package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Mus;

@Mapper
public interface MusMapper {

	// 박물관 목록조회
	public List<Mus> getMusList();
	
	// 박물관 등록
	public int addMus(Mus mus);

	// 박물관 조회(박물관 코드)
	public Mus getMusByCode(String musCode);
	
	// 박물관 수정(박물관코드)
	public int modifyMus(Mus mus);
	
	// 박물관 삭제
	public int removeMus(String musCode);
	
	//박물관 중복체크
   public boolean isNameCheck(String musName);
}
