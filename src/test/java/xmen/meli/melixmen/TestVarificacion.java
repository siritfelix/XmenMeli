package xmen.meli.melixmen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import xmen.meli.melixmen.servicios.Verificacion;

public class TestVarificacion {

    private Verificacion verificacion;

    @Test
    void VerificarMutante() {
        String[] dna = { "AACCCC", "AAGTGC", "TTATGT", "AGAAAA", "AAAATA", "TCACTG" };
        verificacion = new Verificacion();
        assertEquals(true, verificacion.EsMutante(dna));

    }

    @Test
    void VerificarMutante2() {
        String[] dna = { "ACCT", "CATC", "CTAC", "TCCA" };
        verificacion = new Verificacion();
        assertEquals(true, verificacion.EsMutante(dna));

    }

    @Test
    void VerificarNoMutante() {
        String[] dna = { "cccccc", "acacac", "cacaca", "tgtgtg", "tatata", "ccacca" };
        verificacion = new Verificacion();
        assertEquals(false, verificacion.EsMutante(dna));

    }

    @Test
    void VerificarMayuculas() {
        List<String> dnaList = new ArrayList<>();
        String[] dna = { "cccccc", "acacac" };
        dnaList.add(dna[0].toUpperCase());
        dnaList.add(dna[1].toUpperCase());
        verificacion = new Verificacion();
        verificacion.EsMutante(dna);
        assertEquals(dnaList, verificacion.getDnaList());

    }

    @Test
    void VerificarBuscarSecuencia() {
        List<String> dnaList = new ArrayList<>();
        String[] dna = { "AACCCC", "AAGTGC", "TTATGT", "AGAAAA", "AAAATA", "TCACTG" };
        dnaList = Arrays.asList(dna);
        verificacion = new Verificacion();
        assertEquals(2, verificacion.BuscarSecuencia(dnaList));

    }

    @Test
    void VerificarTraspuesta() {
        String[] dna = { "ABCDEF", "GHIJKL", "MNOPQR", "STUVWX", "YZ1234", "567890" };
        String[] dnaT = { "5YSMGA", "6ZTNHB", "71UOIC", "82VPJD", "93WQKE", "04XRLF" };
        List<String> dnaList = Arrays.asList(dnaT);
        verificacion = new Verificacion();
        assertEquals(dnaList, verificacion.transponer(dna));

    }

    @Test
    void VerificarContador() {
        String[] dna = { "AAAAC", "AAAAC", "AAAAC", "AAAAC", "AAAAC" };
        verificacion = new Verificacion();
        verificacion.EsMutante(dna);
        assertEquals(2, verificacion.getContador());

    }

    @Test
    void VerificarDigonales() {
        String[] dna = { "ABCD", "EFGH", "IJKL", "MNOP" };
        String[] dnaD = { "AFKP", "BGL", "CH", "D", "EJO", "IN", "M" };
        List<String> dnaList = Arrays.asList(dnaD);
        verificacion = new Verificacion();
        verificacion.setDna(dna);
        assertEquals(dnaList, verificacion.diagonales(dna));

    }

}