package meteogaliza;

public class Concello {
    private int idConcello;
    private String nome;

    public Concello() {
    }

    public Concello(int idConcello) {
        this.idConcello = idConcello;
    }

    public int getIdConcello() {
        return idConcello;
    }

    public Concello setIdConcello(int idConcello) {
        this.idConcello = idConcello;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Concello{");
        sb.append("idConcello=").append(idConcello);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}