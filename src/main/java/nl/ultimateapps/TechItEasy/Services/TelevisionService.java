package nl.ultimateapps.TechItEasy.Services;

import nl.ultimateapps.TechItEasy.Dtos.TelevisionDto;
import nl.ultimateapps.TechItEasy.Exceptions.RecordNotFoundException;
import nl.ultimateapps.TechItEasy.Models.Television;
import nl.ultimateapps.TechItEasy.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository repos;

    public ArrayList<TelevisionDto> getTelevisions() {
        Iterable<Television> allTelevisions = repos.findAll();
        ArrayList<TelevisionDto> resultList = new ArrayList<>();
        for (Television t : allTelevisions) {
            TelevisionDto newTelevisionDto = new TelevisionDto();

            newTelevisionDto.type = t.getType();
            newTelevisionDto.brand = t.getBrand();
            newTelevisionDto.name = t.getName();
            newTelevisionDto.price = t.getPrice();
            newTelevisionDto.availableSize = t.getAvailableSize();
            newTelevisionDto.refreshRate = t.getRefreshRate();
            newTelevisionDto.screenType = t.getScreenType();
            newTelevisionDto.screenQuality = t.getScreenQuality();
            newTelevisionDto.smartTv = t.getSmartTv();
            newTelevisionDto.wifi = t.getWifi();
            newTelevisionDto.voiceControl = t.getVoiceControl();
            newTelevisionDto.hdr = t.getHdr();
            newTelevisionDto.bluetooth = t.getBluetooth();
            newTelevisionDto.ambiLight = t.getAmbiLight();
            newTelevisionDto.originalStock = t.getOriginalStock();
            newTelevisionDto.sold = t.getSold();

            resultList.add(newTelevisionDto);
        }
        return resultList;
    }

    public TelevisionDto getTelevision(long id) {
        if (repos.findById(id).isPresent()) {
            Television t = repos.findById(id).get();
            TelevisionDto televisionDto = new TelevisionDto();

            televisionDto.type = t.getType();
            televisionDto.brand = t.getBrand();
            televisionDto.name = t.getName();
            televisionDto.price = t.getPrice();
            televisionDto.availableSize = t.getAvailableSize();
            televisionDto.refreshRate = t.getRefreshRate();
            televisionDto.screenType = t.getScreenType();
            televisionDto.screenQuality = t.getScreenQuality();
            televisionDto.smartTv = t.getSmartTv();
            televisionDto.wifi = t.getWifi();
            televisionDto.voiceControl = t.getVoiceControl();
            televisionDto.hdr = t.getHdr();
            televisionDto.bluetooth = t.getBluetooth();
            televisionDto.ambiLight = t.getAmbiLight();
            televisionDto.originalStock = t.getOriginalStock();
            televisionDto.sold = t.getSold();

            return televisionDto;
        } else {
            throw new RecordNotFoundException();
        }
    }

    public long createTelevision(TelevisionDto televisionDto) {
        Television television = new Television();

        // map dto to entity
        television.setType(televisionDto.type);
        television.setBrand(televisionDto.brand);
        television.setName(televisionDto.name);
        television.setPrice(televisionDto.price);
        television.setAvailableSize(televisionDto.availableSize);
        television.setRefreshRate(televisionDto.refreshRate);
        television.setScreenType(televisionDto.screenType);
        television.setScreenQuality(televisionDto.screenQuality);
        television.setSmartTv(televisionDto.smartTv);
        television.setWifi(televisionDto.wifi);
        television.setVoiceControl(televisionDto.voiceControl);
        television.setHdr(televisionDto.hdr);
        television.setBluetooth(televisionDto.bluetooth);
        television.setAmbiLight(televisionDto.ambiLight);
        television.setOriginalStock(televisionDto.originalStock);
        television.setSold(televisionDto.sold);

        Television savedTelevision = repos.save(television);
        return savedTelevision.getId();
    }

    public long updateTelevision(long id, TelevisionDto televisionDto) {
        if (repos.findById(id).isPresent()) {
            Television television = repos.findById(id).get();

            television.setType(televisionDto.type);
            television.setBrand(televisionDto.brand);
            television.setName(televisionDto.name);
            television.setPrice(televisionDto.price);
            television.setAvailableSize(televisionDto.availableSize);
            television.setRefreshRate(televisionDto.refreshRate);
            television.setScreenType(televisionDto.screenType);
            television.setScreenQuality(televisionDto.screenQuality);
            television.setSmartTv(televisionDto.smartTv);
            television.setWifi(televisionDto.wifi);
            television.setVoiceControl(televisionDto.voiceControl);
            television.setHdr(televisionDto.hdr);
            television.setBluetooth(televisionDto.bluetooth);
            television.setAmbiLight(televisionDto.ambiLight);
            television.setOriginalStock(televisionDto.originalStock);
            television.setSold(televisionDto.sold);

            repos.save(television);
            return television.getId();

        } else {
            throw new RecordNotFoundException();
        }
    }

    public long partialUpdateTelevision(long id, TelevisionDto televisionDto) {
        if (repos.findById(id).isPresent()) {
            Television television = repos.findById(id).get();

            if (television.getType() != null) {
                television.setType(televisionDto.type);
            }

            repos.save(television);
            return television.getId();
        } else {
            throw new RecordNotFoundException();
        }
    }

    public long deleteTelevision(long id) {
        if (repos.findById(id).isPresent()) {
            Television television = repos.findById(id).get();
            long retrievedId = television.getId();
            repos.deleteById(id);
            return retrievedId;
        } else {
            throw new RecordNotFoundException();
        }
    }

    public Iterable<TelevisionDto> getTelevisionContaining(String query) {
        Iterable<Television> foundTelevisions = repos.findByBrandContaining(query);
        ArrayList<TelevisionDto> resultList = new ArrayList<>();
        for (Television t : foundTelevisions) {
            TelevisionDto newTelevisionDto = new TelevisionDto();

            newTelevisionDto.type = t.getType();
            newTelevisionDto.brand = t.getBrand();
            newTelevisionDto.name = t.getName();
            newTelevisionDto.price = t.getPrice();
            newTelevisionDto.availableSize = t.getAvailableSize();
            newTelevisionDto.refreshRate = t.getRefreshRate();
            newTelevisionDto.screenType = t.getScreenType();
            newTelevisionDto.screenQuality = t.getScreenQuality();
            newTelevisionDto.smartTv = t.getSmartTv();
            newTelevisionDto.wifi = t.getWifi();
            newTelevisionDto.voiceControl = t.getVoiceControl();
            newTelevisionDto.hdr = t.getHdr();
            newTelevisionDto.bluetooth = t.getBluetooth();
            newTelevisionDto.ambiLight = t.getAmbiLight();
            newTelevisionDto.originalStock = t.getOriginalStock();
            newTelevisionDto.sold = t.getSold();

            resultList.add(newTelevisionDto);
        }
        return resultList;
    }
}
