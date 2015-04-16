package spd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spd.domain.Question;
import spd.services.AnswersService;
import spd.services.QuestionsService;
import spd.services.TestService;
import spd.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	@RequestMapping("/test.action")
	public ModelAndView testController(HttpServletRequest request,
									   @RequestParam (required = true) Integer testid) throws Exception{
		ModelAndView mav = new ModelAndView("test");
		request.getSession().setAttribute("testID", testid);
		Integer questionID = QuestionsService.getInstance().getQuestionId(testid, request.getSession().getId());
		request.getSession().setAttribute("questionID", questionID);
		showQuestion(mav, questionID);
		return mav;
	}

	private void showQuestion(ModelAndView mav, Integer questionID) {
		Question question = QuestionsService.getInstance().getQuestion(questionID);
		mav.addObject("question", question);
		mav.addObject("answ", AnswersService.getInstance().getAnswers(questionID));
	}
	
	@RequestMapping("/question.action")
	public ModelAndView question(HttpServletRequest request,
								 @RequestParam(required=false) Integer res) throws Exception{
		ModelAndView mav = new ModelAndView("question");
		int userID =(Integer) request.getSession().getAttribute("userID");
		int testID = (Integer) request.getSession().getAttribute("testID");
		int questionID = (Integer) request.getSession().getAttribute("questionID");
		String sessionID = request.getSession().getId();
		TestService.getInstance().setCurrTest(userID, testID, questionID, res, sessionID);
		questionID = QuestionsService.getInstance().getQuestionId(testID, sessionID);
		showQuestion(mav, questionID);
		request.getSession().setAttribute("questionID", questionID);
		return  mav;
	}
	
	@RequestMapping("/showtest.action")
	public ModelAndView showTest(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("success");
		mav.addObject("tests", TestService.getInstance().getTests());
		String userName = (String) request.getSession().getAttribute("userName");
		String pass = (String) request.getSession().getAttribute("password");
		mav.addObject("username", userName);
		mav.addObject("userrole", UserService.getInstance().getUserRole(userName,pass));
		return mav;
	}
}
