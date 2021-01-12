package com.nt.dto;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;
@Data
public class JobSeekerDto implements Serializable {
	private Integer jsid;
	private String jsname;
	private String jsqlyf;
    private byte[] photo;
    private char[] resume;
}
