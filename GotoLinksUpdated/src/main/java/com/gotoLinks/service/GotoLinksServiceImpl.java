package com.gotoLinks.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoLinks.dao.GotoLinksDao;
import com.gotoLinks.entity.CategoryBean;
import com.gotoLinks.entity.LinksBean;
import com.gotoLinks.entity.UserBean;

@Service
public class GotoLinksServiceImpl implements GotoLinksService {
	
	@Autowired
	GotoLinksDao linksDao;

	@Override
	public boolean saveUser(UserBean userBean) {
		linksDao.saveUser(userBean);
		return true;
	}
	
	public UserBean getUserBean(String email) {
		UserBean userBean = new UserBean();
		userBean = linksDao.getUser(email);		
		return userBean;
	}

	@Override
	public List<LinksBean> retriveUserLinks(String email) {
		ArrayList<LinksBean> userLinksList = new ArrayList<LinksBean>();
		userLinksList = (ArrayList<LinksBean>) linksDao.retriveUserLinks(email);
		for(LinksBean linkBean: userLinksList) {
			System.out.println("in service:"+linkBean.getLinkName());
		}
		return userLinksList;
	}

	@Override
	public boolean deleteLink(int linkId) {
		boolean linkDeleted = linksDao.deleteLink(linkId);
		return linkDeleted;
	}

	@Override
	public	boolean updateCategory(String categoryName, int categoryId) {
		
		boolean isUpdated = linksDao.updateCategory(categoryName, categoryId);
		return isUpdated;
	}

	@Override
	public boolean AddCategory(CategoryBean categoryBean) {
		boolean isSaved = linksDao.AddCategory(categoryBean);
		
		return isSaved;
	}

	@Override
	public List<CategoryBean> retriveCategories(int userId) {
		ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		categoryList = (ArrayList<CategoryBean>) linksDao.retriveCategories(userId);
		return categoryList;
	}

	@Override
	public CategoryBean getCategory(int categoryId) {
		CategoryBean categoryBean = new CategoryBean();
		categoryBean = linksDao.getCategory(categoryId);
		return categoryBean;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		boolean isDeleted = false;
		isDeleted = linksDao.deleteCategory(categoryId);
		return isDeleted;
	}

	@Override
	public boolean updateLink(LinksBean linkBean) {
		boolean isUpdated = linksDao.updateLink(linkBean);
		return isUpdated;
	}

	@Override
	public LinksBean getLink(int linkId) {
		LinksBean linkBean = linksDao.getLink(linkId);
		return linkBean;
	}

	@Override
	public boolean saveLink(LinksBean linkBean) {
		boolean isUpdated = linksDao.saveLink(linkBean);
		return isUpdated;
	}

	@Override
	public ArrayList<LinksBean> getLinksbyCategory(String email, int categoryId) {
		ArrayList<LinksBean> linkBeanList = new ArrayList<LinksBean>();
		
		linkBeanList = linksDao.getLinksbyCategory(email, categoryId);
		
		return linkBeanList;
	}

	@Override
	public ArrayList<LinksBean> getLinksbyKeyword(String email, String linkNameKeyword) {
		ArrayList<LinksBean> linkBeanList = new ArrayList<LinksBean>();
		
		linkBeanList = linksDao.getLinksbyKeyword(email, linkNameKeyword);
		
		return linkBeanList;
	}


}
