package com.LiveEasy.logisticsApi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("load")
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;
    @PostMapping
    public ResponseEntity<String> loadShipment(@RequestBody LoadRequest request) {
        return ResponseEntity.ok(shipmentService.loadShipment(request));
    }
    @GetMapping("/shipid/{shipperId}")
    public ResponseEntity<ShipmentDetails> getShipmentById(@PathVariable Long shipperId) {
        return ResponseEntity.ok(shipmentService.getShipmentById(shipperId));
    }
    @GetMapping("/loadid/{loadId}")
    public ResponseEntity<ShipmentDetails> getShipmentByLoadId(@PathVariable Long loadId) {
        return ResponseEntity.ok(shipmentService.getShipmentByLoadId(loadId));
    }
    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateShipment(@PathVariable Long loadId, @RequestBody LoadRequest shipmentDetails) {
        return ResponseEntity.ok(shipmentService.updateShipment(loadId,shipmentDetails));
    }
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteShipment(@PathVariable Long loadId) {
        return ResponseEntity.ok(shipmentService.deleteShipment(loadId));
    }

}
