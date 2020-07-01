package xmen.meli.melixmen.persistencia.dao;

import org.springframework.data.repository.CrudRepository;

import xmen.meli.melixmen.persistencia.entidades.Humano;



public interface HumanoDao extends CrudRepository<Humano,Integer> {
    Integer countByMutante(Boolean True);
}