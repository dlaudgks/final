package net.edupoll.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.edupoll.kr.service.FreeboardService;

@Controller
public class FreeBoardController {

	@Autowired
	FreeboardService freeboardService;
	
	@RequestMapping("/freeboard/list")
	public String freeboardListHandle() {
		
		return "freeboard/list";
	}
	
	@RequestMapping("/freeboard/insert")
	public String freeboardInsertHandle() {
		
		return "freeboard/insert";
	}
	
	@RequestMapping("/freeboard/view")
	public String freeboardViewHandle() {
		
		return "freeboard/view";
	}
	
	
}
