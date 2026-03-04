package com.capgemini.cachepractice.entity;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

//file upload download
//upload file or image
//convert to blob and store in database
//covert to folder->file->path->url->db
//for blob
@Entity
public class FileData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String filename;
	String filetype;
	
	//to store data
	@Lob
	private byte[] data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename; 
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public FileData(int id, String filename, String filetype, byte[] data) {
		this.id = id;
		this.filename = filename;
		this.filetype = filetype;
		this.data = data;
	}
	
	public FileData(){
		
	}

	@Override
	public String toString() {
		return "FileData [id=" + id + ", filename=" + filename + ", filetype=" + filetype + ", data="
				+ Arrays.toString(data) + "]";
	}
	
	
	
	

}
