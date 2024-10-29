package meteogaliza;

import meteogaliza.enums.ConcelloId;
import meteogaliza.enums.EstadoCeo;
import meteogaliza.enums.EstadoUtils;

import java.util.ArrayList;
import java.util.List;

public class Prediccion {
    private Concello concello;
    private List<PrediccionDia> listaPredDiaConcello;

    public Prediccion() {
        listaPredDiaConcello = new ArrayList<>();
    }

    public Prediccion(Concello concello) {
        this.concello = concello;
        listaPredDiaConcello = new ArrayList<>();
    }

    public Concello getConcello() {
        return concello;
    }

    public Prediccion setConcello(Concello concello) {
        this.concello = concello;
        return this;
    }

    public Prediccion setConcello(int concello) {
        this.concello = new Concello(concello);
        return this;
    }

    public Prediccion setConcello(String concello) {
        this.concello = new Concello(EstadoUtils.getCodigoPorNome(ConcelloId.values(), concello));
        return this;
    }

    public List<PrediccionDia> getListaPredDiaConcello() {
        return listaPredDiaConcello;
    }

    public Prediccion addListaVariableFranxa(PrediccionDia prediccionDia){
        listaPredDiaConcello.add(prediccionDia);
        return this;
    }

    public Prediccion setListaPredDiaConcello(List<PrediccionDia> listaPredDiaConcello) {
        this.listaPredDiaConcello = listaPredDiaConcello;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(concello).append("\n");
        for (PrediccionDia prediccionDia : listaPredDiaConcello)
            sb.append(prediccionDia).append("\n");
        return sb.toString();
    }
}
