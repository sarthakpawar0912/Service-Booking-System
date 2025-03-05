package com.srp.ServiceBookingSystem.services.client;

import java.util.List;

import com.srp.ServiceBookingSystem.dto.AdDTO;
import com.srp.ServiceBookingSystem.dto.AdDetailsForClientDTO;
import com.srp.ServiceBookingSystem.dto.ReservationDTO;
import com.srp.ServiceBookingSystem.dto.ReviewDTO;


public interface ClientService {


	List<AdDTO> getAllAds();

	List<AdDTO> searchAdByName(String name);

	boolean bookService(ReservationDTO reservationDTO) ;

	AdDetailsForClientDTO getAdDetailsByAdId(Long adId) ;

	List<ReservationDTO> getAllBookingsByUserId(Long userId);

	Boolean giveReview(ReviewDTO reviewDTO);





}
