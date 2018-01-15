package com.cts.revenueforecast.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.model.User;
import com.cts.revenueforecast.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView loginInit(@ModelAttribute("loginForm") User user, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User userValid = userService.isUserValid(user);
		if (userValid != null) {
			session.setAttribute("userValid", userValid);
			// session.setAttribute("loggedInUserFirstName",
			// user.getFirst_name());
			// session.setAttribute("loggedInUserRole", user);
			modelAndView.setViewName("redirect:/welcome.html");

		} else {
			modelAndView.addObject("msg", "<span style='color:red'>Login Failed Please try again</span>");
			modelAndView.setViewName("forward:/");

		}
		return modelAndView;
	}

	@RequestMapping("/welcome")
	public String sendWelcomeHome() {
		return "welcome";
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.GET)
	public String redirectToLogin() {
		return "redirect:/";
	}

	@RequestMapping(value = "/doLogout")
	public ModelAndView processLogout(HttpSession session) {
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "<span style='color:green'>Logout Action Completed Successfully</span>");
		modelAndView.setViewName("loginview");
		return modelAndView;
	}
	/*
	 * @RequestMapping(value="/expiredsession") public ModelAndView
	 * sessionExpireNotify(HttpSession session){ ModelAndView modelAndView=new
	 * ModelAndView(); modelAndView.addObject("msg",
	 * "Session Expired ! Please Login again. . . ");
	 * modelAndView.setViewName("loginview"); return modelAndView; }
	 */

	@RequestMapping(value = "/registerform")
	public ModelAndView viewRegisterForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registerformview");
		return modelAndView;
	}

	@RequestMapping(value = "/signupprocess", method = RequestMethod.POST)
	public ModelAndView signUpUser(@ModelAttribute("registerform") User user) {
		Boolean success = userService.addUser(user);
		ModelAndView modelAndView = new ModelAndView();

		if (success) {
			modelAndView.addObject("msg",
					"<span style='color:green'>Registration Successful After Approval You Can Login</span>");
			modelAndView.setViewName("loginview");
		} else {
			modelAndView.addObject("msg", "<span style='color:red'>Registration failed ! Please try Again</span>");
			modelAndView.setViewName("registerformview");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/sendToken")
	public ModelAndView forgotPassRequest(@RequestParam("user_id") int user_Id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forgotpassview");
		User userId = new User();
		userId.setUser_id(user_Id);
		// Validation Done
		try {
			User user = userService.validateUser(userId);
			if (user == null) {
				modelAndView.addObject("message", "User ID not valid. Please enter correct User ID");
			} else {
				int result = userService.generateToken(user);
				if (result != 0) {
					modelAndView.setViewName("forgotpasschange");
					modelAndView.addObject("user_Id", user_Id);
					modelAndView.addObject("message",
							"Forgot Password Token Generated. Please contact Admin for Token to update password");
				} else {
					modelAndView.addObject("message", "User ID not valid. Please enter correct User ID");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return modelAndView;
	}

	@RequestMapping(value = "/listusers")
	public ModelAndView showUserList() {
		ModelAndView modelAndView = new ModelAndView();
		List<User> userlist = userService.getAllUsers();
		modelAndView.addObject("userList", userlist);
		modelAndView.setViewName("userlistview");
		return modelAndView;
	}

	@RequestMapping(value = "/saveforgotpass")
	public ModelAndView saveForgotPassword(@RequestParam("user_Id") String user_Id,
			@RequestParam("password") String password, @RequestParam("token") String token) {
		ModelAndView modelAndView = new ModelAndView();
		int result = userService.saveForgotPassword(user_Id, password, token);
		if (result != 0) {
			modelAndView.setViewName("forward:/");
			modelAndView.addObject("message", "Password Updated Successfully! Please Login..");
		} else {
			modelAndView.setViewName("forgotpasschange");
			modelAndView.addObject("message", "Updation Failed! Please enter the correct Token or User ID");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/savechangepass")
	public ModelAndView saveChangePassword(@RequestParam("currentPass") String currentPassword,
			@RequestParam("newPass") String newPassword, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User)session.getAttribute("userValid");
		String user_Id=String.valueOf(user.getUser_id()); 
		int result = userService.saveChangePassword(user_Id, currentPassword, newPassword);
		if(result==1)
		{
			modelAndView.setViewName("forward:/");
			modelAndView.addObject("message", "Password Updated Successfully! Please Login..");
		}
		else
		{
			modelAndView.setViewName("changepassview");
			modelAndView.addObject("message", "Updation Failed! Please enter the correct current password");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/changepass")
	public String changePass() {
		return "changepassview";
	}

	@RequestMapping(value = "/forgotPassView")
	public String forgotPassView() {
		return "forgotpassview";
	}

	@RequestMapping(value = "/generatePass")
	public String forgotPassChangeView() {
		return "forgotpasschange";
	}

}
