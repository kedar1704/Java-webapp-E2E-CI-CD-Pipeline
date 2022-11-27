package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.service.Addservice;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		
		float first_num = Float.parseFloat(request.getParameter("a1"));
		float second_num = Float.parseFloat(request.getParameter("a2"));
		
		Addservice as = new Addservice();
		float sum = as.add(first_num, second_num);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",sum);

		return mv;
	}
	
	@RequestMapping("/subtract")
	public ModelAndView subtract(HttpServletRequest request, HttpServletResponse response) {
		
		float first = Float.parseFloat(request.getParameter("b1"));
		float second = Float.parseFloat(request.getParameter("b2"));
		
		Addservice as2 = new Addservice();
		float diff = as2.subtract(first, second);
		
		ModelAndView mv1 = new ModelAndView();
		mv1.setViewName("display_sub");
		mv1.addObject("result1",diff);

		return mv1;
	}
	
	@RequestMapping("/multiply")
	public ModelAndView multiply(HttpServletRequest request, HttpServletResponse response) {
		
		float first_no = Float.parseFloat(request.getParameter("c1"));
		float second_no = Float.parseFloat(request.getParameter("c2"));
		
		Addservice as3 = new Addservice();
		float multiple = as3.multiply(first_no, second_no);
		
		ModelAndView mv2 = new ModelAndView();
		mv2.setViewName("display_multiple");
		mv2.addObject("result2",multiple);

		return mv2;
	}
	
	@RequestMapping("/divide")
	public ModelAndView division(HttpServletRequest request, HttpServletResponse response) {
		
		float first_number = Float.parseFloat(request.getParameter("d1"));
		float second_number = Float.parseFloat(request.getParameter("d2"));
		
		Addservice as4 = new Addservice();
		float div = as4.division(first_number, second_number);

		ModelAndView mv3 = new ModelAndView();
		mv3.setViewName("display_div");
		mv3.addObject("result3",div);

		return mv3;
	}
}
