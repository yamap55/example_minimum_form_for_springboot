package com.example.demo;

import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String index(InputForm form, Model model) {
		model.addAttribute("inputForm", form);
		return "index";
	}

	@RequestMapping("result")
	public String result(@ModelAttribute("inputForm") @Valid InputForm form, BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {
	        return index(form, model);
	    }
		// TODO DBに保存
		return "result";
	}
}
