package com.study.spring.command;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;


@Component
public class BListCommand implements BCommand{
	@Autowired
	private ApplicationContext context;
	
	@Override
	public void execute(HttpServletRequest request,Model model)
	{
		BDao dao =(BDao)context.getBean(BDao.class);
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}
