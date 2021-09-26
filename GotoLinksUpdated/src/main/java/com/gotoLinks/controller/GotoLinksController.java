package com.gotoLinks.controller;

import java.util.ArrayList;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gotoLinks.entity.CategoryBean;
import com.gotoLinks.entity.LinksBean;
import com.gotoLinks.entity.UserBean;
import com.gotoLinks.service.GotoLinksService;

@Controller
@SessionAttributes("userBean")
public class GotoLinksController {

	@Autowired
	GotoLinksService linkService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@RequestParam String email, @RequestParam String password, ModelMap model) {
		
		UserBean userBean = linkService.getUserBean(email);
		if(!(userBean == null)) {
			System.out.println("user passowrd:"+userBean.getPassword()+" and password:"+password);
			if(userBean.getPassword().equals(password)) {
				model.put("userBean", userBean);
				return "redirect:/showHomePage";
			}
			model.put("message", "incorrect password");
			return "login";
		}
		model.put("message", "incorrect email address");
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String firstName, @RequestParam String lastName , @RequestParam String email, 
			@RequestParam String password, ModelMap model) {
		
		UserBean userBean = new UserBean(firstName, lastName, email, password);
		linkService.saveUser(userBean);
		
		model.put("message", "Registration successful.");
		return "login";
	}
	
	@RequestMapping(value="/showHomePage")
	public String showUserLinks(ModelMap model) {
		UserBean userBean = (UserBean) model.get("userBean");
		ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) linkService.retriveCategories(userBean.getUserId());
		ArrayList<LinksBean> userLinksList = (ArrayList<LinksBean>) linkService.retriveUserLinks(userBean.getEmail());
		model.put("userLinks", userLinksList);
		model.put("categoryList", categoryList);
		return "userLinks";
	}
	
	@RequestMapping(value="/deleteLink")
	public String deleteLink( @RequestParam int linkId, ModelMap model) {
		
		boolean linkDeleted = linkService.deleteLink(linkId);
//		String message = "Link successfully deleted.";
//		if(!linkDeleted) message = "Sorry. Error occured. Please try again later.";
//		model.put("message", message);
		return "redirect:/showHomePage";
	}
	
	@RequestMapping(value="/listCategory", method = RequestMethod.GET)
	public String listCategory(ModelMap model) {
		ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		UserBean userBean = (UserBean) model.get("userBean");
		categoryList = (ArrayList<CategoryBean>) linkService.retriveCategories(userBean.getUserId());
		model.put("categoryList", categoryList);
		return "listCategory";
	}
	
	@RequestMapping(value="/addCategory", method = RequestMethod.GET)
	public String AddCategory(ModelMap model) {
		model.put("activePage","add");
		return "addEditCategory";
	}
	
	@RequestMapping(value="/addCategory", method = RequestMethod.POST)
	public String AddNewCategory(@RequestParam String categoryName , ModelMap model) {
		model.put("activePage","add");
		UserBean userBean = (UserBean) model.get("userBean");
		CategoryBean categoryBean = new CategoryBean(categoryName, userBean.getUserId());
		boolean isSaved = linkService.AddCategory(categoryBean);
		if(isSaved) {
			model.put("message", "category has been successfully added.");
		}
		model.put("message", "category coulnot be added due to an error. Please try again later.");
		return "redirect:/listCategory";
	}
	
	@RequestMapping(value="/editCategory", method = RequestMethod.GET)
	public String editCategoryPage(ModelMap model, @RequestParam int categoryId) {
		model.put("activePage","edit");
		CategoryBean categoryBean = new CategoryBean();
		categoryBean = linkService.getCategory(categoryId);
		model.put("categoryBean", categoryBean);
		
		return "addEditCategory";
	}
	
	@RequestMapping(value="/editCategory", method = RequestMethod.POST)
	public String editCategory(ModelMap model, @RequestParam String categoryName, @RequestParam int categoryId) {
		
		boolean isUpdated = linkService.updateCategory(categoryName, categoryId);
		
		if(isUpdated) model.put("message", "category has been successfully updated.");
		model.put("message", "category was not updated due to an error. Please try again letter.");
		return "redirect:/listCategory";
	}
	
	@RequestMapping(value="/deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model, @RequestParam int categoryId) {
		
		boolean isDeleted = linkService.deleteCategory(categoryId);
		
		if(isDeleted) model.put("message", "category has been successfully deleted.");
		model.put("message", "category was not deleted due to an error. Please try again letter.");
		return "redirect:/listCategory";
	}
	
	@RequestMapping(value="/updateLink", method = RequestMethod.GET)
	public String updateLinkPage(ModelMap model, @RequestParam int linkId) {
		model.put("activePage","edit");
		UserBean userBean = (UserBean) model.get("userBean");
		LinksBean linkBean = linkService.getLink(linkId);
		ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) linkService.retriveCategories(userBean.getUserId());
		CategoryBean categoryBean = linkService.getCategory(linkBean.getCategoryId());
		model.put("linkBean", linkBean);
		model.put("categoryBean", categoryBean);
		model.put("categoryList", categoryList);
		
		
		return "addEditLink";
	}
	
	@RequestMapping(value="/updateLink", method = RequestMethod.POST)
	public String updateLink(ModelMap model, @RequestParam int linkId, @RequestParam String linkName, 
			@RequestParam String linkUrl, @RequestParam int categoryId) {
		UserBean userBean = (UserBean) model.get("userBean");
		LinksBean linkBean = new LinksBean(linkName, linkUrl, userBean.getEmail(), categoryId);
		linkBean.setLinkId(linkId);
		
		boolean isUpdated = linkService.updateLink(linkBean);
		
		return "redirect:/showHomePage";
	}
	
	@RequestMapping(value="/addLink", method = RequestMethod.GET)
	public String addLinkPage(ModelMap model) {
		model.put("activePage","add");
		UserBean userBean = (UserBean) model.get("userBean");
		ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) linkService.retriveCategories(userBean.getUserId());
		
		model.put("categoryList",categoryList);
		
		return "addEditLink";
	}
	
	@RequestMapping(value="/addLink", method = RequestMethod.POST)
	public String addLink(ModelMap model, @RequestParam String linkName, 
			@RequestParam String linkUrl, @RequestParam int categoryId) {
		UserBean userBean = (UserBean) model.get("userBean");
		LinksBean linkBean = new LinksBean(linkName, linkUrl, userBean.getEmail(), categoryId);
		
		boolean isUpdated = linkService.saveLink(linkBean);
		
		return "redirect:/showHomePage";
	}
	
	@RequestMapping(value="/searchLinks", method = RequestMethod.GET)
	public String searchLinkPage(ModelMap model, @RequestParam String linkNameKeyword) {
		UserBean userBean = (UserBean) model.get("userBean");
		ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) linkService.retriveCategories(userBean.getUserId());
		ArrayList<LinksBean> userLinksList = linkService.getLinksbyKeyword(userBean.getEmail(), linkNameKeyword);
		model.put("userLinks", userLinksList);
		model.put("categoryList", categoryList);
		model.put("pageValue", "random");
		return "searchUserLinks";
	}
	@RequestMapping(value="/filterLinks", method = RequestMethod.GET)
	public String filterLinkPage(ModelMap model, @RequestParam int categoryId ) {
		UserBean userBean = (UserBean) model.get("userBean");
		ArrayList<CategoryBean> categoryList = (ArrayList<CategoryBean>) linkService.retriveCategories(userBean.getUserId());
		ArrayList<LinksBean> userLinksList = linkService.getLinksbyCategory(userBean.getEmail(), categoryId);
		CategoryBean categoryBean = linkService.getCategory(categoryId);
		model.put("userLinks", userLinksList);
		model.put("categoryBean", categoryBean);
		model.put("categoryList", categoryList);
		model.put("pageValue", "category");
		return "searchUserLinks";
	}
}
