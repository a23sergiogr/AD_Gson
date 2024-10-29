package meteogaliza.enums;

public enum EstadoVento implements EstadoUtils{
    NON_DISPONIBLE(-9999, "Non dispoñible"),
    CALMA(299, "Calma"),
    VENTO_VARIABLE(300, "Vento variable"),
    VENTO_FROUXO_NORTE(301, "Vento frouxo do Norte (N)"),
    VENTO_FROUXO_NORDES(302, "Vento frouxo do Nordés (NE)"),
    VENTO_FROUXO_LESTE(303, "Vento frouxo do Leste (E)"),
    VENTO_FROUXO_SUESTE(304, "Vento frouxo do Sueste (SE)"),
    VENTO_FROUXO_SUR(305, "Vento frouxo do Sur (S)"),
    VENTO_FROUXO_SUDOESTE(306, "Vento frouxo do Sudoeste (SO)"),
    VENTO_FROUXO_OESTE(307, "Vento frouxo do Oeste (O)"),
    VENTO_FROUXO_NOROESTE(308, "Vento frouxo do Noroeste (NO)"),
    VENTO_MODERADO_NORTE(309, "Vento moderado do Norte (N)"),
    VENTO_MODERADO_NORDES(310, "Vento moderado do Nordés (NE)"),
    VENTO_MODERADO_LESTE(311, "Vento moderado do Leste (E)"),
    VENTO_MODERADO_SUESTE(312, "Vento moderado do Sueste (SE)"),
    VENTO_MODERADO_SUR(313, "Vento moderado do Sur (S)"),
    VENTO_MODERADO_SUDOESTE(314, "Vento moderado do Sudoeste (SO)"),
    VENTO_MODERADO_OESTE(315, "Vento moderado do Oeste (O)"),
    VENTO_MODERADO_NOROESTE(316, "Vento moderado do Noroeste (NO)"),
    VENTO_FORTE_NORTE(317, "Vento forte do Norte (N)"),
    VENTO_FORTE_NORDES(318, "Vento forte do Nordés (NE)"),
    VENTO_FORTE_LESTE(319, "Vento forte do Leste (E)"),
    VENTO_FORTE_SUESTE(320, "Vento forte do Sueste (SE)"),
    VENTO_FORTE_SUR(321, "Vento forte do Sur (S)"),
    VENTO_FORTE_SUDOESTE(322, "Vento forte do Sudoeste (SO)"),
    VENTO_FORTE_OESTE(323, "Vento forte do Oeste (O)"),
    VENTO_FORTE_NOROESTE(324, "Vento forte do Noroeste (NO)"),
    VENTO_MOI_FORTE_NORTE(325, "Vento moi forte do Norte (N)"),
    VENTO_MOI_FORTE_NORDES(326, "Vento moi forte do Nordés (NE)"),
    VENTO_MOI_FORTE_LESTE(327, "Vento moi forte do Leste (E)"),
    VENTO_MOI_FORTE_SUESTE(328, "Vento moi forte do Sueste (SE)"),
    VENTO_MOI_FORTE_SUR(329, "Vento moi forte do Sur (S)"),
    VENTO_MOI_FORTE_SUDOESTE(330, "Vento moi forte do Sudoeste (SO)"),
    VENTO_MOI_FORTE_OESTE(331, "Vento moi forte do Oeste (O)"),
    VENTO_MOI_FORTE_NOROESTE(332, "Vento moi forte do Noroeste (NO)");

    private final int codigo;
    private final String nome;

    EstadoVento(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getIntensidadeVento() {
        if (this == CALMA) {
            return "≤ 5 Km/h";
        } else if (this == VENTO_VARIABLE) {
            return "vento feble de intensidade variable";
        } else if (this.nome.contains("frouxo")) {
            return ">5 e ≤ 20 Km/h";
        } else if (this.nome.contains("moderado")) {
            return ">20 e ≤ 40 Km/h";
        } else if (this.nome.contains("forte")) {
            return ">40 e ≤ 70 Km/h";
        } else if (this.nome.contains("moi forte")) {
            return "> 70 Km/h";
        } else {
            return "Intensidade descoñecida";
        }
    }
}
