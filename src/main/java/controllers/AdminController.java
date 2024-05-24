package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminController {
	@RequestMapping(value = {"/admin"})
	public String admin(Model model, HttpSession session) {
		/*
		 * model.addAttribute("mess", "Welcome to admin page"); CustomUserDetails user =
		 * (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
		 * .getPrincipal(); session.setAttribute("user", user);
		 */
		return "admin/index";
	}
}
