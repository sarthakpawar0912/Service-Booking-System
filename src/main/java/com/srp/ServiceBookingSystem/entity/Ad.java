package com.srp.ServiceBookingSystem.entity;

import java.util.Arrays;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.srp.ServiceBookingSystem.dto.AdDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ads")
@Data
public class Ad {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	
	private String serviceName;
	
	private String description;
	
	private Double price;
	
	
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;



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



	public byte[] getImg() {
		return img;
	}



	public void setImg(byte[] img) {
		this.img = img;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Ad [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price=" + price
				+ ", img=" + Arrays.toString(img) + ", user=" + user + "]";
	}



	public Ad(Long id, String serviceName, String description, Double price, byte[] img, User user) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		this.img = img;
		this.user = user;
	}



	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AdDTO getAdDto() {
		AdDTO adDTO = new AdDTO() ;
		adDTO.setId(id);
		adDTO.setServiceName(serviceName);
		adDTO.setDescription(description);
		adDTO.setPrice(price);
		adDTO.setCompanyName(user.getName());
		adDTO.setReturnedImg(img);
		
		return adDTO;
	}
	
	
	
}
