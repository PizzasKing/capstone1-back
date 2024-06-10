package com.manbo.homepage.service;

import com.manbo.homepage.dto.RoomsDTO;
import com.manbo.homepage.entity.Rooms;
import com.manbo.homepage.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    public RoomsDTO createRoom(RoomsDTO roomsDTO) {
        Rooms room = Rooms.toSaveEntity(roomsDTO);
        Rooms savedRoom = roomsRepository.save(room);
        return RoomsDTO.toSaveDTO(savedRoom);
    }

    public RoomsDTO updateRoom(RoomsDTO roomsDTO) {
        Rooms room = Rooms.toUpdateEntity(roomsDTO);
        Rooms updatedRoom = roomsRepository.save(room);
        return RoomsDTO.toSaveDTO(updatedRoom);
    }

    public RoomsDTO getRoomById(Long id) {
        Rooms room = roomsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return RoomsDTO.toSaveDTO(room);
    }

    public List<RoomsDTO> getAllRooms() {
        List<Rooms> roomsList = roomsRepository.findAll();
        return roomsList.stream().map(RoomsDTO::toSaveDTO).collect(Collectors.toList());
    }

    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }
}
