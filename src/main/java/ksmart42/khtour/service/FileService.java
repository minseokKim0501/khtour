package ksmart42.khtour.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class FileService {
	
	private FileUtil fileUtil;
	private FileMapper fileMapper;	
	
	public FileService(FileUtil fileUtil, FileMapper fileMapper) {
		
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}

	public List<String> fileUpload(MultipartFile[] uploadfile, String fileRealPath) {
		
		List<FileDto> fileList= fileUtil.parseFileInfo(uploadfile, fileRealPath);
		List<String> filePathList = new ArrayList<String>(); 
		for(int i=0; i<fileList.size();i++)
		{
			filePathList.add(fileList.get(i).getFilePath());
		}
		if(fileList != null) fileMapper.addFile(fileList);
		return filePathList;
	}
	
	public List<FileDto> getFileList(){
		return fileMapper.getFileList();
	}
	
	public FileDto getFileInfoByIdx(String fileIdx) {
		return fileMapper.getFileInfoByIdx(fileIdx);
	}
	
	public int addFileControl(List<Map<String,String>> addFileControlList) {
		fileMapper.addFileControl(addFileControlList);
		return 0;
	};
	
}


