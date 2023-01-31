package ksmart42.khtour.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.mapper.FileMapper;



public class KhtourLibrary {	
	
	
	
	/* 작성자 : 한경수
	*  입  력 : float
	*  출  력 : String
	*  설  명  : 숫자에 K, M 달아주는 메서드, 입력값 : FLOAT  -> 출력값 변경된 String (예: 30K)
	*/ 
	static public String cntConverter(Float cnt) {	
		String result="";
		Float tempFloat = 0f;
		if (cnt>=1000000)
		{
			if(Math.round(cnt/100000)%10 ==0)
			{
				result = String.valueOf(Math.round(cnt/1000000))+"M";
			}
			else
			{
				tempFloat = (float)Math.round(cnt/100000);
				tempFloat = tempFloat/10;
				result = String.valueOf(tempFloat)+"M";
			}
		}
		else if (cnt>=1000)
		{
			if(Math.round(cnt/100)%10 ==0)	
			{
				result = String.valueOf(Math.round(cnt/1000))+"K";
			}
			else
			{
				tempFloat = (float)Math.round(cnt/100);
				tempFloat = tempFloat/10;
				result = String.valueOf(tempFloat)+"K";
			}
		}
		else
		{	
			result = String.valueOf(Math.round(cnt));		
		}
		
		return result;
	}
	
	static public String dateToMillisec(String regDate)
	{
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    String strDate = sdfDate.format(regDate);
	    return strDate;
	}
	
	
	
	static public void addFileController(FileMapper fileMapper,CommPost commPost,List<FileDto> fileList)
	{
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
		
		Map<String , String> addMap = null;
		
		if(fileList != null) {
			for(FileDto fileDto : fileList) {
				addMap = new HashMap<String , String>();
				addMap.put("referenceCode", commPost.getPostCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		fileMapper.addFileControl(addFileControlList);
	}
	
	
	
	
}
