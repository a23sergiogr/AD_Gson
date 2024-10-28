package meteogaliza;

import java.util.Date;

public class VariableFranxa {
    private VariableMeteoroloxica variableMeteoroloxica;
    private EstadoMeteoroloxico valorManha;
    private EstadoMeteoroloxico valorTarde;
    private EstadoMeteoroloxico valorNoche;

    public VariableFranxa() {
    }

    public VariableMeteoroloxica getVariableMeteoroloxica() {
        return variableMeteoroloxica;
    }

    public VariableFranxa setVariableMeteoroloxica(VariableMeteoroloxica variableMeteoroloxica) {
        this.variableMeteoroloxica = variableMeteoroloxica;
        return this;
    }

    public EstadoMeteoroloxico getValorManha() {
        return valorManha;
    }

    public VariableFranxa setValorManha(EstadoMeteoroloxico valorManha) {
        this.valorManha = valorManha;
        return this;
    }

    public EstadoMeteoroloxico getValorTarde() {
        return valorTarde;
    }

    public VariableFranxa setValorTarde(EstadoMeteoroloxico valorTarde) {
        this.valorTarde = valorTarde;
        return this;
    }

    public EstadoMeteoroloxico getValorNoche() {
        return valorNoche;
    }

    public VariableFranxa setValorNoche(EstadoMeteoroloxico valorNoche) {
        this.valorNoche = valorNoche;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VariableFranxa{");
        sb.append("variableMeteoroloxica=").append(variableMeteoroloxica);
        sb.append(", valorManha=").append(valorManha);
        sb.append(", valorTarde=").append(valorTarde);
        sb.append(", valorNoche=").append(valorNoche);
        sb.append('}');
        return sb.toString();
    }
}
