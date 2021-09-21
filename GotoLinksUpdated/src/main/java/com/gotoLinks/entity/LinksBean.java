package com.gotoLinks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="links")
public class LinksBean {

	@Id
	@GeneratedValue
	@Column(name = "link_id")
	private int linkId;
	
	@Column(name = "link_name")
	private String linkName;
	
	@Column(name = "link_url")
	private String linkUrl;
	
	@Column(name = "user_email")
	private String user_email;

	@Column(name = "category_id")
	private int categoryId;

	public LinksBean() {}
	
	public LinksBean(String linkName, String linkUrl, String user_email, int categoryId) {
		super();
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.user_email = user_email;
		this.categoryId = categoryId;
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
}
