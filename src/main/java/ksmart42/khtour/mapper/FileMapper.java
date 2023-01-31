package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import  ksmart42.khtour.dto.FileDto;

@Mapper
public interface FileMapper {

   public int addFile(List<FileDto> fileList); 
   
   public List<FileDto> getFileList();
   
   public FileDto getFileInfoByIdx(String fileIdx);
   
   public int addFileControl(List<Map<String,String>> addFileControlList);
   
   public int removeFile(String fileIdx);
   public int removeFileByFilePath(String filePath);

   public int removeFileControl(String fileIdx);
   public int removeFileControlByFilePath(String filePath);
}