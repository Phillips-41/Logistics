package com.LiveEasy.logisticsApi.handler;

public class ShipmentNotFoundException extends RuntimeException{
    public ShipmentNotFoundException(String s) {
        super(s);
    }
}
