package com.synap.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.synap.model.CalcDTO;
import com.synap.service.TestService;

@Controller
public class SynapController {
	
	@Autowired
	TestService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public ModelAndView calculate(@RequestParam(defaultValue = "숫자를 입력하시면 결과가 나옵니다.") String result, CalcDTO dto, ModelAndView mv) {
		System.out.println("result"+result);
		String str = dto.getStr();
		mv.addObject("String", result);
		mv.setViewName("home");
//		model.addAttribute("answer", answer);
		
		return mv;
	}
}
