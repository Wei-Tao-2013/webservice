package com.iselect.gigyaService.model;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "GIGYA")
public class Gigya implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String socialUUID;
	private String vertical;
	private String verticalId;
	private String identifierType;	
	private String urlSaved;
	private Calendar createdDate;
	private Calendar updateddDate;

	public Gigya() {
	}

	 @Id 
	@SequenceGenerator(name="gigya_seq",allocationSize=1, sequenceName="GIGYA_SEQ")
	@GeneratedValue(strategy=IDENTITY, generator="gigya_seq")
    @Column(name="ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="SOCIAL_UUID")
	public String getSocialUUID() {
		return socialUUID;
	}

	public void setSocialUUID(String socialUUID) {
		this.socialUUID = socialUUID;
	}

	@Column(name="VERTICAL")
	public String getVertical() {
		return vertical;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	
	@Column(name="VERTICAL_ID")
	public String getVerticalId() {
		return verticalId;
	}

	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}

	@Column(name="IDENTIFIER_TYPE")
	public String getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_CREATED")
	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_UPDATED")
	public Calendar getUpdateddDate() {
		return updateddDate;
	}

	public void setUpdateddDate(Calendar updateddDate) {
		this.updateddDate = updateddDate;
	}

	@Column(name="URL_SAVED")
	public String getUrlSaved() {
		return urlSaved;
	}

	public void setUrlSaved(String urlSaved) {
		this.urlSaved = urlSaved;
	}
	
	

}
