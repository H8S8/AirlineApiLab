package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }

    public Flight addPassenger(Long flightId, Long passengerId) throws Exception{
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        Optional<Passenger> passengerOptional = passengerRepository.findById(passengerId);

        if(!flightOptional.isPresent()){
            throw new Exception("Invalid flight Id");
        }
        if(!passengerOptional.isPresent()){
            throw new Exception("Invalid passenger Id");
        }

        Flight flight = flightOptional.get();
        Passenger passenger = passengerOptional.get();

        passenger.addFlight(flight);
        passengerRepository.save(passenger);

        return flight;
    }

    public void cancelFlight(long id) throws Exception{
        Optional<Flight> flightOptional = flightRepository.findById(id);

        if(!flightOptional.isPresent()){
            throw new Exception("Flight does not exist.");
        }

        Flight flight = flightOptional.get();

        for(Passenger passenger : flight.getPassengers()){
            passenger.removeFlight(flight);
        }

        flightRepository.delete(flight);
    }
}
