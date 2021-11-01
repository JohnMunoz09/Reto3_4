package com.usa.ciclo3.reto3.Controller;

import com.usa.ciclo3.reto3.Model.Admin;
import com.usa.ciclo3.reto3.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @GetMapping("/all")
    public List<Admin> getAdmin(){
        return adminServices.getAllAdmin();
    }

    @GetMapping("/{idAdmin}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminServices.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return adminServices.save(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return adminServices.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  boolean delete(@PathVariable("id") int id){
        return adminServices.deleteAdmin(id);
    }
}
