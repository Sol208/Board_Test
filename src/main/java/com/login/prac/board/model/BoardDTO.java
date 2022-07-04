package com.login.prac.board.model;

import java.util.Date;

public class BoardDTO {
		private String title, userName, mainText;
		private int postNo, views;
		private Date dateTime;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getPostNo() {
			return postNo;
		}
		public void setPostNo(int postNo) {
			this.postNo = postNo;
		}
		public int getViews() {
			return views;
		}
		public void setViews(int views) {
			this.views = views;
		}
		public String getMainText() {
			return mainText;
		}
		public void setMainText(String mainText) {
			this.mainText = mainText;
		}
		public Date getDateTime() {
			return dateTime;
		}
		public void setDateTime(Date dateTime) {
			this.dateTime = dateTime;
		}
		@Override
		public String toString() {
			return "BoardDTO [title=" + title + ", userName=" + userName + ", mainText=" + mainText + ", postNo="
					+ postNo + ", views=" + views + ", dateTime=" + dateTime + "]";
		}
}
