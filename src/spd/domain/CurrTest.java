package spd.domain;

import javax.persistence.*;

@Entity
@Table(name="CURRTEST")
public class CurrTest {
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="TEST_ID")
	private int testId;
	@Column(name="QUESTION_ID")
	private int questionId;
	@Column(name="ANSWER_ID")
	private int answerId;
	@Column(name="USER_ID")
	private int userId;
	@Column(name="SESSIONID")
	private String sessionID;
	
	/**
	 * @return the sessionID
	 */
	public String getSessionID() {
		return sessionID;
	}
	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	/**
	 * @return the user_id
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the test_id
	 */
	public int getTestId() {
		return testId;
	}
	/**
	 * @param test_id the test_id to set
	 */
	public void setTestId(int test_id) {
		this.testId = test_id;
	}
	/**
	 * @return the question_id
	 */
	public int getQuestionId() {
		return questionId;
	}
	/**
	 * @param question_id the question_id to set
	 */
	public void setQuestionId(int question_id) {
		this.questionId = question_id;
	}
	/**
	 * @return the answer_id
	 */
	public int getAnswerId() {
		return answerId;
	}
	/**
	 * @param answer_id the answer_id to set
	 */
	public void setAnswerId(int answer_id) {
		this.answerId = answer_id;
	}

}
