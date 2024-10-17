package com.LiveEasy.logisticsApi;

import com.LiveEasy.logisticsApi.handler.InvalidRequestException;
import com.LiveEasy.logisticsApi.handler.ShipmentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository repository;

    public String loadShipment(LoadRequest request) {
        if (request.getNoOfTrucks() <= 0) {
            throw new InvalidRequestException("Number of trucks must be greater than zero.");
        }

        ShipmentDetails load = ShipmentDetails.builder()
                .loadingPoint(request.getLoadingPoint())
                .unloadingPoint(request.getUnloadingPoint())
                .productType(request.getProductType())
                .truckType(request.getTruckType())
                .noOfTrucks(request.getNoOfTrucks())
                .shipperId(request.getShipperId())
                .weight(request.getWeight())
                .shipDate(request.getShipDate())
                .build();
        repository.save(load);
        return "Load Details added successfully";
    }

    public ShipmentDetails getShipmentById(Long shipperId) {
        return repository.findByShipperId(shipperId)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found for shipper ID: " + shipperId));
    }

    public ShipmentDetails getShipmentByLoadId(Long loadId) {
        return repository.findById(loadId)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found for load ID: " + loadId));
    }

    public String updateShipment(Long loadId, LoadRequest shipmentDetails) {
        return repository.findById(loadId)
                .map(load -> {
                    load.setLoadingPoint(shipmentDetails.getLoadingPoint());
                    load.setUnloadingPoint(shipmentDetails.getUnloadingPoint());
                    load.setProductType(shipmentDetails.getProductType());
                    load.setTruckType(shipmentDetails.getTruckType());
                    load.setNoOfTrucks(shipmentDetails.getNoOfTrucks());
                    load.setShipperId(shipmentDetails.getShipperId());
                    load.setWeight(shipmentDetails.getWeight());
                    load.setShipDate(shipmentDetails.getShipDate());
                    repository.save(load);
                    return "Update Details successfully";
                })
                .orElse("Shipment not found");
    }


    public String deleteShipment(Long loadId) {
        if (!repository.existsById(loadId)) {
            throw new ShipmentNotFoundException("Shipment not found for load ID: " + loadId);
        }
        repository.deleteById(loadId);
        return "Deleted Details successfully";
    }
}

