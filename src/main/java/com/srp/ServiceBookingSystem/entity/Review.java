package com.srp.ServiceBookingSystem.entity;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.srp.ServiceBookingSystem.dto.ReviewDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String review;
	
	private Date reviewDate;
	private Long rating;
	
	
	@ManyToOne(fetch =FetchType.LAZY,optional =false)
	@JoinColumn(name="user_id",nullable =false )
	@OnDelete(action= OnDeleteAction.CASCADE)
	private User user;
	
	
	
	@ManyToOne(fetch =FetchType.LAZY,optional =false)
	@JoinColumn(name="ad_id",nullable =false )
	@OnDelete(action= OnDeleteAction.CASCADE)
	private Ad ad;


	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getReview() {
		return review;
	}



	public void setReview(String review) {
		this.review = review;
	}



	public Date getReviewDate() {
		return reviewDate;
	}



	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}



	public Long getRating() {
		return rating;
	}



	public void setRating(Long rating) {
		this.rating = rating;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Ad getAd() {
		return ad;
	}



	public void setAd(Ad ad) {
		this.ad = ad;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + review + ", reviewDate=" + reviewDate + ", rating=" + rating
				+ ", user=" + user + ", ad=" + ad + "]";
	}



	public Review(Long id, String review, Date reviewDate, Long rating, User user, Ad ad) {
		super();
		this.id = id;
		this.review = review;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.user = user;
		this.ad = ad;
	}



	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ReviewDTO getDto() {
		ReviewDTO reviewDTO= new ReviewDTO();
		
		
		reviewDTO.setId(id);
		reviewDTO.setReview(review);
		reviewDTO.setRating(rating);
		reviewDTO.setReviewDate(reviewDate);
		reviewDTO.setUserId(user.getId());
		reviewDTO.setClientName(user.getName());
		reviewDTO.setAdId(ad.getId());
		reviewDTO.setServiceName(ad.getServiceName());
		
		return reviewDTO;
	}

	
	
}
