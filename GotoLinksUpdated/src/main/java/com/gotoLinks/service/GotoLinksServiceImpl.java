package com.gotoLinks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoLinks.dao.GotoLinksDao;
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

}
