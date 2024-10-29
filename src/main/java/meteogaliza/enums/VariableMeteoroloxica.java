package meteogaliza.enums;

public enum VariableMeteoroloxica {
    CIELO, LLUVIA, TEMPERATURA_MAXIMA, TEMPERATURA_MINIMA, VIENTO;

    private String variableMeteoroloxica;
    VariableMeteoroloxica(){
        this.variableMeteoroloxica = this.name().toLowerCase();
    }

    public String getNome() {
        return variableMeteoroloxica;
    }
}
