package com.tarasenko.graphqlusers.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarasenko.graphqlusers.entity.Position;

public interface PositionRepository extends CrudRepository<Position, Long>
{
}
