package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_tpages_modules")
public class PagesModule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="primary_key_id")
	private int primaryKeyId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPrimaryKeyId() {
		return primaryKeyId;
	}

	public void setPrimaryKeyId(int primaryKeyId) {
		this.primaryKeyId = primaryKeyId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	@Override
	public String toString() {
		return "PagesModule [id=" + id + ", moduleId=" + moduleId + ", pageId=" + pageId + ", primaryKeyId="
				+ primaryKeyId + "]";
	}

	
}
