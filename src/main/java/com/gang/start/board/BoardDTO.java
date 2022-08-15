package com.gang.start.board;

import java.sql.Date;

public class BoardDTO {
	
	private int num;
	private String title;
	private String contexts;
	private String userName;
	private Date textDate;
	private int views;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContexts() {
		return contexts;
	}
	public void setContexts(String contexts) {
		this.contexts = contexts;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTextDate() {
		return textDate;
	}
	public void setTextDate(Date textDate) {
		this.textDate = textDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}

}
