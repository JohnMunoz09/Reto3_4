package com.usa.ciclo3.reto3.Controller;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.Model.Cabin;
import com.usa.ciclo3.reto3.Services.CabinServices;
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

@RestController
@RequestMapping("api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class CabinController {

    @Autowired
    private CabinServices cabinServices;

    @GetMapping("/all")
    public List<Cabin> getCabin(){
        return cabinServices.getAllCabin();
    }

    @GetMapping("/{idCabin}")
    public Optional<Cabin> getCabin (@PathVariable("idCabin") int idCabin) {
        return cabinServices.getCabin(idCabin);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {

        return cabinServices.save(cabin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return cabinServices.update(cabin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cabinServices.deleteCabin(id);
    }

}
