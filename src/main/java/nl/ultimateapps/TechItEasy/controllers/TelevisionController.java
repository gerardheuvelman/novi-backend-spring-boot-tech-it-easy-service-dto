package nl.ultimateapps.TechItEasy.controllers;

import nl.ultimateapps.TechItEasy.exceptions.RecordNotFoundException;
import nl.ultimateapps.TechItEasy.service.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Television> televisions = new ArrayList();

    @GetMapping("/televisions")
    public ResponseEntity<String> getTelevisions () {
//        return new ResponseEntity<>(HttpStatus.OK); kan ook
        return ResponseEntity.ok("My televisions");
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<String> getTelevisions (@PathVariable int id) {
        if (id<10) {
            //        return new ResponseEntity<>(HttpStatus.OK); kan ook
            return ResponseEntity.ok("television " + id);
        } else {
            throw new RecordNotFoundException("id not found");
        }
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> postTelevision(@RequestBody Television television) {
        televisions.add(television);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> putTelevision(@PathVariable int id, @RequestBody Television t) {
        if (id < televisions.size()) {
            televisions.set(id, t);
            return ResponseEntity.ok("Item changed");
        } else {
            throw new RecordNotFoundException();
        }
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        if (id < televisions.size()) {
            televisions.remove(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            throw new RecordNotFoundException();
        }
    }
}