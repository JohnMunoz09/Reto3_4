package com.usa.ciclo3.reto3.Services;

import com.usa.ciclo3.reto3.Model.Admin;
import com.usa.ciclo3.reto3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmin(){
        return adminRepository.getAllAdmin();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if (admin.getId()==null) {
            Optional<Admin> e=adminRepository.getAdmin(admin.getId());
            if (e.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        } else {
            return adminRepository.save(admin);
        }
    }

    public Admin update(Admin admin){
        if (admin.getId()!=null){
            Optional<Admin> e=adminRepository.getAdmin(admin.getId());
            if (!e.isEmpty()){
                if (admin.getName() != null){
                    e.get().setName(admin.getName());
                }
                if (admin.getEmail() != null){
                    e.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null){
                    e.get().setPassword(admin.getPassword());
                }
                adminRepository.save(e.get());
                return e.get();
        }else{
            return admin;
            }
        }else{
            return admin;
        }
    }


    public boolean deleteAdmin(int id){
        Boolean aBoolean = getAdmin(id).map(admin  ->{
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}