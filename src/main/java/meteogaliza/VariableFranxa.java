package meteogaliza;

import meteogaliza.enums.EstadoUtils;
import meteogaliza.enums.VariableMeteoroloxica;

public class VariableFranxa {
    private VariableMeteoroloxica variableMeteoroloxica;
    private EstadoUtils valorManha;
    private EstadoUtils valorTarde;
    private EstadoUtils valorNoche;

    public VariableFranxa() {
    }

    public VariableMeteoroloxica getVariableMeteoroloxica() {
        return variableMeteoroloxica;
    }

    public VariableFranxa setVariableMeteoroloxica(VariableMeteoroloxica variableMeteoroloxica) {
        this.variableMeteoroloxica = variableMeteoroloxica;
        return this;
    }

    public EstadoUtils getValorManha() {
        return valorManha;
    }

    public VariableFranxa setValorManha(EstadoUtils valorManha) {
        this.valorManha = valorManha;
        return this;
    }

    public EstadoUtils getValorTarde() {
        return valorTarde;
    }

    public VariableFranxa setValorTarde(EstadoUtils valorTarde) {
        this.valorTarde = valorTarde;
        return this;
    }

    public EstadoUtils getValorNoche() {
        return valorNoche;
    }

    public VariableFranxa setValorNoche(EstadoUtils valorNoche) {
        this.valorNoche = valorNoche;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\tVariable Meteoroloxica: ").append(variableMeteoroloxica.getNome()).append("\n");
        sb.append("\t\tManha: ").append(valorManha.getNome()).append("\n");
        sb.append("\t\tTarde: ").append(valorTarde.getNome()).append("\n");
        sb.append("\t\tNoite: ").append(valorNoche.getNome()).append("\n");
        return sb.toString();
    }
}
