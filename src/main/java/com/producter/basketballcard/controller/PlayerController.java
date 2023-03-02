package com.producter.basketballcard.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import com.producter.basketballcard.service.IPlayerService;

import lombok.extern.slf4j.Slf4j;

import com.producter.basketballcard.model.Player;
import com.producter.basketballcard.model.Response.BaseResponseModel;
import com.producter.basketballcard.model.Response.ErrorResponseModel;
import com.producter.basketballcard.model.Response.SuccessResponseModel;
import com.producter.basketballcard.exception.PositionNotFoundException;
import com.producter.basketballcard.exception.TeamHasExceedException;
import com.producter.basketballcard.exception.PlayerNotFoundException;

@Controller
@Slf4j
public class PlayerController {
    
    @Autowired
    private IPlayerService playerService;
    
    @QueryMapping
    public Iterable<Player> findAllPlayers(){
        return playerService.findAllPlayers();
    }

    @MutationMapping
    public BaseResponseModel addPlayer(@Argument String name, @Argument String surname, @Argument Long position) throws PositionNotFoundException, TeamHasExceedException{
        Player player = null;
        try{
            player = this.playerService.addPlayer(name, surname, position);
        } catch(Exception e){
            log.error(null, e);
            return new ErrorResponseModel(e.getMessage());
        }
        return new SuccessResponseModel(new Player[] {player});
    }

    @MutationMapping
    public BaseResponseModel deletePlayer(@Argument Long id) throws PlayerNotFoundException {
        try{
            this.playerService.deletePlayer(id);
        } catch(Exception e){
            log.error(e.getLocalizedMessage());
            return new ErrorResponseModel(e.getMessage());
        }
        return new SuccessResponseModel(null);
    }
}
