package meteogaliza;

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
        final StringBuilder sb = new StringBuilder("Prediccion{");
        sb.append("concello=").append(concello);
        sb.append(", listaPredDiaConcello=").append(listaPredDiaConcello);
        sb.append('}');
        return sb.toString();
    }
}
