package net.edupoll.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import net.edupoll.kr.entity.FreeBoardVo;
import net.edupoll.kr.service.FreeboardService;

@Controller
public class FreeBoardController {

	@Autowired
	FreeboardService freeboardService;
	
	@GetMapping("/freeboard/list" )
	public String freeboardListHandle(Model model) {
		
		model.addAttribute("all",freeboardService.getAll());
		
		return "freeboard/list";
	}
	
	@RequestMapping(path="/freeboard/insert", method=RequestMethod.GET)
	public String insertGetHandle() {
		
		return "freeboard/insert";
	}
	
	@RequestMapping(path="/freeboard/insert", method=RequestMethod.POST)
	public String insertPostHandle(@ModelAttribute("vo") FreeBoardVo vo, Model model) {
		boolean rst = freeboardService.addNewOne(vo);
		if(!rst) {
			return "/freeboard/insert";
		}
		return "redirect:/freeboard/list";
	}
	
	@RequestMapping("/freeboard/view")
	public String freeboardViewHandle(@RequestParam int no, Model model,
				@SessionAttribute(required = false) Boolean auth) {
		
		FreeBoardVo vo = freeboardService.getOneByNo(no);
		if(vo ==null) {
			return "redirect:/freeboard/list";
		}
		model.addAttribute("one", vo);
		
		return "freeboard/view";
	}
	
	
}
