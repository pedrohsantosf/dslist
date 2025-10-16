package com.santos.dslist.services;

import com.santos.dslist.dto.GameDTO;
import com.santos.dslist.dto.GameMinDTO;
import com.santos.dslist.entities.Game;
import com.santos.dslist.projections.GameMinProjection;
import com.santos.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional
    public List<GameMinDTO> findAll () {
        List <Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional
    public List<GameMinDTO> findByList (Long listId) {
        List <GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
