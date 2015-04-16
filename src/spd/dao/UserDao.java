package spd.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;
import spd.domain.Test;
import spd.domain.User;

import javax.imageio.spi.ServiceRegistry;
import javax.security.auth.login.Configuration;
import java.util.List;

public class UserDao extends HibernateDaoSupport{

	@Autowired
	SessionFactory sessionFactory;

	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public User getUser(String username, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	public User isUserConsist(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}
}