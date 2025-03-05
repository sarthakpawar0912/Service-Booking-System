package com.srp.ServiceBookingSystem.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srp.ServiceBookingSystem.dto.AdDTO;
import com.srp.ServiceBookingSystem.dto.ReservationDTO;
import com.srp.ServiceBookingSystem.services.company.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/ad/{userId}")
	public ResponseEntity<?> postAd(@PathVariable Long userId,@ModelAttribute AdDTO adDTO) throws IOException{
		boolean success=companyService.postAd(userId, adDTO);
		if (success) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/ads/{userId}")
	public ResponseEntity<?> getAllAdsByUserId(@PathVariable Long userId){
		return ResponseEntity.ok(companyService.getAllAds(userId));
	}

	@GetMapping("/ad/{adId}")
	public ResponseEntity<?> getAdById(@PathVariable Long adId){
		AdDTO adDTO =companyService.getAdById(adId);
		if(adDTO != null) {
			return ResponseEntity.ok(adDTO);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/ad/{adId}")
	public ResponseEntity<?>updateAd(@PathVariable Long adId, @ModelAttribute AdDTO adDTO) throws IOException{
		boolean SUCCESS=companyService.updateAd(adId, adDTO);
		if(SUCCESS) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		return null;
	}

	@DeleteMapping("/ad/{adIds}")
	public ResponseEntity<?> deleteAd(@PathVariable Long adId){
		boolean SUCCESS=companyService.deleteAd(adId);
		if(SUCCESS) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/bookings/{companyId}")
	public ResponseEntity<List<ReservationDTO>> getAllAdBookings(@PathVariable Long companyId){
		return ResponseEntity.ok(companyService.geeAllAdBookings(companyId));
	}

	@GetMapping("/bookings/{bookingsId}/{status}")
	public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status){
		boolean SUCCESS=companyService.changeBookingStatus(bookingId, status);
		if(SUCCESS) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
}
