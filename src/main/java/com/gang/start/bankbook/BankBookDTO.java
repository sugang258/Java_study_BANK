package com.gang.start.bankbook;

public class BankBookDTO {
	
	private long booknum;
	private String bookname;
	private double bookrate;
	private boolean booksale;
	
	public long getBooknum() {
		return booknum;
	}
	public void setBooknum(long booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public boolean getBooksale() {
		return booksale;
	}
	public void setBooksale(boolean booksale) {
		this.booksale = booksale;
	}
	public boolean isBookSale() {
		// TODO Auto-generated method stub
		return this.booksale;
	}
	
	

}
