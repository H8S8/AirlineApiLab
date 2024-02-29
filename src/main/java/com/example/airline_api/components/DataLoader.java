package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Create and save flights
        Flight flight1 = new Flight("Vancouver", 300, "28/07/24", "06:32");
        Flight flight2 = new Flight("Lisbon", 250, "12/04/24", "08:40");
        Flight flight3 = new Flight("Nicosia", 175, "02/05/24", "15:05");
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        //Create Passengers
        Passenger passenger1 = new Passenger("Hannah", "hannah@email.com");
        Passenger passenger2 = new Passenger("Matthew", "matthew@email.com");
        Passenger passenger3 = new Passenger("Geraldine", "geraldine@email.com");
        Passenger passenger4 = new Passenger("Nigel", "nigel@email.com");

        //Add flights to passengers
        passenger1.addFlight(flight1);
        passenger1.addFlight(flight3);
        passenger2.addFlight(flight2);
        passenger3.addFlight(flight1);
        passenger4.addFlight(flight1);
        passenger4.addFlight(flight2);

        //Save passengers
        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);
        passengerRepository.save(passenger4);
    }
}
