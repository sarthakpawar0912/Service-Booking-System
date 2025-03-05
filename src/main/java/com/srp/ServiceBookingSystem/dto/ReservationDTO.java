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

}
