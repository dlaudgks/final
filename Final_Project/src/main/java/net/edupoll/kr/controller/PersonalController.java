package net.edupoll.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.service.PersonalService;

@SessionAttributes("loginUser")
@Controller
public class PersonalController {

	@Autowired
	PersonalService personalService;
	
	@RequestMapping("/settings")
	public String settingHandle() {
		
		
		return "personal/settings";
	}
	
	
	@PostMapping("/settings/modify")
	public String settingsModifyHandle(@ModelAttribute("loginUser") AccountVo vo) {
		//loginUser객체를 vo에 추가 
		
		
		System.out.println(vo);
		boolean r = personalService.modifyAccount(vo);
		if(r) {
			
		}
		return "redirect:/settings";
	}
	
	@PostMapping("/settings/profile")
	public String settingsProfileHandle(@ModelAttribute("lo") AccountVo vo) {
		System.out.println(vo);
		boolean r = personalService.profileAccount(vo);
		if(r) {}
	return "redirect:/settings";
		
	}
	
	
	@PostMapping("/settings/email")
	public String settingsEmailHandle() {
		// email 이라는 이름으로 데이터가 넘어옴
		// 그 정보로 로그인 사용자의 email을 update
		
		return "personal/email";
	}
	
	@GetMapping("/settings/auth")
	public String settingsAuthHandle() {
		
		return "personal/auth";
	}
	
	@ResponseBody
	@RequestMapping("/settings/reqAuth")
	public String reqAuthHandle() throws InterruptedException {
		//메일서비스를 이용하게 될꺼임..
		System.out.println("reqAuthHandle..");
		Thread.sleep(5000);
		
		return "true";
	}
	
	
}
