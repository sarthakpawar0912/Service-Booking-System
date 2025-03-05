package com.srp.ServiceBookingSystem.dto;

import java.util.Date;

import com.srp.ServiceBookingSystem.enums.ReservationStatus;
import com.srp.ServiceBookingSystem.enums.ReviewStatus;

import lombok.Data;

@Data
public class ReservationDTO {

	
	private Long id;
	
	private Date bookDate;
	
	private String servicename;
	
	private ReservationStatus reservationStatus;
	
	private ReviewStatus reviewStatus;
	
	private Long userId;
	
	private String userName;
	
	private Long companyId;

	private Long adId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", bookDate=" + bookDate + ", servicename=" + servicename
				+ ", reservationStatus=" + reservationStatus + ", reviewStatus=" + reviewStatus + ", userId=" + userId
				+ ", userName=" + userName + ", companyId=" + companyId + ", adId=" + adId + "]";
	}

	public ReservationDTO(Long id, Date bookDate, String servicename, ReservationStatus reservationStatus,
			ReviewStatus reviewStatus, Long userId, String userName, Long companyId, Long adId) {
		super();
		this.id = id;
		this.bookDate = bookDate;
		this.servicename = servicename;
		this.reservationStatus = reservationStatus;
		this.reviewStatus = reviewStatus;
		this.userId = userId;
		this.userName = userName;
		this.companyId = companyId;
		this.adId = adId;
	}

	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
