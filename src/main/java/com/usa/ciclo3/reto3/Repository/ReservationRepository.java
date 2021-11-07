package com.usa.ciclo3.reto3.Repository;

import com.usa.ciclo3.reto3.Interface.InterfaceReservation;
import com.usa.ciclo3.reto3.Model.Client;
import com.usa.ciclo3.reto3.Model.Custom.CountClient;
import com.usa.ciclo3.reto3.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

        public List<Reservation> getReservationByStatus(String status){
              return  interfaceReservation.findAllByStatus(status);
        }

        public List<Reservation> getReservationPeriod(Date dateOne,Date dateTwo){
            return interfaceReservation.findAllByStartDateAfterAndAndStartDateBefore(dateOne,dateTwo);
        }

        public List<CountClient> getTopClient(){
            List<CountClient> listado= new ArrayList<>();

            List<Object[]> reporte= interfaceReservation.countReservationByClient();

            for(int i = 0;i< reporte.size();i++){
                listado.add(new CountClient((long) reporte.get(i)[1],(Client) reporte.get(i)[0]));
            }

            return listado;
        }
}
