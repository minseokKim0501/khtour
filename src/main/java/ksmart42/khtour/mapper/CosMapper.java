package ksmart42.khtour.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.dto.FileDto;

@Mapper
public interface CosMapper {

	// 코스 조회
	public List<Cos> getCosList();
	
	// 카테고리별 코스 조회
	public List<Cos> cosHistory();
	public List<Cos> cosHumanities();
	public List<Cos> cosWar();
	public List<Cos> cosReligion();
	public List<Cos> cosFolklore();
	
	// 코스 등록
	public int addCos(Cos cos);
	public List<Cos> categoryList();

	// 코스 조회(코스 코드)
	public Cos getCosByCode(String cosCode);
	
	// 코스 수정(코스코드)
	public int modifyCos(Cos cos);
	
	// 코스 삭제
	public int removeCos(String cosCode);
	
	// 코스 이미지 등록 파일 정보 조회
	public FileDto fileInfoByFileIdx(String cosCode);
}
