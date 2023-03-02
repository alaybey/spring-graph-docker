package com.producter.basketballcard.service;

import com.producter.basketballcard.model.Player;
import com.producter.basketballcard.exception.PositionNotFoundException;
import com.producter.basketballcard.exception.TeamHasExceedException;
import com.producter.basketballcard.exception.PlayerNotFoundException;

public interface IPlayerService {
    Iterable<Player> findAllPlayers();
    Player addPlayer(String name, String surname, Long id) throws PositionNotFoundException, TeamHasExceedException;
    Boolean deletePlayer(Long id) throws PlayerNotFoundException;
}
