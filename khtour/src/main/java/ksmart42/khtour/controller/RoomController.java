package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {
	
	/*
	 * 객실 등록 
	 * */
	@GetMapping("room/roomInsert")
	public String addRoom(Model model) {
		
		model.addAttribute("title", "객실등록");
		
		return "room/roomInsert";
	}
	
	/*
	 * 객실 검색
	 * */
	@GetMapping("room/roomList")
	public String getRoom(Model model) {
		
		model.addAttribute("title", "객실검색");
		
		return "room/roomList";
	}
	
	/*
	 * 객실 수정
	 * */
	@GetMapping("room/roomModify")
	public String modifyRoom(Model model) {
		
		model.addAttribute("title", "객실수정");
		
		return "room/roomModify";
	}
	
	/*
	 * 객실 삭제
	 * */
	@GetMapping("room/roomDelete")
	public String deleteRoom(Model model) {
		
		model.addAttribute("title", "객실삭제");
		
		return "room/roomDelete";
	}
}
