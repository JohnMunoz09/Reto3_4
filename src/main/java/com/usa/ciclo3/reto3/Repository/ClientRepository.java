package com.usa.ciclo3.reto3.Repository;

import com.usa.ciclo3.reto3.Interface.InterfaceClient;
import com.usa.ciclo3.reto3.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private InterfaceClient interfaceClient;

    public List<Client> getAll(){

        return (List<Client>) interfaceClient.findAll();
    }
    public Optional <Client> getClient(int idClient){

        return interfaceClient.findById(idClient);
    }
    public Client save (Client client){

        return interfaceClient.save(client);
    }
    public void delete(Client client){

        interfaceClient.delete (client);
    }
}
