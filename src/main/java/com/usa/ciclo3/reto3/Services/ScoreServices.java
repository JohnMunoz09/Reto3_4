package com.usa.ciclo3.reto3.Services;

import com.usa.ciclo3.reto3.Interface.InterfaceScore;
import com.usa.ciclo3.reto3.Model.Score;
import com.usa.ciclo3.reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServices {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScore(){
        return scoreRepository.getAllScore();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if (score.getId()==null){
            return scoreRepository.save(score);
        }else {
            Optional<Score> e = scoreRepository.getScore(score.getId());
            if (e.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score){
        if (score.getId()!=null){
            Optional<Score> e=scoreRepository.getScore(score.getId());
            if (!e.isEmpty()){
                if (score.getMessageText()!=null){
                    e.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null){
                    e.get().setStars(score.getStars());
                }
                if (score.getReservation() != null){
                    e.get().setReservation(score.getReservation());
                }
                scoreRepository.save(e.get());
                return e.get();
            }else{
                return score;
            }
        }else {
            return score;
        }
    }

    public boolean deleteScore(int id){
        Boolean aBoolean = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
