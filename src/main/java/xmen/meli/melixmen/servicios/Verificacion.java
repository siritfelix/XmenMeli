package xmen.meli.melixmen.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Verificacion implements IVerificacion {
    private String[] dna;
    private List<String> dnaList = new ArrayList<>();
    private Map<String, Boolean> letras = new HashMap<String, Boolean>();
    private Boolean esValido = true;
    private Integer contador;

    public Verificacion() {
        this.contador = 0;
        this.letras.put("AAAA", false);
        this.letras.put("TTTT", false);
        this.letras.put("CCCC", false);
        this.letras.put("GGGG", false);
    }

    @Override
    public Boolean EsMutante(String[] dna) {
        this.dna = dna;

        this.dnaList = Arrays.asList(dna);
        ListIterator<String> i = dnaList.listIterator();
        while (i.hasNext()) {
            i.set(i.next().toUpperCase());
        }
        if (this.esValido() == false)
            return false;
        BuscarSecuencia(this.dnaList);// Busqueda horizonal
        this.dnaList = diagonales(this.dna);
        BuscarSecuencia(this.dnaList); // Busqueda digonal principal
        this.dnaList = transponer(this.dna);
        BuscarSecuencia(this.dnaList);// Busqueda vertical
        String[] dnaAux = this.dnaList.toArray(new String[this.dnaList.size()]);
        this.dnaList = diagonales(dnaAux);
        BuscarSecuencia(dnaList);// Busqueda digonal invertida
        if (this.contador >= 2)
            return true;
        else
            return false;
    }

    public Boolean esValido() {
        Integer filas;
        filas = this.dnaList.size();
        this.dnaList.stream().forEach(dnastr -> {
            if (dnastr.length() != filas || dnastr.matches(".*[^ATCG].*"))
                this.esValido = false;
        });
        return this.esValido;
    }

    public Integer BuscarSecuencia(List<String> lista) {
        Integer contadorAux = 0;

        for (Map.Entry<String, Boolean> mapa : this.letras.entrySet()) {
            if (lista.stream().anyMatch(s -> s.contains(mapa.getKey()))) {

                if (mapa.getValue() == false) {
                    this.contador++;
                }
                this.letras.put(mapa.getKey(), true);
                contadorAux++;
            }
        }
        return contadorAux;
    }

    public List<String> transponer(String[] dna) {

        List<String> dnaTLista = new ArrayList<>();
        for (int i = 0; i < dna.length; i++) {
            StringBuffer aux = new StringBuffer();
            for (int j = dna.length - 1; j >= 0; j--) {
                aux.append(dna[j].charAt(i));
            }
            dnaTLista.add(aux.toString());

        }
        return dnaTLista;
    }

    public List<String> diagonales(String[] dna) {

        List<String> dnaTListaAux = new ArrayList<>();
        for (int i = 0; i < dna.length; i++) {
            StringBuffer aux = new StringBuffer();
            for (int j = 0; j < dna.length - i; j++) {
                aux.append(dna[j].charAt(i + j));
            }
            dnaTListaAux.add(aux.toString());
        }

        for (int i = 1; i < dna.length; i++) {
            StringBuffer aux = new StringBuffer();
            for (int j = 0; j < dna.length - i; j++) {
                aux.append(dna[i + j].charAt(j));
            }
            dnaTListaAux.add(aux.toString());
        }
        return dnaTListaAux;
    }

    public List<String> getDnaList() {
        return dnaList;
    }

    public void setDnaList(List<String> dnaList) {

        this.dnaList = dnaList;

    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

}