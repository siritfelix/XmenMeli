package xmen.meli.melixmen.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmen.meli.melixmen.dto.EstadisticasDto;
import xmen.meli.melixmen.persistencia.dao.HumanoDao;
import xmen.meli.melixmen.persistencia.entidades.Humano;



@Service
public class HumanoServImpl implements IHumanoServ {
    @Autowired
    private HumanoDao humanoDao;
    @Autowired
    private IVerificacion verificacionServ;

    @Override
    @Transactional
    public Humano guardar(Humano humano) {

        if (verificacionServ.EsMutante(humano.getDna())) {
            humano.setMutante(true);
        } else
            humano.setMutante(false);
        humanoDao.save(humano);
        return humano;
    }

    @Override
    @Transactional
    public EstadisticasDto estadisticas() {
        Integer mutantes = humanoDao.countByMutante(true);
        Integer humano = (int) humanoDao.count();
        return new EstadisticasDto(mutantes, humano);
    }

}