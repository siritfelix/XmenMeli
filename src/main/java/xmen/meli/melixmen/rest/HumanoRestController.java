package xmen.meli.melixmen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xmen.meli.melixmen.dto.EstadisticasDto;
import xmen.meli.melixmen.persistencia.entidades.Humano;
import xmen.meli.melixmen.servicios.IHumanoServ;


@RestController
@RequestMapping("/")
public class HumanoRestController {

    public static final String MUTANT = "mutant/";
    public static final String ESTADISTICAS = "/stats";
    @Autowired
    private IHumanoServ humanoSer;

    @PostMapping(value = MUTANT)
    public ResponseEntity<Humano> guardar(@RequestBody Humano humano) {
        Humano hum = humanoSer.guardar(humano);
        if (hum.getMutante())
            return new ResponseEntity<Humano>(hum, HttpStatus.OK);
        else
            return new ResponseEntity<Humano>(hum, HttpStatus.FORBIDDEN);

    }

    @GetMapping(value = ESTADISTICAS)
    public ResponseEntity<EstadisticasDto> Estadisticas() {
        EstadisticasDto estadisticas = humanoSer.estadisticas();
        return  new ResponseEntity<EstadisticasDto>(estadisticas, HttpStatus.OK);
    }
}