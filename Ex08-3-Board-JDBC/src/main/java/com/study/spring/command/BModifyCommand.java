package com.study.spring.command;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;

public class BModifyCommand implements BCommand {
	
	@Autowired
	private ApplicationContext context;
	
	@Override
	public void execute(HttpServletRequest request, Model model)
	{
		String bId= request.getParameter("bId");
		String bName= request.getParameter("bName");
		String bTitle= request.getParameter("bTitle");
		String bContent= request.getParameter("bContent");
		BDao dao =(BDao)context.getBean(BDao.class);
		dao.modify(bId,bName,bTitle,bContent);
	}

}
