package srit.rhes.security.resources;

import java.security.Principal;

import javax.servlet.http.HttpSession;


import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import srit.rhes.security.model.UserSession;

@RestController
@RequestMapping("/rest")
public class SimpleResources {
	
	@GetMapping(path = "/hello",produces = MediaType.TEXT_PLAIN_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	public String ping() {
		return "hello";
	}
	@GetMapping(path="/welcome",produces = MediaType.TEXT_PLAIN_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String show() {
		return "welcome";
	}
	
	@GetMapping(path="/principle",produces = MediaType.TEXT_PLAIN_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String show(Principal principal) {
		String name=principal.getName();
		return name;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,HttpSession httpSession, String error, String logout) {
		
		String jSession=httpSession.getId();
		UserSession session=new UserSession();
		session.setJsessionCode(jSession);
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");
		return "login";
	}
}
