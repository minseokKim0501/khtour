package ksmart42.khtour.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Reservation;
import ksmart42.khtour.dto.Room;
import ksmart42.khtour.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {

	private RoomService roomService;
	
	
	private static final Logger log = LoggerFactory.getLogger(RoomController.class);
	
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	/*
	 * 예약정보등록(post 정보 전달)
	 */ 
	@PostMapping("/roomPayment")
	public String addReservation(Reservation reservation) {

		roomService.addReservation(reservation);
		log.info(reservation + "예약정보등록");
		
		
		return "redirect:/accommodation/accommodationList";
	}
	
	/*
	 * 객실 예약 페이지(Get) 정보 전달 
	 */
	@GetMapping("/roomPayment")
	public String getRoomPayment(Model model
								,@RequestParam(value="roomCode", required = false) String roomCode) {
		log.info(roomCode);
		Room room = roomService.getRoomByCode(roomCode);
		model.addAttribute("title", "객실예약페이지");
		model.addAttribute("room", room);
		
		return "room/roomPayment";
	}
	
	/*
	 * 객실 정보 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/roomListSt")
	public String getRoomList(Model model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		List<Room> roomList = roomService.getRoomList(paramMap);

		log.info("객실관리자페이지" + roomList);
		model.addAttribute("title", "객실 관리자페이지");
		model.addAttribute("roomList", roomList);

		return "room/roomListSt";
	}
	
	/*
	 * 객실 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyRoom")
	public String modifyRoom(Room room) {
		
		roomService.modifyRoom(room);
		log.info(room + "수정정보");
		System.out.println("정보수정 POST방식 전달" + roomService.modifyRoom(room));
		
		return "redirect:/room/roomListSt";
	}
	
	/*
	 * 객실 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/roomModify")
	public String modifyRoom(@RequestParam(value = "roomCode", required = false) String roomCode
							,Model model) {
		Room room = roomService.getRoomByCode(roomCode);
		
		model.addAttribute("title", "객실 수정 페이지");
		model.addAttribute("room", room);
		System.out.println("객실수정 GEt방식 전달" + room);
		
		return "room/roomModify";
	}	
	
	/*
	 * 객실  정보 삭제(post 정보 전달)
	 */
	@GetMapping("/roomRemove")
	public String removeRoom(Room room) {
		String roomCode = room.getRoomCode();
		
		roomService.removeRoom(roomCode);
		System.out.println("정보 삭제 포스트 전달" + roomService.removeRoom(roomCode));
		
		return "redirect:/room/roomListSt";
		
	}
			
	/*
	 * 객실 등록(Post 정보 전달)
	 */
	@PostMapping("/roomInsert")
	public String addRoom(Room room
						  ,@RequestParam MultipartFile[] roomImageFiles
						  ,HttpServletRequest request) {
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		roomService.addRoom(room, roomImageFiles, fileRealPath);
		
		return "redirect:/room/roomListSt";
	}
	/*
	 * ldgCode에 맞는 겍실 등록(Get 정보 전달)
	 */
	@GetMapping("/roomInsert")
	public String addRoom(Model model
						 ,@RequestParam(value = "ldgCode") String ldgCode
						 ,@RequestParam(value = "ldgName") String ldgName) {
		
		model.addAttribute("ldgCode", ldgCode);
		model.addAttribute("ldgName", ldgName);
		model.addAttribute("title", "객실 등록");
		
		
		return "room/roomInsert";
	}
	
}
