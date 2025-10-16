package com.santos.dslist.services;

import com.santos.dslist.dto.GameListDTO;
import com.santos.dslist.entities.GameList;
import com.santos.dslist.repositories.GameListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;


    @Transactional
    public List<GameListDTO> findAll () {
        List <GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
