package com.ats.rusawebapi.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat; 


@Entity
public class NewsSectionList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="newsblogs_id")
	private int newsblogsId;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="news_source_url_name")
	private String newsSourceUrlName;
	
	@Column(name="event_location")
	private String eventLocation;
	
	@Column(name="event_date_from")
	private Date eventDateFrom;
	
	@Column(name="event_date_to")
	private Date eventDateTo;
	
	@Column(name="event_contact_person")
	private String eventContactPerson;
	
	@Column(name="event_contact_number")
	private String eventContactNumber;
	
	@Column(name="page_order")
	private int pageOrder; 
	
	@Column(name="featured_image")
	private String featuredImage;
	
	@Column(name="featured_image_alignment")
	private String featuredImageAlignment;
	
	@Column(name="download_pdf")
	private String downloadPdf;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="add_date")
	private Date addDate;
	
	@Column(name="edit_date")
	private Date editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;
 
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="views_count")
	private int viewsCount;
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="descriptions")
	private String descriptions;

	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getNewsSourceUrlName() {
		return newsSourceUrlName;
	}

	public void setNewsSourceUrlName(String newsSourceUrlName) {
		this.newsSourceUrlName = newsSourceUrlName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEventDateFrom() {
		return eventDateFrom;
	}

	public void setEventDateFrom(Date eventDateFrom) {
		this.eventDateFrom = eventDateFrom;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEventDateTo() {
		return eventDateTo;
	}

	public void setEventDateTo(Date eventDateTo) {
		this.eventDateTo = eventDateTo;
	}

	public String getEventContactPerson() {
		return eventContactPerson;
	}

	public void setEventContactPerson(String eventContactPerson) {
		this.eventContactPerson = eventContactPerson;
	}

	public String getEventContactNumber() {
		return eventContactNumber;
	}

	public void setEventContactNumber(String eventContactNumber) {
		this.eventContactNumber = eventContactNumber;
	}

	public int getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(int pageOrder) {
		this.pageOrder = pageOrder;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getFeaturedImageAlignment() {
		return featuredImageAlignment;
	}

	public void setFeaturedImageAlignment(String featuredImageAlignment) {
		this.featuredImageAlignment = featuredImageAlignment;
	}

	public String getDownloadPdf() {
		return downloadPdf;
	}

	public void setDownloadPdf(String downloadPdf) {
		this.downloadPdf = downloadPdf;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public int getAddedByUserId() {
		return addedByUserId;
	}

	public void setAddedByUserId(int addedByUserId) {
		this.addedByUserId = addedByUserId;
	}

	public int getEditByUserId() {
		return editByUserId;
	}

	public void setEditByUserId(int editByUserId) {
		this.editByUserId = editByUserId;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public int getViewsCount() {
		return viewsCount;
	}

	public void setViewsCount(int viewsCount) {
		this.viewsCount = viewsCount;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "NewsSectionList [newsblogsId=" + newsblogsId + ", pageId=" + pageId + ", newsSourceUrlName="
				+ newsSourceUrlName + ", eventLocation=" + eventLocation + ", eventDateFrom=" + eventDateFrom
				+ ", eventDateTo=" + eventDateTo + ", eventContactPerson=" + eventContactPerson
				+ ", eventContactNumber=" + eventContactNumber + ", pageOrder=" + pageOrder + ", featuredImage="
				+ featuredImage + ", featuredImageAlignment=" + featuredImageAlignment + ", downloadPdf=" + downloadPdf
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", addDate=" + addDate + ", editDate="
				+ editDate + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", viewsCount="
				+ viewsCount + ", heading=" + heading + ", descriptions=" + descriptions + "]";
	}
	
	
	
	

}
