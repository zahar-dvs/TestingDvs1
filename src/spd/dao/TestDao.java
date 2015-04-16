package spd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import spd.domain.CurrTest;
import spd.domain.ResultTest;
import spd.domain.Test;

public class TestDao extends HibernateDaoSupport{

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Test> getTests() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Test.class);
		return criteria.list();
	}
	
	public void setCurrentTest(CurrTest currTest){
		sessionFactory.getCurrentSession().save(currTest);
	}

	public void setResultTest(ResultTest resultTest){
		sessionFactory.getCurrentSession().save(resultTest);
	}
	
	@SuppressWarnings("unchecked")
	public List<CurrTest> getCurrTest(Integer userID, String sessionID, Integer testID){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CurrTest.class)
									   .add(Restrictions.eq("userId", userID))
									   .add(Restrictions.eq("testId", testID))
									   .add(Restrictions.eq("sessionID", sessionID));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<ResultTest> getResultTest(Integer userID){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ResultTest.class)
				.add(Restrictions.eq("userId", userID));

		return criteria.list();
	}

	public void clearCurrTest(Integer userID, String sessionID, Integer testID){
		String sql = "Delete from CURRTEST " +
					 "where user_id = :userID " +
					 "and test_id = :testID " +
					 "and sessionID = :sessionID";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("testID", testID)
			 .setParameter("userID", userID)
			 .setParameter("sessionID", sessionID);
		query.executeUpdate();
	}
}