package spd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import spd.domain.Answers;
import spd.domain.Question;

public class AnswersDao extends HibernateDaoSupport{

	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Answers> getAnswers(int question_id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Answers.class)
										.add(Restrictions.eq("questionId", question_id));
		return criteria.list();
	}

	public Answers getCurrAnswer(Integer answerID){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Answers.class)
										.add(Restrictions.eq("id", answerID));
		return (Answers) criteria.uniqueResult();
	}

	public Answers getCorrectAnswer(Integer questionID){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Answers.class)
										.add(Restrictions.eq("questionId", questionID))
										.add(Restrictions.eq("correct", 1));
		return (Answers) criteria.uniqueResult();
	}

	public void saveAnswer(Answers answers){
		getHibernateTemplate().save(answers);
	}

	public void saveCorrect(Integer correctId){
		String sss = "Update ANSWERS set ANSWERS.CORRECT = 1 where ANSWERS.ID = "+correctId.toString();
		String sql = sss;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.executeUpdate();
	}

}
