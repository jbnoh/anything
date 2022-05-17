package com.anything.db.jpa.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class UserVo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;

	private String userId;

	private String userPw;

	private String userName;

	private String userMobile;
}
