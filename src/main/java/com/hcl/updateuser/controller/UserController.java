package com.hcl.updateuser.controller;

import java.util.Objects;
import java.util.Optional;
import java.util.List;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.updateuser.entity.User;
import com.hcl.updateuser.service.UserService;
import com.hcl.updateuser.utils.HibernateUtils;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserService userService;
		
	@GetMapping("/")
	public String welcome() {

		return "index";
	}
	
	@GetMapping("/register")
	public String welcoming() {
		
		return "register_form";
	}
	
	
	@PostMapping("/")
	public String submitSearch(Model model, @ModelAttribute("userid") String id) {
		
		log.info("Searching for user: " + id);
		
		try {
			Long uid = Long.parseLong(id);
			Optional<User> user = userService.searchUser(uid);
			if(user.isPresent()) {
				log.info("User: " + user.get());
				model.addAttribute("user", user.get());
				return "edit_user";
			} else {
				model.addAttribute("error", "No user is linked to that id. Try again.");
			}
		} catch(Exception e) {
			model.addAttribute("error", "That is not a valid ID. Please try again.");
		}
		return "index";

	}
	
	@PostMapping(value="/update/{id}")
	public String login(Model model, User user, @PathVariable("id") Long id) {
		log.info("[LOG] User: [" + user + "] is being updated.");
		user.setId(id);
		
		userService.updateUser(user);
		model.addAttribute(user);
		
		return "user_updated";
	}
}
