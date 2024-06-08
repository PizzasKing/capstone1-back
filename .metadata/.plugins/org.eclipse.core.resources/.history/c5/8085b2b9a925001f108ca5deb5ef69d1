package com.manbo.homepage.service;

import com.manbo.homepage.dto.RoomsDTO;
import com.manbo.homepage.entity.Rooms;
import com.manbo.homepage.repository.RoomsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomsService {
    private final RoomsRepository roomsRepository;

    public void save(RoomsDTO roomsDTO) {
        Rooms room = Rooms.builder()
                .title(roomsDTO.getTitle())
                .description(roomsDTO.getDescription())
                .maxMembers(roomsDTO.getMaxMembers())
                .meetingTime(roomsDTO.getMeetingTime())
                .status(roomsDTO.getStatus())
                .build();
        roomsRepository.save(room);
    }

    public List<RoomsDTO> findAll() {
        return roomsRepository.findAll().stream()
                .map(RoomsDTO::toDTO)
                .collect(Collectors.toList());
    }

    public RoomsDTO findById(Long id) {
        return roomsRepository.findById(id)
                .map(RoomsDTO::toDTO)
                .orElse(null);
    }

    public void deleteById(Long id) {
        roomsRepository.deleteById(id);
    }
}
