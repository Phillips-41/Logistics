package com.LiveEasy.logisticsApi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository  extends JpaRepository<ShipmentDetails,Long> {
    Optional<ShipmentDetails> findByShipperId(Long shipperId);
}
