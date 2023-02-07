package com.ssafy.plant.service;

import com.ssafy.plant.domain.PotEntity;
import com.ssafy.plant.dto.PotDTO;
import com.ssafy.plant.repository.PotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PotService {

    @Autowired
    PotRepository potRepository;

    public String setPot(PotDTO potDTO){
        Optional<PotEntity> pot = potRepository.findById(potDTO.getPotId());

        if (pot.isPresent()) {
            return "presented";
        } else {
            PotEntity potEntity = potDTO.dtoToEntity();
            potRepository.save(potEntity);
            return "created";
        }
    }
}