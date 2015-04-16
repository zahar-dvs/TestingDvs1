package spd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spd.services.TestService;
import spd.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

	@RequestMapping("/login.action")
	public ModelAndView LogIn(HttpServletRequest request,
							 @RequestParam (required = true) String username,
							 @RequestParam (required = true) String password) throws Exception{
		ModelAndView mav = null;
		if (UserService.getInstance().loginUser(username, password)) {
			mav = new ModelAndView("success");
			mav.addObject("username", username);
			mav.addObject("password", password);
			mav.addObject("tests", TestService.getInstance().getTests());
			String userrole = UserService.getInstance().getUserRole(username, password);
			mav.addObject("userrole", userrole);
			Integer userID = UserService.getInstance().getUserId(username, password);
			request.getSession().setAttribute("userID", userID);
			request.getSession().setAttribute("password", password);
			request.getSession().setAttribute("userName",username);
		} else {
			mav = new ModelAndView("error");
		}
		return mav;
	}

	@RequestMapping("/register.action")
	public ModelAndView Register(HttpServletRequest request,
								@RequestParam (required = true) String username,
								@RequestParam (required = true) String password) throws Exception {
		ModelAndView mav = null;
		if (UserService.getInstance().isUserConsist(username)) {
			String userrole = "user";
			mav = new ModelAndView("success");
			UserService.getInstance().saveUser(username, password, userrole);
			mav.addObject("username", username);
			mav.addObject("tests", TestService.getInstance().getTests());
			Integer userID = UserService.getInstance().getUserId(username, password);
			request.getSession().setAttribute("userID", userID);
			request.getSession().setAttribute("userName", username);
			request.getSession().setAttribute("password", password);
			} else {
			mav = new ModelAndView("error2");
		}
		return mav;
	}
}
