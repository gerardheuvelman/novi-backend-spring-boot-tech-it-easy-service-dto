package nl.ultimateapps.TechItEasy.Controllers;

import nl.ultimateapps.TechItEasy.Exceptions.RecordNotFoundException;
import nl.ultimateapps.TechItEasy.Models.Television;
import nl.ultimateapps.TechItEasy.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @Autowired
    private TelevisionRepository repos;

    @GetMapping("")
    public ResponseEntity<Iterable<Television>> getTelevisions() {
        List<Television> televisions = repos.findAll();
        if (televisions.size()>0) {
            return ResponseEntity.ok(televisions);
        } else {
            throw new RecordNotFoundException("No televisions found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisions (@PathVariable int id) {
        Optional<Television> televisionOption= repos.findById((long)id);
        if (televisionOption.isPresent()) {
            Television television = televisionOption.get();
            return ResponseEntity.ok(television);
        } else {
            throw new RecordNotFoundException("Requested television was not found");
        }
    }


    @PostMapping("")
    public ResponseEntity<String> postTelevision(@RequestBody Television television) {
        Television savedTelevision = repos.save(television);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/televisions/" + savedTelevision.getId()).toUriString());
        return ResponseEntity.created(uri).body("Television created!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> putTelevision(@PathVariable int id, @RequestBody Television television) {
        Optional<Television> opt = repos.findById((long)id);
        if (opt.isPresent()) {
            Television replaceTelevision = repos.getReferenceById((long)id);
            replaceTelevision.setType(television.getType());
            replaceTelevision.setName(television.getName());
            replaceTelevision.setBrand(television.getBrand());
            replaceTelevision.setPrice(television.getPrice());
            replaceTelevision.setAvailableSize(television.getAvailableSize());
            replaceTelevision.setRefreshRate(television.getRefreshRate());
            replaceTelevision.setScreenType(television.getScreenType());
            replaceTelevision.setScreenQuality(television.getScreenQuality());
            replaceTelevision.setSmartTv(television.getSmartTv());
            replaceTelevision.setWifi(television.getWifi());
            replaceTelevision.setVoiceControl(television.getVoiceControl());
            replaceTelevision.setHdr(television.getHdr());
            replaceTelevision.setBluetooth(television.getBluetooth());
            replaceTelevision.setAmbiLight(television.getAmbiLight());
            replaceTelevision.setOriginalStock(television.getOriginalStock());
            replaceTelevision.setSold(television.getSold());

            repos.save(replaceTelevision);

            return ResponseEntity.ok(television);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Television> patchTelevision(@PathVariable int id, @RequestBody Television television) {
        Optional<Television> opt = repos.findById((long)id);
        if (opt.isPresent()) {
            Television editTelevision = repos.getReferenceById((long)id);
            if (television.getType() != null) {
                editTelevision.setType(television.getType());
            }

//            editTelevision.setType(television.getType());
//            editTelevision.setBrand(television.getBrand());
//            editTelevision.setName(television.getName());
//            editTelevision.setPrice(television.getPrice());
//            editTelevision.setAvailableSize(television.getAvailableSize());
//            editTelevision.setRefreshRate(television.getRefreshRate());
//            editTelevision.setScreenType(television.getScreenType());
//            editTelevision.setScreenQuality(television.getScreenQuality());
//            editTelevision.setSmartTv(television.getSmartTv());
//            editTelevision.setWifi(television.getWifi());
//            editTelevision.setVoiceControl(television.getVoiceControl());
//            editTelevision.setHdr(television.getHdr());
//            editTelevision.setBluetooth(television.getBluetooth());
//            editTelevision.setAmbiLight(television.getAmbiLight());
//            editTelevision.setOriginalStock(television.getOriginalStock());
//            editTelevision.setSold(television.getSold());

            repos.save(editTelevision);

            return ResponseEntity.ok(editTelevision);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable long id) {
        if (repos.existsById(id)) {
           repos.deleteById(id);
            return ResponseEntity.ok("Television deleted successfully");
        } else {
            throw new RecordNotFoundException();
        }
    }
}
