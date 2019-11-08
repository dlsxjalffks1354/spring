package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BDeleteCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BReplyCommand;
import com.study.spring.command.BReplyViewCommand;
import com.study.spring.command.BWriteCommand;




@Controller
public class BController 
{
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model)
	{
		System.out.println("list()");
		command = new BListCommand();
		command.execute(request, model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String writeview(HttpServletRequest request, Model model)
	{
		System.out.println("여기는 write_view 입니다.");
		
		
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)
	{
		System.out.println("여기는 write 입니다.");
		
		command =new BWriteCommand();
		command.execute(request,model);
		return "redirect:list";
		
	}
	
	@RequestMapping("/content_view")
	public String contentview(HttpServletRequest request, Model model)
	{
		System.out.println("여기는 content_view 입니다.");
		command = new BContentCommand();
		command.execute(request, model);
		
		return "content_view";
	}
	
	
	@RequestMapping("/modify_view")
	public String modifyview(HttpServletRequest request, Model model)
	{
		System.out.println("여기는 modify_view 입니다.");
		command = new BContentCommand();
		command.execute(request, model);
		
		return "modify_view";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model)
	{
		System.out.println("여기는 modify 입니다.");
		command = new BModifyCommand();
		command.execute(request, model);
		command = new BContentCommand();
		command.execute(request, model);
		System.out.println("여기까진 잘됨");
		return "content_view";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model)
	{
		System.out.println("여기는 delete 입니다.");
		command = new BDeleteCommand();
		command.execute(request, model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String replyview(HttpServletRequest request, Model model)
	{
	System.out.println("여기는 reply_view 입니다.");
	command = new BReplyViewCommand();
	command.execute(request,model);
	
	return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model)
	{
	System.out.println("여기는 reply 입니다.");
	command = new BReplyCommand();
	command.execute(request,model);
	
	return "redirect:list";
	}
	
}
