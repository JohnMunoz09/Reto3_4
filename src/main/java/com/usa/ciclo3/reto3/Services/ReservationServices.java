package com.usa.ciclo3.reto3.Services;

import com.usa.ciclo3.reto3.Custom.CountClient;
import com.usa.ciclo3.reto3.Custom.StatusReservation;
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

/**
 * @Autor John Muñoz
 */

@Service
public class ReservationServices {
    /**
     * Objeto ReservationRepository
     */
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Metodo que obtiene todos los resultados de la reservacion
     */
     public List<Reservation> getAllReservation() {
        return reservationRepository.getAllReservation();
    }

    /**
     * Metodo que obtiene reservacion buscada por id
     * @param idReservation
     * @return
     */
    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    /**
     * Metodo que registra la reservacion
     * @param reservation que permite cargar datos
     * @return
     */
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

    /**
     * Metodo que sirve para actualizar registros
     * @param reservation Parametro que permite obtener valores de reservacion
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> revision = reservationRepository.getReservation(reservation.getIdReservation());
            if (!revision.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    revision.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    revision.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    revision.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(revision.get());
                return revision.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Metodo que perite eliminar registros
     * @param idReservation parametro id
     * @return
     */
    public boolean deleteReservation(int idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Metodo que hace el conteo de clientes por reservacion
     * @return retorna los clientes
     */
    public  List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }

    /**
     * Metodo que cuenta la cantidad de estado de reservacion
     * @return retorna cantidad de reservaciones completadas y canceladas
     */
    public StatusReservation getStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        return new StatusReservation(completed.size(),cancelled.size());
    }

    /**
     * Metodo que obtiene  las reservacion entre un periodo y otro
     * @param date1 parametro de la fecha mas lejana
     * @param date2 parametro de la fecha mas cercana
     * @return listado de reservas dentro un periodo
     */
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