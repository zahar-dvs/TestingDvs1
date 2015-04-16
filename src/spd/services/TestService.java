package spd.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import spd.dao.TestDao;
import spd.domain.CurrTest;
import spd.domain.ResultTest;
import spd.domain.Test;
import spd.domain.User;

public class TestService {
	public static TestService instance;

	/**
	 * @return the instance
	 */
	public static TestService getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(TestService instance) {
		TestService.instance = instance;
	}

	private TestDao testDao;

	/**
	 * @return the testDao
	 */
	public TestDao getTestDao() {
		return testDao;
	}

	/**
	 * @param testDao the testDao to set
	 */
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	@Transactional
	public List<Test> getTests(){
		List<Test> list = testDao.getTests();
		return list;
	}

	@Transactional
	public void setCurrTest(Integer userID, Integer testID, Integer questionID, Integer answerID, String sessionID){
		CurrTest currTest = new CurrTest();
		currTest.setUserId(userID);
		currTest.setTestId(testID);
		currTest.setQuestionId(questionID);
		if (answerID!=0) {
			currTest.setAnswerId(answerID);
		}
		currTest.setSessionID(sessionID);
		testDao.setCurrentTest(currTest);
	}

	@Transactional
	public void setResultTest(Integer userID, Integer testID, Integer result){
		ResultTest resultTest = new ResultTest();
		resultTest.setUserId(userID);
		resultTest.setTestId(testID);
		resultTest.setResult(result);
		testDao.setResultTest(resultTest);
	}

	@Transactional
	public List<CurrTest> getCurrTest(Integer userID, String sessionID, Integer testID){
		List<CurrTest> list = testDao.getCurrTest(userID, sessionID, testID);
		return list;
	}

	@Transactional
	public LinkedList<Object> getTestId(Integer userID){
		LinkedList<Object> result = new LinkedList<Object>();
		List<ResultTest> list = testDao.getResultTest(userID);
		for (ResultTest resultTest : list) {
			result.add(resultTest.getTestId());
		}
		return result;
	}

	@Transactional
	public LinkedList<Object> getResultTest(Integer userID){
		LinkedList<Object> result = new LinkedList<Object>();
		List<ResultTest> list = testDao.getResultTest(userID);
		for (ResultTest resultTest : list) {
			result.add(resultTest.getResult());
		}
		return result;
	}

	@Transactional
	public void clearCurrTest(Integer userID, String sessionID, Integer testID){
		testDao.clearCurrTest(userID, sessionID, testID);
	}
}
