package spd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spd.domain.Answers;
import spd.domain.User;
import spd.services.AnswersService;
import spd.services.QuestionsService;
import spd.services.TestService;
import spd.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 555 on 04.04.2015.
 */
@Controller
public class AdminController {
    @RequestMapping("/admin.action")
    public ModelAndView edit () throws Exception {
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("users", UserService.getInstance().getUsers());
        mav.addObject("user", new User());
        mav.addObject("tests", TestService.getInstance().getTests());
        return mav;
    }

    @RequestMapping("/addquestion.action")
    public ModelAndView addqustion (HttpServletRequest request,
                                    @RequestParam (required = true) Integer testid) throws  Exception{
        ModelAndView mav = new ModelAndView("addquestion");
        mav.addObject("testid", testid);
        request.getSession().setAttribute("quetestid", testid);
        return mav;
    }

    @RequestMapping("/savequestion.action")
    public ModelAndView saveQuestion (HttpServletRequest request,
                                    @RequestParam (required = true) String question,
                                    @RequestParam (required = true) String answer1,
                                    @RequestParam (required = true) String answer2,
                                    @RequestParam (required = true) String answer3,
                                    @RequestParam (required = true) String answer4) throws  Exception{
        ModelAndView mav = new ModelAndView("savequestion");
        Integer testId = (Integer) request.getSession().getAttribute("quetestid");
        QuestionsService.getInstance().saveQuestion(question, testId);
        Integer questionId = QuestionsService.getInstance().getQuestionId(question);
        AnswersService.getInstance().saveAnswers(questionId, answer1, answer2, answer3, answer4);
        mav.addObject("answers", AnswersService.getInstance().getAnswers(questionId));
        return mav;
    }

    @RequestMapping("/savecorrect.action")
    public ModelAndView saveCorrect (HttpServletRequest request,
                                      @RequestParam (required = true) Integer correct) throws  Exception{
        ModelAndView mav = new ModelAndView("addquestion");
        AnswersService.getInstance().setCorrect(correct);
        return mav;
    }

}
