package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Message;
import com.example.demo.repository.MessageRepository;

@SpringBootApplication
@Controller
public class DemoApplication {

	@Autowired MessageRepository repository;

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
		repository.save(new Message(form));
		return "result";
	}
}
