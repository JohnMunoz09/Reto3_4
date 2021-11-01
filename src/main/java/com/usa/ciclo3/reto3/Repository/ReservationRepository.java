package com.usa.ciclo3.reto3.Repository;

import com.usa.ciclo3.reto3.Interface.InterfaceReservation;
import com.usa.ciclo3.reto3.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

        @Autowired
        private InterfaceReservation interfaceReservation;

        public List<Reservation> getAllReservation(){
            return (List<Reservation>) interfaceReservation.findAll();
        }

        public Optional<Reservation> getReservation(int idReservation){
            return interfaceReservation.findById(idReservation);
        }

        public Reservation save(Reservation reservation){
            return interfaceReservation.save(reservation);
        }

        public void delete(Reservation reservation){
            interfaceReservation.delete(reservation);
        }


}
