package com.xworkz.cm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@Table(name = "shashi_cm")

  @NamedQuery(name = "find",query = "select ent from CmEntity ent")
  
  @NamedQuery(name = "userId",query =
  "select count(*) from  CmEntity ent where ent.userId=:userBy")
  
  @NamedQuery(name = "emailId",query =
  "select count(*) from  CmEntity ent where ent.email=:emailBy")
  
  @NamedQuery(name = "mobileId",query =
  "select count(*) from  CmEntity ent where ent.mobile=:mobileBy")
  
  @NamedQuery(name="userANDpassword",query =
  "select ent from CmEntity ent where ent.userId=:ui and ent.password=:pwd ")
 
public class CmEntity {
	
	@Id
	@Column(name ="id")
	private int id;
	
	@Column(name ="userId")
	private String userId;

	@Column(name ="email")
	private String email;
	
	@Column(name = "mobile")
	private Long mobile;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "CreatedDate")
	private LocalDateTime createdDate;
	

	@Column(name = "UpdatedBy")
	private String updatedBy;

	@Column(name = "UpdatedDate")
	private LocalDateTime updatedDate;
	
}
