package com.producter.basketballcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.producter.basketballcard.repository.PlayerRepository;
import com.producter.basketballcard.repository.PositionRepository;

import lombok.extern.slf4j.Slf4j;

import com.producter.basketballcard.model.Player;
import com.producter.basketballcard.model.Position;
import com.producter.basketballcard.exception.PositionNotFoundException;
import com.producter.basketballcard.exception.TeamHasExceedException;
import com.producter.basketballcard.exception.PlayerNotFoundException;

@Service
@Slf4j
public class PlayerService implements IPlayerService{
    
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PositionRepository positionRepository;

    @Value("${rule.basketball.maxPlayer}")
    Integer maxPlayerNumber;

    public Iterable<Player> findAllPlayers(){
        Iterable<Player> players = this.playerRepository.findAll();
        return players;
    }

    private Integer getCountPlayersOfTeam(){
        Integer countPlayers = this.playerRepository.getCountPlayers().intValue();
        return countPlayers;
    }

    public Player addPlayer(String name, String surname, Long id) throws PositionNotFoundException, TeamHasExceedException{
        if(this.getCountPlayersOfTeam() == this.maxPlayerNumber){
            log.error("Error when add player: The team already has maximum player");
            throw new TeamHasExceedException();
        }
        Optional<Position> position = this.positionRepository.findById(id);
        if(position.isEmpty() || !position.isPresent()){
            log.error("Error when add player: The specified position does not exist");
            throw new PositionNotFoundException();
        }
        Player player = new Player(name, surname, position.get());
        player = this.playerRepository.save(player);
        log.info("Player added as successful: {}", player);
        return player;
    }

    public Boolean deletePlayer(Long id) throws PlayerNotFoundException{
        if(this.getCountPlayersOfTeam() == 0){
            log.error("Error when delete player: The specified player does not exist");
            throw new PlayerNotFoundException();
        }
        Player player = this.playerRepository.findById(id).orElseThrow(PlayerNotFoundException::new);
        this.playerRepository.delete(player);
        log.info("Player deleted as successful: {}", player);
        return true;
    }
}
