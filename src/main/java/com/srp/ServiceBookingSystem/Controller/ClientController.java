package com.srp.ServiceBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srp.ServiceBookingSystem.dto.ReservationDTO;
import com.srp.ServiceBookingSystem.dto.ReviewDTO;
import com.srp.ServiceBookingSystem.services.client.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired(required=true)
	private ClientService clientService;

	@GetMapping("/ads")
	public ResponseEntity<?> getAllAds(){
		return ResponseEntity.ok(clientService.getAllAds());
	}

	@GetMapping("/search/{name}")
	public ResponseEntity<?> searchAdByservice(@PathVariable String name){
		return ResponseEntity.ok(clientService.searchAdByName(name));
	}

	@PostMapping("/book-service")
	public ResponseEntity<?> bookService(@RequestBody ReservationDTO reservationDTO){
		boolean SUCCESS=clientService.bookService(reservationDTO);
		if(SUCCESS) {
			return ResponseEntity.status(HttpStatus.OK).build();

		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/ad/{adId}")
	public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long AdId){
		return ResponseEntity.ok(clientService.getAdDetailsByAdId(AdId));
	}

	@GetMapping("/my-bookings/{userId}")
	public ResponseEntity<?> getAllBookingsByUserId(@PathVariable Long userId){
		return ResponseEntity.ok(clientService.getAllBookingsByUserId(userId));
	}

	@PostMapping("/review")
	public ResponseEntity<?> giveReview(@RequestBody ReviewDTO reviewDTO){
		Boolean SUCESS= clientService.giveReview(reviewDTO);
		if(SUCESS) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
