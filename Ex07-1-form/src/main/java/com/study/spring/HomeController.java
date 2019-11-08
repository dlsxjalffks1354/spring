package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.member.Member;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model)
	{
		String id = httpServletRequest.getParameter("id");
		String pw =httpServletRequest.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "board/confirmId";
	}
	
	@RequestMapping("/board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model)
	{
		model.addAttribute("identify",id);
		model.addAttribute("password",pw);
		return "board/checkId";
	}
	
	@RequestMapping("/member/join")
	public String joinData(Member member)
	{
		return "member/join";
	}
	
	
}
