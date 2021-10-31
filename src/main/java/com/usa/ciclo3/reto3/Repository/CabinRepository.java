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
        private InterfaceCabin cabinCrudRepository;

        public List<Cabin> getAllCabin(){
            return (List<Cabin>) cabinCrudRepository.findAll();
        }

        public Optional<Cabin> getCabin(int id){

            return cabinCrudRepository.findById(id);
        }

        public Cabin save(Cabin cabin){

            return cabinCrudRepository.save(cabin);
        }
        public void delete(Cabin cabin){

            cabinCrudRepository.delete(cabin);
        }

    }
