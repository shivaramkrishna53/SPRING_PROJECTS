package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
@Entity
@Data
public class JobSeeker implements Serializable {

	@Id
	@GeneratedValue
	private Integer jsid;
	@Column(length = 20)
	private String jsname;
	@Column(length = 20)
	private String jsqlyf;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
}
