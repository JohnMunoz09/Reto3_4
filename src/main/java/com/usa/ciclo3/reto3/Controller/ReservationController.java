package com.usa.ciclo3.reto3.Controller;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.Custom.CountClient;
import com.usa.ciclo3.reto3.Custom.StatusReservation;
import com.usa.ciclo3.reto3.Model.Reservation;
import com.usa.ciclo3.reto3.Services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationServices reservationServices;
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationServices.getAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation) {
        return reservationServices.getReservation(idReservation);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationServices.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return
                reservationServices.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation) {
        return reservationServices.deleteReservation(idReservation);
    }

    @GetMapping("/report-status")
    public StatusReservation getReservationStatus(){
        return reservationServices.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return reservationServices.getTopClient();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationPeriod(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationServices.getReservationPeriod(dateOne,dateTwo);
    }
}

