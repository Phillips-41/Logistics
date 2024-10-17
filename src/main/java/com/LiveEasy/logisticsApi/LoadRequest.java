package com.LiveEasy.logisticsApi;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoadRequest {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private Long shipperId;
    private LocalDate shipDate;
}
