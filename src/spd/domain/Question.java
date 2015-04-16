package spd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class Question {
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="TEST_ID")
	private int testId;
	@Column(name="QUESTION")
	private String question;
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
}
