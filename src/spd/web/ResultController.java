package spd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spd.domain.ResultTest;
import spd.domain.User;
import spd.services.AnswersService;
import spd.services.QuestionsService;
import spd.services.TestService;
import spd.services.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ResultController {

	@RequestMapping("/result.action")
	public ModelAndView Result(HttpServletRequest request,
							   @RequestParam(required=true) Integer res) throws Exception{
		ModelAndView mav = new ModelAndView("result");
		int userID =(Integer) request.getSession().getAttribute("userID");
		int testID = (Integer) request.getSession().getAttribute("testID");
		int questionID = (Integer) request.getSession().getAttribute("questionID");
		String sessionID = request.getSession().getId();
		TestService.getInstance().setCurrTest(userID, testID, questionID, res, sessionID);
		QuestionsService.getInstance().clearMap(request.getSession().getId());
		mav.addObject("questions", QuestionsService.getInstance().showQuestion(userID, sessionID, testID));
		mav.addObject("currAnswers", AnswersService.getInstance().getCurrAnswer(userID, sessionID, testID));
		mav.addObject("correctAnswers", AnswersService.getInstance().getCorrectAnswer(userID, sessionID, testID));
		Integer i = AnswersService.getInstance().result(userID, sessionID, testID);
		mav.addObject("result",  i);
		TestService.getInstance().setResultTest(userID, testID, i);
		TestService.getInstance().clearCurrTest(userID, sessionID, testID);
		return mav;
	}

	@RequestMapping("/userResults.action")
	public ModelAndView UserResults(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("userResults");
		int userID =(Integer) request.getSession().getAttribute("userID");
		mav.addObject("questions", TestService.getInstance().getTestId(userID));
		mav.addObject("currAnswers", TestService.getInstance().getResultTest(userID));
		return mav;
	}

}
