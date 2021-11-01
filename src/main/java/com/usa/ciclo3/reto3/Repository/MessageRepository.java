package com.usa.ciclo3.reto3.Repository;

import com.usa.ciclo3.reto3.Interface.InterfaceMessage;
import com.usa.ciclo3.reto3.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

        @Autowired
        private InterfaceMessage interfaceMessage;

        public List<Message> getAllMessage(){
            return (List<Message>) interfaceMessage.findAll();
        }

        public Optional<Message> getMessage(int id){
            return interfaceMessage.findById(id);
        }

        public Message save(Message message){
            return interfaceMessage.save(message);
        }

        public void delete(Message message){
            interfaceMessage.delete(message);
        }
}



