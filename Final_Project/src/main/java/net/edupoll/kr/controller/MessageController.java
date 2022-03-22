package net.edupoll.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.entity.MessageVo;
import net.edupoll.kr.service.MessageService;
import net.edupoll.kr.websocket.AlertService;

@Controller
public class MessageController {
	@Autowired
	MessageService messageService;
	@Autowired
	AlertService alertService;
	
	@RequestMapping({"/message", "/message/received"})
	public String messageDefaultHandle(Model model,
				@SessionAttribute("loginUser") AccountVo loginUser) {
		
		List<MessageVo> li = messageService.getReceivedMessages(loginUser.getUserId());
		model.addAttribute("received",li);

		return "message/received";
	}
	
	
	@RequestMapping("/message/sent")
	public String messageSentHandle(Model model,
			@SessionAttribute("loginUser") AccountVo loginUser) {
		
		List<MessageVo> li = messageService.getSentMessages(loginUser.getUserId());
		model.addAttribute("sent",li);
		
		return "message/sent";
	}
	
	@RequestMapping("/message/write")
	public String messageWriteHandle() {
		
		return "message/write";
	}
	
	@RequestMapping("/message/sending")
	public String messageWriteHandle(@ModelAttribute MessageVo vo,
				@SessionAttribute("loginUser") AccountVo loginUser, Model model) {
	
		boolean r = messageService.sendNewMessage(loginUser.getUserId(), vo);
		if(r) {
			alertService.alertNewMessage(vo.getRecipient());
		}
		model.addAttribute("rst", r);
		
		return "message/write";
	}

	
	// @ExceptionHandler(Exception.class)
	public String exepctionHandel(Exception e , Model model) {
		
		
		return "message/error";
	}
}
