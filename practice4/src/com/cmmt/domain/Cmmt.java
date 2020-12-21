package com.cmmt.domain;

public class Cmmt {
	private int cmmt_id;
	private int board_id;
	private String msg;
	private String author;
	private String cdate;
	
	public int getCmmt_id() {
		return cmmt_id;
	}
	public void setCmmt_id(int cmmt_id) {
		this.cmmt_id = cmmt_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
}
