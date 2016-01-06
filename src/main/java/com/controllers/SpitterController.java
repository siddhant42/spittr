package com.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.data.Spitter;
import com.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	@Autowired
	public SpitterController(
			SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	@RequestMapping(value="/register", method=POST)
	public String processRegistration(Spitter spitter) throws SQLException,ClassNotFoundException {
		spitterRepository.save(spitter);
		return "redirect:/spitter/" +
		spitter.getUsername();
	}
	@RequestMapping(value="/{username}", method=GET)
	public String showSpitterProfile(@PathVariable String username, Model model) throws SQLException {
			//Spitter spitter = spitterRepository.findByUsername(username);
			//model.addAttribute(spitter);
			return "profile";
			}
}
