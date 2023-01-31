package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Reservation;
import ksmart42.khtour.dto.Room;

@Mapper
public interface RoomMapper {
	
	// ldg_code에 맞는 객실 조회
	public List<Room> getRoomListByldgCode(String ldgCode);
	
	// 객실 목록조회
	public List<Room> getRoomList();
	
	// 객실 등록
	public int addRoom(Room room);
	
	// 객실 조회
	public Room getRoomByCode(String roomCode);
		
	// 객실 수정
	public int modifyRoom(Room room);
		
	// 객실 삭제
	public int removeRoom(String roomCode);
	
	//객실 목록조회 관리자
	public List<Room> getRoomList(Map<String, Object> paramMap);
	
	//객실 목록조화 관리자 페이지
	public List<Room> getRoomListSt(Map<String, Object> paramMap);
	
	
	public void addReservation(Reservation reservation);

}
