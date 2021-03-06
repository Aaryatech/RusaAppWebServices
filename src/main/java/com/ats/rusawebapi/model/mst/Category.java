package com.ats.rusawebapi.model.mst;
 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
 
@Entity
@Table(name = "m_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="parent_id")
	private int parentId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="slug_name")
	private String slugName;
	
	@Column(name="cat_code")
	private String catCode;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="external_url")
	private String externalUrl;
	
	@Column(name="external_url_target")
	private String externalUrlTarget;
	
	@Column(name="cat_edit_date")
	private String catEditDate;
	
	 @Column(name="cat_add_date")
	private String catAddDate;
	
	@Column(name="cat_sort_no")
	private int catSortNo;
	
	@Column(name="cat_remark")
	private String catRemark;
	
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="ex_int2")
	private int exInt2;
	 
	@Transient
	List<CategoryDescription> CategoryDescriptionList;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public String getExternalUrlTarget() {
		return externalUrlTarget;
	}

	public void setExternalUrlTarget(String externalUrlTarget) {
		this.externalUrlTarget = externalUrlTarget;
	}

	public String getCatEditDate() {
		return catEditDate;
	}

	public void setCatEditDate(String catEditDate) {
		this.catEditDate = catEditDate;
	}

	public String getCatAddDate() {
		return catAddDate;
	}

	public void setCatAddDate(String catAddDate) {
		this.catAddDate = catAddDate;
	}

	public int getCatSortNo() {
		return catSortNo;
	}

	public void setCatSortNo(int catSortNo) {
		this.catSortNo = catSortNo;
	}

	public String getCatRemark() {
		return catRemark;
	}

	public void setCatRemark(String catRemark) {
		this.catRemark = catRemark;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	public List<CategoryDescription> getCategoryDescriptionList() {
		return CategoryDescriptionList;
	}

	public void setCategoryDescriptionList(List<CategoryDescription> categoryDescriptionList) {
		CategoryDescriptionList = categoryDescriptionList;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", parentId=" + parentId + ", catName=" + catName + ", slugName=" + slugName
				+ ", catCode=" + catCode + ", catDesc=" + catDesc + ", imageName=" + imageName + ", externalUrl="
				+ externalUrl + ", externalUrlTarget=" + externalUrlTarget + ", catEditDate=" + catEditDate
				+ ", catAddDate=" + catAddDate + ", catSortNo=" + catSortNo + ", catRemark=" + catRemark
				+ ", sectionId=" + sectionId + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", exInt2=" + exInt2
				+ ", CategoryDescriptionList=" + CategoryDescriptionList + "]";
	}
	
	
 
	
}
