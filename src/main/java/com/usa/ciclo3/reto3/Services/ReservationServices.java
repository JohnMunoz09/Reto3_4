package com.usa.ciclo3.reto3.Services;

import com.usa.ciclo3.reto3.Model.Custom.CountClient;
import com.usa.ciclo3.reto3.Model.Custom.StatusReservation;
import com.usa.ciclo3.reto3.Model.Reservation;
import com.usa.ciclo3.reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {

    @Autowired

    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation() {
        return reservationRepository.getAllReservation();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> r = reservationRepository.getReservation(reservation.getIdReservation());
            if (r.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }

        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    public  List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }

    public StatusReservation getStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        return new StatusReservation(completed.size(),cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String date1,String date2) {

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(date1);
            dateTwo = parser.parse(date2);
        } catch (ParseException error) {
            error.printStackTrace();
        }

        if (dateOne.before(dateTwo)) {
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList<>();

        }
    }
 }