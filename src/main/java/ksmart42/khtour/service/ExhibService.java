package ksmart42.khtour.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Exhib;
import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.mapper.ExhibMapper;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class ExhibService {
	//DI 의존성 주입
	private ExhibMapper exhibMapper;
	private FileUtil 	fileUtil;
	private FileMapper 	fileMapper;
	
	public ExhibService(ExhibMapper exhibMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.exhibMapper = exhibMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
	
	/**
	 * 코드에 따른 전시회 조회
	 */
	public Exhib getExhibByCode(String exhibCode) {
		return exhibMapper.getExhibByCode(exhibCode);
	}
	/**
	 * 전시회등록
	 */
	public void addExhib(Exhib exhib, MultipartFile[] exhibImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(exhibImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		exhibMapper.addExhib(exhib);
		
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
	      
		Map<String, String> addMap = null;

		if (fileList != null) {
			for (FileDto fileDto : fileList) {
				addMap = new HashMap<String, String>();
				addMap.put("referenceCode", exhib.getExhibCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		fileMapper.addFileControl(addFileControlList);
	}
	
	/**
	 * 전시회 목록 조회
	 */
	public List<Exhib> getExhibList(){
		List<Exhib> exhibList = exhibMapper.getExhibList();
		
		return exhibList;
	}
	
	/**
	 * 유저 전시회 조회
	 */
	public List<Exhib> ingExhib(){
		List<Exhib> ingExhib = exhibMapper.ingExhib();
		return ingExhib;
	}
	public List<Exhib> expectedExhib(){
		List<Exhib> expectedExhib = exhibMapper.expectedExhib();
		return expectedExhib;
	}
	public List<Exhib> endExhib(){
		List<Exhib> endExhib = exhibMapper.endExhib();
		return endExhib;
	}
	
	/**
	 * 전시회 정보 수정
	 */
	public int modifyExhib(Exhib exhib) {
		return exhibMapper.modifyExhib(exhib);
	}
	
	/**
	 * 전시회 정보 삭제
	 */
	public int removeExhib(String exhibCode) {
		int result = exhibMapper.removeExhib(exhibCode);
		
		result += exhibMapper.removeExhib(exhibCode);
		
		return result;
	}
}
