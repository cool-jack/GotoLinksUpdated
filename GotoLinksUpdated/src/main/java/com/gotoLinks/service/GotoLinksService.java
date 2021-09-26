package com.gotoLinks.service;

import java.util.ArrayList;
import java.util.List;

import com.gotoLinks.entity.CategoryBean;
import com.gotoLinks.entity.LinksBean;
import com.gotoLinks.entity.UserBean;

public interface GotoLinksService {
	
	boolean saveUser(UserBean userBean);
	public UserBean getUserBean(String email);
	
	//link
	public LinksBean getLink(int linkId);
	public List<LinksBean> retriveUserLinks(String email);
	public boolean deleteLink(int linkId);
	public boolean updateLink(LinksBean linkBean);
	public boolean saveLink(LinksBean linkBean);
	public ArrayList<LinksBean> getLinksbyCategory(String email, int categoryId);
	public ArrayList<LinksBean> getLinksbyKeyword(String email, String linkNameKeyword);
	
	//category methods
	boolean updateCategory(String categoryName, int categoryId);
	boolean AddCategory(CategoryBean categoryBean);
	List<CategoryBean> retriveCategories(int userId);
	CategoryBean getCategory(int categoryId);
	boolean deleteCategory(int categoryId);

}
