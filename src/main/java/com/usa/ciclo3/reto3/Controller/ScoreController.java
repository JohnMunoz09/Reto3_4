package com.usa.ciclo3.reto3.Controller;

import com.usa.ciclo3.reto3.Model.Score;
import com.usa.ciclo3.reto3.Services.ScoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Score")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreServices scoreServices;

    @GetMapping("/all")
    public List<Score> getScore(){
        return scoreServices.getAllScore();
    }

    @GetMapping("/{idScore}")
    public Optional<Score> getScore(@PathVariable("idScore") int id){
        return scoreServices.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return scoreServices.save(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return scoreServices.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return scoreServices.deleteScore(id);
    }
}
