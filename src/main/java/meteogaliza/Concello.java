package meteogaliza;

import meteogaliza.enums.ConcelloId;
import meteogaliza.enums.EstadoUtils;

public class Concello {
    private int idConcello;
    private String nome;

    public Concello() {
    }

    public Concello(int idConcello) {
        this.idConcello = idConcello;
        this.nome = EstadoUtils.getNomePorCodigo(ConcelloId.values(), idConcello);
    }

    public int getIdConcello() {
        return idConcello;
    }

    public String getNome(){
        return nome;
    }

    public Concello setIdConcello(int idConcello) {
        this.idConcello = idConcello;
        this.nome = EstadoUtils.getNomePorCodigo(ConcelloId.values(), idConcello);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nome).append(", ").append(idConcello);
        return sb.toString();
    }
}