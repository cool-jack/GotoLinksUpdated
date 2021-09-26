package com.gotoLinks.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.spi.IsolationDelegate;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gotoLinks.entity.CategoryBean;
import com.gotoLinks.entity.LinksBean;
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
	
	@Transactional
	public UserBean getUser(String email) {
		
		UserBean userBean = new UserBean();
		
		Query<UserBean> query = sessionFactory.getCurrentSession().createQuery("from UserBean where email = :email");
		query.setParameter("email", email);
		userBean = query.uniqueResult();
		return userBean;
	}

	@Override
	@Transactional
	public List<LinksBean> retriveUserLinks(String email) {
		ArrayList<LinksBean> userLinksList = new ArrayList<LinksBean>();
		
		Query<LinksBean> query = sessionFactory.getCurrentSession().createQuery("from LinksBean where user_email = :email");
		query.setParameter("email", email);
		userLinksList = (ArrayList<LinksBean>) query.getResultList();
		for(LinksBean linkBean: userLinksList) {
			System.out.println("in dao:"+linkBean.getLinkName());
		}
		return userLinksList;
	}

	@Override
	@Transactional
	public boolean deleteLink(int linkId) {
		boolean linkDeleted = false;
		Query query = sessionFactory.getCurrentSession().createQuery("delete from LinksBean where linkId = :linkId");
		query.setParameter("linkId", linkId);
		int i = query.executeUpdate();
		if(i == 1) linkDeleted = true;
		return linkDeleted;
	}

	@Override
	@Transactional
	public boolean updateCategory(String categoryName, int categoryId) {
		
		boolean isUpdated = false;
		
		Query query = sessionFactory.getCurrentSession().createQuery("update CategoryBean set categoryName=:categoryName "
				+ "where categoryId =:categoryId");
		query.setParameter("categoryName", categoryName);
		query.setParameter("categoryId", categoryId);
		
		int i = query.executeUpdate();
		if (i == 1) isUpdated = true;
		return isUpdated;
	}

	@Override
	@Transactional
	public boolean AddCategory(CategoryBean categoryBean) {
		
		sessionFactory.getCurrentSession().save(categoryBean);
				
		return true;
	}

	@Override
	@Transactional
	public List<CategoryBean> retriveCategories(int userId) {
		ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		
		Query<CategoryBean> query = sessionFactory.getCurrentSession().createQuery("from CategoryBean where userId=:userId");
		query.setParameter("userId", userId);
		categoryList = (ArrayList<CategoryBean>) query.getResultList();
		
		return categoryList;
	}

	@Override
	@Transactional
	public CategoryBean getCategory(int categoryId) {
		
		CategoryBean categoryBean = new CategoryBean();
		
		Query<CategoryBean> query = sessionFactory.getCurrentSession().createQuery("from CategoryBean where categoryId =:categoryId");
		query.setParameter("categoryId", categoryId);
		categoryBean = query.uniqueResult();
		return categoryBean;
	}

	@Override
	@Transactional
	public boolean deleteCategory(int categoryId) {
		
		boolean isDeleted = false;
		Query query1 = sessionFactory.getCurrentSession().createQuery("delete from LinksBean where categoryId=:categoryId");
		query1.setParameter("categoryId", categoryId);
		int i = query1.executeUpdate();
		Query query = sessionFactory.getCurrentSession().createQuery("delete from CategoryBean where categoryId=:categoryId");
		query.setParameter("categoryId", categoryId);
		int j = query.executeUpdate();
		
		if(i == 1 && j == 1) isDeleted = true;
		return isDeleted;
	}

	@Override
	@Transactional
	public boolean updateLink(LinksBean linkBean) {
		boolean isUpdated=true;
		
		sessionFactory.getCurrentSession().update(linkBean);
		
		return isUpdated;
	}

	@Override
	@Transactional
	public LinksBean getLink(int linkId) {
		LinksBean linkBean = new LinksBean();
		
		Query<LinksBean> query = sessionFactory.getCurrentSession().createQuery("from LinksBean where linkId =:linkId");
		query.setParameter("linkId", linkId);
		linkBean = query.uniqueResult();
		return linkBean;
	}

	@Override
	@Transactional
	public boolean saveLink(LinksBean linkBean) {
		boolean isUpdated=true;
		sessionFactory.getCurrentSession().save(linkBean);
		return isUpdated;
	}

	@Override
	@Transactional
	public ArrayList<LinksBean> getLinksbyCategory(String email, int categoryId) {
		ArrayList<LinksBean> linkBeanList = new ArrayList<LinksBean>();
		
		Query<LinksBean> query = sessionFactory.getCurrentSession().createQuery("from LinksBean where categoryId=:categoryId and user_email =:email");
		query.setParameter("categoryId", categoryId);
		query.setParameter("email", email);
		linkBeanList = (ArrayList<LinksBean>) query.getResultList();
		
		return linkBeanList;
	}

	@Override
	@Transactional
	public ArrayList<LinksBean> getLinksbyKeyword(String email, String linkNameKeyword) {
		ArrayList<LinksBean> linkBeanList = new ArrayList<LinksBean>();
		Query<LinksBean> query = sessionFactory.getCurrentSession().createQuery("from LinksBean where user_email =:email and linkName like :linkNameKeyword");
		query.setParameter("email", email);
		query.setParameter("linkNameKeyword", "%"+linkNameKeyword+"%");
		linkBeanList = (ArrayList<LinksBean>) query.getResultList();
		
		return linkBeanList;
	}
	
}
