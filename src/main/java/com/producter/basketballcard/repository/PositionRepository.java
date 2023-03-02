package com.producter.basketballcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.producter.basketballcard.model.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>, BaseRepository{
    
}
