/*
 * paging 泥섎━瑜� �옱�궗�슜�꽦�쓣 �넂�씠 �겢�옒�뒪 �젙�쓽
 * */
package com.board.utill;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Pager {
	private int totalRecord; //珥� �젅肄붾뱶 �닔 
	private int pageSize = 10; //�럹�씠吏��떦 蹂댁뿬吏� �젅肄붾뱶 �닔 
	private int totalPage;
	private int blockSize=10; //釉붾윮�떦 蹂댁뿬吏� �럹�씠吏� �닔
	private int currentPage = 1; //�쁽�옱 �럹�씠吏�
	private int firstPage;
	private int lastPage;
	private int curPos;
	private int num ;
	
	
	//�꽑�뼵�맂 蹂��닔 珥덇린�솕
	public void init(HttpServletRequest request, List list) {
		totalRecord = list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize);
		//�럹�씠吏�瑜� �꽑�깮�븳 寃쎌슦�뿏, 洹� �꽑�깮�맂 �럹�씠吏�濡� ��泥�
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage - (currentPage-1) % blockSize;
		lastPage = firstPage + (blockSize -1);
		curPos = (currentPage - 1) * pageSize; //�럹�씠吏��떦 List�궡�뿉�꽌�쓽 �떆�옉 index
		num = totalRecord - curPos; //�럹�씠吏��떦 �떆�옉 踰덊샇
	}


	public int getTotalRecord() {
		return totalRecord;
	}


	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getBlockSize() {
		return blockSize;
	}


	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getFirstPage() {
		return firstPage;
	}


	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}


	public int getLastPage() {
		return lastPage;
	}


	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	public int getCurPos() {
		return curPos;
	}


	public void setCurPos(int curPos) {
		this.curPos = curPos;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
}
