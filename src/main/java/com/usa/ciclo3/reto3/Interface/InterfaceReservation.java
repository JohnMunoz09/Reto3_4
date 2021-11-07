package com.usa.ciclo3.reto3.Interface;

import com.usa.ciclo3.reto3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface InterfaceReservation extends CrudRepository<Reservation, Integer> {

    @Query("SELECT r.client, COUNT(r.client) FROM Reservation  AS r GROUP BY r.client order by COUNT(r.client)DESC")
    public List<Reservation> findAllByStartDateAfterAndAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);

    public List<Object[]> countReservationByClient();

}
