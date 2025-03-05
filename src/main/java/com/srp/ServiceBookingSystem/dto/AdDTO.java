package com.srp.ServiceBookingSystem.dto;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class AdDTO {

private Long id;
	
	
	private String serviceName;
	
	private String description;
	
	private Double price;
	
	private MultipartFile img;
	
	private byte[] returnedImg;
	
	private Long userId;
	
	private String companyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public byte[] getReturnedImg() {
		return returnedImg;
	}

	public void setReturnedImg(byte[] returnedImg) {
		this.returnedImg = returnedImg;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "AdDTO [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price=" + price
				+ ", img=" + img + ", returnedImg=" + Arrays.toString(returnedImg) + ", userId=" + userId
				+ ", companyName=" + companyName + "]";
	}

	public AdDTO(Long id, String serviceName, String description, Double price, MultipartFile img, byte[] returnedImg,
			Long userId, String companyName) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		this.img = img;
		this.returnedImg = returnedImg;
		this.userId = userId;
		this.companyName = companyName;
	}

	public AdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
