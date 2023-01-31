package ksmart42.khtour.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Feed;
import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.dto.RecordBoardComment;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.mapper.RecordBoardMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class RecordBoardService {
	//DI 의존성 주입
	private RecordBoardMapper recordBoardMapper;
	
	private FileUtil fileUtil;
	
	private FileMapper fileMapper;
	
	public RecordBoardService(RecordBoardMapper recordBoardMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.recordBoardMapper = recordBoardMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
// 기본적인 조회-> 등록 -> 수정-> 삭제	
	
	public String getrecordBoardByfeedCount(String recordBoardCode) {
		return recordBoardMapper.getrecordBoardByfeedCount(recordBoardCode);
	}
	
	/**
	 * 여행게시글 목록 조회
	 * @author 김민석
	 * @param paramMap
	 */
	public List<RecordBoard> getRecordBoardList(Map<String, Object> paramMap){
		List<RecordBoard> recordBoardList = recordBoardMapper.getRecordBoardList(paramMap);
		
		for(int i=0; i<recordBoardList.size(); i++) {
				
			PlanStatus planStatus = recordBoardMapper.getPlanStatusByCode(recordBoardList.get(i).getPlanStatusCode());
			recordBoardList.get(i).setPlanStatus(planStatus);
		};
		return recordBoardList;
	}
	
	public List<RecordBoard> getRecordBoardByPlanStatus(String planStatusName){
		List<RecordBoard> recordBoardListByPlanStatus = recordBoardMapper.getRecordBoardByPlanStatus(planStatusName);
		
		return recordBoardListByPlanStatus;
	}
	
	public List<RecordBoard> getRecordBoardByTravelStyle(String tavelStyle){
		List<RecordBoard> recordBoardByTravelStyle = recordBoardMapper.getRecordBoardByTravelStyle(tavelStyle);
		
		return recordBoardByTravelStyle;
	}
	
	/**
	 * 코드에 따른 여행게시글 조회
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public RecordBoard getRecordBoardByCode(String recordBoardCode) {
		return recordBoardMapper.getRecordBoardByCode(recordBoardCode);
	}
	
	/**
	 * 코드에 따른 여행게시글댓글 조회
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public RecordBoardComment getCommentdByCode(String commentNum) {
		return recordBoardMapper.getCommentdByCode(commentNum);
	}
	
	/**
	 * 조회수에 따른 Top4 여행게시글 조회
	 * @author 김민석
	 * @param 
	 */
	public List<RecordBoard> getTopRecordBoardList(){
		List<RecordBoard> TopRecordBoardList = recordBoardMapper.getTopRecordBoardList();
		
		return TopRecordBoardList;
	}
	
	/**
	 * 여행상태 목록 조회
	 * @author 김민석
	 * @param 
	 */
	public List<PlanStatus> getPlanStatusList(){
		return recordBoardMapper.getPlanStatusList();
		
	}
	
	/**
	 * 여행게시글 등록, 이미지 파일 삽입
	 * @author 김민석
	 * @param recordBoard, recordBoardImageFiles, fileRealPath
	 */
	public void addRecordBoard(RecordBoard recordBoard,  MultipartFile[] recordBoardImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(recordBoardImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		
		recordBoardMapper.addRecordBoard(recordBoard);
	
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
		
		Map<String , String> addMap = null;
		
		if(fileList != null) {
			for(FileDto fileDto : fileList) {
				addMap = new HashMap<String , String>();
				addMap.put("referenceCode", recordBoard.getRecordBoardCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		
		fileMapper.addFileControl(addFileControlList);
	}

	/**
	 * 여행게시글 정보 수정
	 * @author 김민석
	 * @param recordBoard
	 */
	public int modifyRecordBoard(RecordBoard recordBoard) {
		return recordBoardMapper.modifyRecordBoard(recordBoard);
	}
	
	/**
	 * 코드에 따른 여행게시글 정보 삭제
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int removeRecordBoard(String recordBoardCode, String fileRootPath) throws IOException {
	      
	      FileDto fileDto = recordBoardMapper.fileInfoByFileIdx(recordBoardCode);
	      
	      int result = 0;

	      if(fileDto != null) {
	         
	         String fileIdx = fileDto.getFileIdx();
	         String filePath = fileDto.getFilePath();
	   
	         if(fileIdx != null) {
	            
	            fileMapper.removeFileControl(fileIdx);
	            
	            fileMapper.removeFile(fileIdx);
	            
	            result += recordBoardMapper.removeRecordBoard(recordBoardCode);
	            
	            if(result > 0) fileUtil.fileDelete(fileRootPath, filePath);
	         }
	      }else {
	         
	         result += recordBoardMapper.removeRecordBoard(recordBoardCode);
	         
	      }
	      return result;
	   }
	
	/**
	 * 여행게시글코드에 따른 댓글 정보 삭제
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int removeCommentByrCode(String recordBoardCode) {
		
		return recordBoardMapper.removeCommentByrCode(recordBoardCode);
	}
	
	/**
	 * 여행게시글코드에 따른 피드 정보 삭제
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int removeFeedByrCode(String recordBoardCode) {
		
		return recordBoardMapper.removeFeedByrCode(recordBoardCode);
	}
	
////////////피드
	
	/**
	 * 여행게시글코드에 따른 피드 조회
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public List<Feed> getFeedListByRecordBoardCode(String recordBoardCode) {
		return recordBoardMapper.getFeedListByRecordBoardCode(recordBoardCode);
	}
	
	/**
	 * 피드 등록, 이미지 파일 삽입
	 * @author 김민석
	 * @param feed, recordBoardImageFiles, fileRealPath
	 */
	public void addFeed(Feed feed, MultipartFile[] feedImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(feedImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		recordBoardMapper.addFeed(feed);
		
		
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
		
		Map<String , String> addMap = null;
		
		if(fileList != null) {
			for(FileDto fileDto : fileList) {
				addMap = new HashMap<String , String>();
				addMap.put("referenceCode", feed.getFeedCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		
		fileMapper.addFileControl(addFileControlList);
	}

	/**
	 * 피드 정보 수정
	 * @author 김민석
	 * @param feed
	 */
	public int modifyFeed(Feed feed) {
		return recordBoardMapper.modifyFeed(feed);
	}
	
	
	/**
	 * 코드에 따른 피드 정보 삭제
	 * @author 김민석
	 * @param feedCode
	 */
	public int removeFeed(String feedCode, String fileRootPath) throws IOException {
		
		FileDto fileDto = recordBoardMapper.fileInfoByFileIdx2(feedCode);
	      
	      int result = 0;

	      if(fileDto != null) {
	         
	         String fileIdx = fileDto.getFileIdx();
	         String filePath = fileDto.getFilePath();
	   
	         if(fileIdx != null) {
	            
	            fileMapper.removeFileControl(fileIdx);
	            
	            fileMapper.removeFile(fileIdx);
	            
	            result += recordBoardMapper.removeFeed(feedCode);
	            
	            if(result > 0) fileUtil.fileDelete(fileRootPath, filePath);
	         }
	      }else {
	         
	         result += recordBoardMapper.removeFeed(feedCode);
	         
	      }
	      return result;
	}
	
	/**
	 * 게시글의 피드 개수 더하기
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int addFeedCount(String recordBoardCode) {
		return recordBoardMapper.addFeedCount(recordBoardCode);
		
		
	}
	
	/**
	  * 게시글의 피드 개수 빼기
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int subtractFeedCount(String recordBoardCode) {
		return recordBoardMapper.subtractFeedCount(recordBoardCode);
		
	}
//////////게시글 댓글 관련
	
	public List<RecordBoardComment> getCommentListByrCode(String recordBoardCode){
		return recordBoardMapper.getCommentListByrCode(recordBoardCode);
	}	
	
	public void addComment(RecordBoardComment recordBoardComment) {
		recordBoardMapper.addComment(recordBoardComment);
		
	}	
	

	/**
	 * 댓글 삭제
	 * @author 김민석
	 * @param feedCode
	 */
	public int removeRecordBoardComment(String commentNum) {
		
		return recordBoardMapper.removeRecordBoardComment(commentNum);
	}
	
	/**
	 * 게시글의 댓글 개수 더하기
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int addCommentCount(String recordBoardCode) {
		return recordBoardMapper.addCommentCount(recordBoardCode);
		
		
	}
	
	/**
	  * 게시글의 댓글 개수 빼기
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int subtractCommentCount(String recordBoardCode) {
		return recordBoardMapper.subtractCommentCount(recordBoardCode);
		
	}
/////////그 외
	
	/**
	 * 코드에 따른 여행게시글 조회수 정보 추가
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int updateViewsByCode(String recordBoardCode) {
		return recordBoardMapper.updateViewsByCode(recordBoardCode);
	}
	
	
	

	
}
