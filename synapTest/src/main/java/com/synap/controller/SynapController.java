package com.synap.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synap.model.CalcDTO;
import com.synap.service.TestService;

@Controller
public class SynapController {
	
	TestService service = new TestService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/test/calculate", method = RequestMethod.GET)
	public Model calculate(CalcDTO dto, Model model) {

		String str = dto.getStr();

//		model.addAttribute("answer", answer);
		
		return model;
	}
}
