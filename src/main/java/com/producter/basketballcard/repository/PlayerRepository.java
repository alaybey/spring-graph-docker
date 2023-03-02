package com.producter.basketballcard.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.producter.basketballcard.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>, BaseRepository {
    
    @Query("SELECT COUNT(p) FROM Player p")
    Long getCountPlayers();
}
