package nl.ultimateapps.TechItEasy.controllers;

import nl.ultimateapps.TechItEasy.exceptions.RecordNotFoundException;
import nl.ultimateapps.TechItEasy.service.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Television> televisions = new ArrayList();

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getTelevisions () {
      if (televisions.size()>0) {
        // return new ResponseEntity<>(HttpStatus.OK); kan ook
        return ResponseEntity.ok(televisions);
      } else {
          throw new RecordNotFoundException("No televisions found");
      }
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevisions (@PathVariable int id) {
        if (id < televisions.size()) {
            Television television = televisions.get(id);
            //        return new ResponseEntity<>(HttpStatus.OK); kan ook
            return ResponseEntity.ok(television);
        } else {
            throw new RecordNotFoundException("Requested television not found");
        }
    }

    @PostMapping("/televisions")
    public ResponseEntity<String> postTelevision(@RequestBody Television television) {
        televisions.add(television);
        int id = televisions.indexOf(television);
        String s = "/televisions/" + id;
        URI uri = URI.create(s);
        return ResponseEntity.created(uri).body("Television created");
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<String> putTelevision(@PathVariable int id, @RequestBody Television television) {
        if (id < televisions.size()) {
            televisions.set(id, television);
            return ResponseEntity.ok("television changed");
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