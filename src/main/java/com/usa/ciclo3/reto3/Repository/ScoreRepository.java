package com.usa.ciclo3.reto3.Repository;

import com.usa.ciclo3.reto3.Interface.InterfaceScore;
import com.usa.ciclo3.reto3.Model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private InterfaceScore interfaceScore;

    public List<Score> getAllScore(){
        return (List<Score>) interfaceScore.findAll();
    }

    public Optional<Score> getScore(int id){
        return interfaceScore.findById(id);
    }

    public Score save(Score score){
        return interfaceScore.save(score);
    }

    public void delete(Score score){
        interfaceScore.delete(score);
    }
}
