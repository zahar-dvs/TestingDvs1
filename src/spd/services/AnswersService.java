package spd.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import spd.dao.AnswersDao;
import spd.domain.Answers;
import spd.domain.CurrTest;
import spd.domain.Question;

public class AnswersService {
	public static AnswersService instance;

	/**
	 * @return the instance
	 */
	public static AnswersService getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(AnswersService instance) {
		AnswersService.instance = instance;
	}
	
	private AnswersDao answersDao;

	/**
	 * @return the answersDao
	 */
	public AnswersDao getAnswersDao() {
		return answersDao;
	}

	/**
	 * @param answersDao the answersDao to set
	 */
	public void setAnswersDao(AnswersDao answersDao) {
		this.answersDao = answersDao;
	}


	@Transactional
	public List<Answers> getAnswers(int question_id){
		List<Answers> list= answersDao.getAnswers(question_id);
		return list;
	}


	@Transactional
	public LinkedList<Object> getCurrAnswer(Integer userID, String sessionID, Integer testID){
		LinkedList<Object> currAnswers = new LinkedList<Object>();
		List<CurrTest> list = TestService.getInstance().getCurrTest(userID, sessionID, testID);
		for (CurrTest currTest : list) {
			if (currTest.getAnswerId() != 0) {
				currAnswers.add(answersDao.getCurrAnswer(currTest.getAnswerId()).getAnswer());
			} else {
				currAnswers.add("The answer is not selected");
			}
		}
		return currAnswers;
	}

	@Transactional
	public LinkedList<Object> getCorrectAnswer(Integer userID, String sessionID, Integer testID){
		LinkedList<Object> correctAnswers = new LinkedList<Object>();
		List<CurrTest> list = TestService.getInstance().getCurrTest(userID, sessionID, testID);
		for (CurrTest currTest : list) {
			correctAnswers.add(answersDao.getCorrectAnswer(currTest.getQuestionId()).getAnswer());
		}
		return correctAnswers;
	}


	@Transactional
	public Integer result(Integer userID, String sessionID, Integer testID){
		int i = 0;

		List<CurrTest> list = TestService.getInstance().getCurrTest(userID, sessionID, testID);
		for (CurrTest currTest : list) {
			if (currTest.getAnswerId() != 0){
				if(answersDao.getCurrAnswer(currTest.getAnswerId()).getCorrect() == 1){
					i++;
				}
			}
		}
		
		return i;
	}


	public void saveAnswers(Integer questionId, String answer1, String answer2, String answer3, String answer4){
		Answers answers1 = new Answers();
		answers1.setQuestionId(questionId);
		answers1.setAnswer(answer1);
		answersDao.saveAnswer(answers1);
		Answers answers2 = new Answers();
		answers2.setQuestionId(questionId);
		answers2.setAnswer(answer2);
		answersDao.saveAnswer(answers2);
		if (answer3 != "") {
			Answers answers3 = new Answers();
			answers3.setQuestionId(questionId);
			answers3.setAnswer(answer3);
			answersDao.saveAnswer(answers3);
		}
		if (answer4 != "") {
			Answers answers4 = new Answers();
			answers4.setQuestionId(questionId);
			answers4.setAnswer(answer4);
			answersDao.saveAnswer(answers4);
		}
	}

	@Transactional
	public void setCorrect(Integer correctId){
		answersDao.saveCorrect(correctId);
	}

}
