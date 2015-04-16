package spd.dao;

import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import spd.domain.Question;
import spd.domain.User;

public class QuestionsDao extends HibernateDaoSupport{

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public ArrayList<Object> genQuesId(int testID){
		String sql = "Select QUESTIONS.ID from QUESTIONS where QUESTIONS.TEST_ID = :testid";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("testid", testID);
		return (ArrayList<Object>) query.list();
	}

	public Question getQuestion(Integer id) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, id);
	}

	public void saveQuestion(Question question){
		sessionFactory.getCurrentSession().save(question);
	}

	public Integer getQuestionId(String question){

		String sql = "Select QUESTIONS.ID from QUESTIONS where QUESTIONS.QUESTION = :questionid";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("questionid", question);
		return (Integer) query.list().get(0);
	}

}