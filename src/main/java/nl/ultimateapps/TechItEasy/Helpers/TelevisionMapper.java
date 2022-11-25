package nl.ultimateapps.TechItEasy.Helpers;

import nl.ultimateapps.TechItEasy.Dtos.TelevisionDto;
import nl.ultimateapps.TechItEasy.Models.Television;

public class TelevisionMapper {

    public static Television mapToModel(TelevisionDto televisionDto) {
        Television television = new Television();

        television.setType(televisionDto.getType());
        television.setBrand(televisionDto.getBrand());
        television.setName(televisionDto.getBrand());
        television.setPrice(televisionDto.getPrice());
        television.setAvailableSize(televisionDto.getAvailableSize());
        television.setRefreshRate(televisionDto.getRefreshRate());
        television.setScreenType(televisionDto.getScreenType());
        television.setScreenQuality(televisionDto.getScreenQuality());
        television.setSmartTv(televisionDto.getSmartTv());
        television.setWifi(televisionDto.getWifi());
        television.setVoiceControl(televisionDto.getVoiceControl());
        television.setHdr(televisionDto.getHdr());
        television.setBluetooth(televisionDto.getBluetooth());
        television.setAmbiLight(televisionDto.getAmbiLight());
        television.setOriginalStock(televisionDto.getOriginalStock());
        television.setSold(televisionDto.getSold());

        return television;
    }

    public static TelevisionDto mapToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }
}
