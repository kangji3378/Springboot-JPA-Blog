package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity//user 클래스가 MySQL에 테이블 생성이 된다.
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 	전략을 따라간다.
	private int id;
	
	@Column(nullable=false,length=30)
	private String username;
	
	@Column(nullable=false,length=100)
	private String password;
	
	@Column(nullable=false,length=50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // Enum을 쓰는게 좋다
	
	@CreationTimestamp //시간이 자동입력
	private Timestamp createDate;
}
