package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Plan;

@Mapper
public interface PlanMapper {

	// 여행계획 목록조회
	public List<Plan> getPlanList(Map<String, Object> paramMap);
	
	// 여행계획 코드에 따른 여행계획 조회
	public Plan getPlanByCode(String planCode);
	
	// 여행계획 정보 등록
	public int addPlan(Plan plan);

	// 여행계획 정보 수정
	public int modifyPlan(Plan plan);
	
	// 여행계획 정보 삭제
	public int removePlan(String planCode);
}
