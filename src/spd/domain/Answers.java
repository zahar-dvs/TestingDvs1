package spd.domain;

import javax.persistence.*;
@Entity
@Table(name="ANSWERS")
public class Answers {
	@Id
	@Column(name="ID")
	private int id;
//	@Column(name="TETS_ID")
//	private int testId;
	@Column(name="QUESTION_ID")
	private int questionId;
	@Column(name="ANSWER")
	private String answer;
	@Column(name="CORRECT")
	private int correct;
	/**
	 * @return the correct
	 */
	public int getCorrect() {
		return correct;
	}
	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(int correct) {
		this.correct = correct;
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
	 * @return the tets_id
//	 */
//	public int getTestId() {
//		return testId;
//	}
//	/**
//	 * @param tets_id the tets_id to set
//	 */
//	public void setTestId(int tets_id) {
//		this.testId = tets_id;
//	}
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
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
