package ksmart42.khtour.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

	@GetMapping("/communityDashBoard")
	public String main(Model model) {
		
		model.addAttribute("title", "커뮤니티 대시보드");
		
		return "/community/communityDashBoard";
	}
}
