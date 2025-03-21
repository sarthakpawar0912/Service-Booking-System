package com.srp.ServiceBookingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srp.ServiceBookingSystem.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {




	List<Reservation> findAllByCompanyId(Long CompanyId);

	List<Reservation> findAllByUserId(Long userId);
}
