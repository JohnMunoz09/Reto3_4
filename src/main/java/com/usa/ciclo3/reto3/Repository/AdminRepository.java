package com.usa.ciclo3.reto3.Repository;

import com.usa.ciclo3.reto3.Interface.InterfaceAdmin;
import com.usa.ciclo3.reto3.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private InterfaceAdmin interfaceAdmin;

    public List<Admin> getAllAdmin(){
        return (List<Admin>) interfaceAdmin.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return interfaceAdmin.findById(id);
    }

    public Admin save(Admin admin){
        return interfaceAdmin.save(admin);
    }

    public void delete(Admin admin){
        interfaceAdmin.delete(admin);
    }
}
