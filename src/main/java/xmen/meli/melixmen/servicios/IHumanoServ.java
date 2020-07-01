package xmen.meli.melixmen.servicios;

import xmen.meli.melixmen.dto.EstadisticasDto;
import xmen.meli.melixmen.persistencia.entidades.Humano;

public interface IHumanoServ {
    public Humano guardar(Humano humano);
    public EstadisticasDto estadisticas();
}