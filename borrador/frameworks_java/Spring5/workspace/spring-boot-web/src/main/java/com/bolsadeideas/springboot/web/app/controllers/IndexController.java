package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping({ "/index", "/", "/home" })
	public String index(Model mv) {
		mv.addAttribute("titulo", "hola Spring Framework con ModelAndView!");
		return "index";
	}
}