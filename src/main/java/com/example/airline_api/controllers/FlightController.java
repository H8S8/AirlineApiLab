package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return null;
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(){
        return null;
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(){
        return null;
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(){
        return null;
    }

}
