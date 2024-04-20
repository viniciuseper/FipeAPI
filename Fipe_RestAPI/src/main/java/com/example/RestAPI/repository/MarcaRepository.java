package com.example.RestAPI.repository;

import com.example.RestAPI.model.MarcaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends MongoRepository<MarcaEntity, String>{
}
