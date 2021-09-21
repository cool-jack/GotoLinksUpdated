package com.gotoLinks.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gotoLinks.entity.UserBean;

@Repository
public class GotoLinksDaoImpl implements GotoLinksDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean saveUser(UserBean userBean) {
		
		sessionFactory.getCurrentSession().save(userBean);
		
		return true;
	}
	
}
