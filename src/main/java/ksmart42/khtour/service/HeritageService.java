package ksmart42.khtour.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.dto.HeritageCategory;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.mapper.HeritageMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class HeritageService {
   //DI 의존성 주입
   private HeritageMapper heritageMapper;
   
   private FileUtil fileUtil;
   
   private FileMapper fileMapper;
   
   public HeritageService(HeritageMapper heritageMapper, FileUtil fileUtil, FileMapper fileMapper) {
      this.heritageMapper = heritageMapper;
      this.fileUtil = fileUtil;
      this.fileMapper = fileMapper;
   }
   
   
   /**
    * 코드에 따른 문화재 목록 조회
    * @author 김민석
    * @param heritageCode
    */
   public Heritage getHeritageByCode(String heritageCode) {
      return heritageMapper.getHeritageByCode(heritageCode);
   }
   
   /**
    * 문화재 목록 조회
    * @author 김민석
    * @param paramMap
    */
   public List<Heritage> getHeritageList(Map<String, Object> paramMap){
      List<Heritage> heritageList = heritageMapper.getHeritageList(paramMap);
      
      return heritageList;
   }

   /**
    * 문화재 분류 목록 조회
    * @author 김민석
    * @param 
    */
   public List<HeritageCategory> getHeritageCategoryList(){
      
      List<HeritageCategory> heritageCategoryList = heritageMapper.getHeritageCategoryList();
      
      return heritageCategoryList;
   }   
   
   /**
    * 문화재 등록, 이미지 파일 삽입
    * @author 김민석
    * @param heritage, heritageImageFiles, fileRealPath
    */
   public void addHeritage(Heritage heritage, MultipartFile[] heritageImageFiles, String fileRealPath) {
      List<FileDto> fileList = fileUtil.parseFileInfo(heritageImageFiles, fileRealPath);
      fileMapper.addFile(fileList);
      heritageMapper.addHeritage(heritage);
      
      List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
      
      Map<String , String> addMap = null;
      
      if(fileList != null) {
         for(FileDto fileDto : fileList) {
            addMap = new HashMap<String , String>();
            addMap.put("referenceCode", heritage.getHeritageCode());
            addMap.put("fileIdx", fileDto.getFileIdx());
            addFileControlList.add(addMap);
         }
      }
      
      fileMapper.addFileControl(addFileControlList);
   }
   
   /**
    * 문화재 정보 수정
    * @author 김민석
    * @param heritage
    */
   public int modifyHeritage(Heritage heritage) {
      return heritageMapper.modifyHeritage(heritage);
   }
   
   /**
    * 코드에 따른 문화재 정보 삭제
    * @author 김민석
    * @param heritageCode
    * @throws IOException 
    */
   public int removeHeritage(String heritageCode, String fileRootPath) throws IOException {
      
      FileDto fileDto = heritageMapper.fileInfoByFileIdx(heritageCode);
      
      int result = 0;

      if(fileDto != null) {
         
         String fileIdx = fileDto.getFileIdx();
         String filePath = fileDto.getFilePath();
   
         if(fileIdx != null) {
            
            fileMapper.removeFileControl(fileIdx);
            
            fileMapper.removeFile(fileIdx);
            
            result += heritageMapper.removeHeritage(heritageCode);
            
            if(result > 0) fileUtil.fileDelete(fileRootPath, filePath);
         }
      }else {
         
         result += heritageMapper.removeHeritage(heritageCode);
         
      }
      
      
      //result += heritageMapper.removeHeritage(heritageCode);
      
      
      return result;
   }
   
   
   /**
    * 아이템에 따른 문화재 목록 조회
    * @author 김민석
    * @param paramMap
    */
   public List<Heritage> getHeritageByItem(List<String> checkList){
      List<Heritage> heritageList = heritageMapper.getHeritageByItem(checkList);
      
      return heritageList;
   }
   
}