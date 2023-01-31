package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Point;
import ksmart42.khtour.mapper.PointMapper;

@Service
@Transactional
public class PointService {
	//DI 의존성 주입
	private PointMapper pointMapper;
	
	public PointService(PointMapper pointMapper) {
		this.pointMapper = pointMapper;
	}
	
	/**
	 * 코드에 따른 여행계획 목록 조회
	 * @author 김민석
	 * @param pointCode
	 */
	public Point getPointByCode(String pointCode) {
		return pointMapper.getPointByCode(pointCode);
	}
	/**
	 * 여행계획 등록
	 * @author 김민석
	 * @param point
	 */
	public void addPoint(Point point) {
		pointMapper.addPoint(point);
	}
	
	/**
	 * 관리자 포인트 목록 조회
	 */
	public List<Point> getAdPointList(Map<String, Object> paramMap){
		List<Point> getAdPointList = pointMapper.getAdPointList(paramMap);
		
		return getAdPointList;
	}

	/**
	 * 여행계획 정보 수정
	 * @author 김민석
	 * @param point
	 */
	public int modifyPoint(Point point) {
		return pointMapper.modifyPoint(point);
	}
	
	/**
	 * 코드에 따른 여행계획 정보 삭제
	 * @author 김민석
	 * @param pointCode
	 */
	public int removePoint(String pointCode) {
		int result = pointMapper.removePoint(pointCode);
		
		result += pointMapper.removePoint(pointCode);
		
		return result;
	}
}
