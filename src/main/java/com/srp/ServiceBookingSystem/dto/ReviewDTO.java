package com.srp.ServiceBookingSystem.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
	private Long id;
	private String review;
	private Date reviewDate;
	private Long rating;
	private Long userId;
	private Long adId;
	private String clientName;
	private String serviceName;
	private Long bookId;
}
