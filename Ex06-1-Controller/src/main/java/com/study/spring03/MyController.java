package com.study.spring03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController 
{
	

	@RequestMapping(value = "/board/view")
	public String view() {
		
		return "board/view";
	}
	
	@RequestMapping(value = "/board/content")
	public String content(Model model) {
		
		model.addAttribute("id",30);
		return "board/content";
	}
	
	@RequestMapping(value = "/board/reply")
	public ModelAndView reply() 
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);
		mv.setViewName("board/reply");
		
		return mv;
	}
	
}
