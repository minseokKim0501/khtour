package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Point;

@Mapper
public interface PointMapper {

	// 여행계획 목록조회
	public List<Point> getAdPointList(Map<String, Object> paramMap);
	
	// 여행계획 코드에 따른 여행계획 조회
	public Point getPointByCode(String pointCode);
	
	// 여행계획 정보 등록
	public int addPoint(Point point);

	// 여행계획 정보 수정
	public int modifyPoint(Point point);
	
	// 여행계획 정보 삭제
	public int removePoint(String pointCode);
}
