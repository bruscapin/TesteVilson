package com.aulas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Gato;

@Repository
public interface GatoRepository extends CrudRepository<Gato,Long> {

}
