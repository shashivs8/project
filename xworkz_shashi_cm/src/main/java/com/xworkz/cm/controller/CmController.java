package com.xworkz.cm.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.CmDTO;
import com.xworkz.cm.service.CmService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class CmController {

	public CmController() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Autowired
	public CmService cmService;
	
	

	@GetMapping("/reg")
	public String onCm(Model model) {
		System.out.println("running on get method");

		return "SignUp";
	}

	@PostMapping("/reg")
	public String onCm(Model model, CmDTO cmDTO) {

		log.info("running on post method");
		if (cmDTO.getPassword().equals(cmDTO.getConfirmPassword())) {

			Set<ConstraintViolation<CmDTO>> constraintViolations = this.cmService.validateAndSave(cmDTO);

			if (constraintViolations.isEmpty()) {
				
				log.info("" + cmDTO);
				return "Success";
			} else {

				model.addAttribute("errors", constraintViolations);
				model.addAttribute("messages", "Data Not Saved");
				System.out.println("violation exist");

			}
			return "SignUp";
		} else {
			model.addAttribute("password", "Password and Confirmpassword must be same");

		}
		return "SignUp";

	}
	

	@PostMapping("/signin")
	public String userSignIn(String userId, String password, Model model) {
		try {
		CmDTO dto = this.cmService.userSignIn(userId, password);
		if (dto!=null) {
			log.info("User ID and password is matched");
			model.addAttribute("userID",dto.getUserId());
			return "LoginSucess";
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			model.addAttribute("match", "UserID OR Password is not matching");
			return "SignIn";			

	}
	
	
}
