package com.usa.ciclo3.reto3.Repository;
import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.Interface.InterfaceCabin;
import com.usa.ciclo3.reto3.Model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author USUARIO
 */
@Repository
public class CabinRepository {

        @Autowired
        private InterfaceCabin interfaceCabin;

        public List<Cabin> getAllCabin(){
            return (List<Cabin>) interfaceCabin.findAll();
        }

        public Optional<Cabin> getCabin(int id){
            return interfaceCabin.findById(id);
        }

        public Cabin save(Cabin cabin){
            return interfaceCabin.save(cabin);
        }

        public void delete(Cabin cabin){
            interfaceCabin.delete(cabin);
        }

    }
