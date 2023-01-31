package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.dto.HeritageCategory;

@Mapper
public interface HeritageMapper {

   // 문화재 목록조회
   public List<Heritage> getHeritageList(Map<String, Object> paramMap);
   
   // 문화재 코드에 따른 문화 목록조회
   public Heritage getHeritageByCode(String heritageCode);
   
   // 문화재 분류 목록 조회
   public List<HeritageCategory> getHeritageCategoryList();
   
   // 문화재 정보 등록
   public int addHeritage(Heritage heritage);

   // 문화재 정보 수정
   public int modifyHeritage(Heritage heritage);
   
   // 문화재 정보 삭제
   public int removeHeritage(String heritageCode);
   
   // 문화재 등록 파일 정보 조회
   public FileDto fileInfoByFileIdx(String heritageCode);
   
   //문화재 명 중복체크
   public boolean isHeritageNameCheck(String heritageName);
   
   // 아이템 선택에 따른 문화재 목록 조회
   public List<Heritage> getHeritageByItem(List<String> checkList);
}