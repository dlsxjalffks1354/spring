package com.study.spring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import com.study.spring.dao.BDao;

public class BWriteCommand implements BCommand{

	@Autowired
	private ApplicationContext context;
	
	
	@Override
	public void execute(HttpServletRequest request, Model model)
	{
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao =(BDao)context.getBean(BDao.class);
		dao.write(bName,bTitle,bContent);
	}

}
