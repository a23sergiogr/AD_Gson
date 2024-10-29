package meteogaliza.enums;

public enum EstadoCeo implements EstadoUtils {
    NON_DISPONHIBLE(-9999, "Non dispoñible"),
    DESPEXADO(101, "Despexado"),
    NUBES_ALTAS(102, "Nubes altas"),
    NUBES_E_CLAROS(103, "Nubes e claros"),
    ANUBRADO_75(104, "Anubrado 75%"),
    CUBERTO(105, "Cuberto"),
    NEBOAS(106, "Néboas"),
    CHUVASCO(107, "Chuvasco"),
    CHUVASCO_75(108, "Chuvasco (75%)"),
    CHUVASCO_NEVE(109, "Chuvasco neve"),
    ORBALLO(110, "Orballo"),
    CHOIVA(111, "Choiva"),
    NEVE(112, "Neve"),
    TREBOADA(113, "Treboada"),
    BRE_TEMA(114, "Brétema"),
    BANCOS_DE_NEBOA(115, "Bancos de néboa"),
    NUBES_MEDIAS(116, "Nubes medias"),
    CHOIVA_DEBIL(117, "Choiva débil"),
    CHUVASCOS_DEBILES(118, "Chuvascos débiles"),
    TREBOADA_POUCAS_NUBES(119, "Treboada con poucas nubes"),
    AUGA_NEVE(120, "Auga neve"),
    SARABIA(121, "Sarabia"),
    NOITE_DESPEXADO(201, "Despexado noite"),
    NOITE_NUBES_ALTAS(202, "Nubes altas noite"),
    NOITE_NUBES_E_CLAROS(203, "Nubes e claros noite"),
    NOITE_ANUBRADO_75(204, "Anubrado 75% noite"),
    NOITE_CUBERTO(205, "Cuberto noite"),
    NOITE_NEBOAS(206, "Néboas noite"),
    NOITE_CHUVASCO(207, "Chuvasco noite"),
    NOITE_CHUVASCO_75(208, "Chuvasco (75%) noite"),
    NOITE_CHUVASCO_NEVE(209, "Chuvasco neve noite"),
    NOITE_ORBALLO(210, "Orballo noite"),
    NOITE_CHOIVA(211, "Choiva noite"),
    NOITE_NEVE(212, "Neve noite"),
    NOITE_TREBOADA(213, "Treboada noite"),
    NOITE_BRE_TEMA(214, "Brétema noite"),
    NOITE_BANCOS_DE_NEBOA(215, "Bancos de néboa noite"),
    NOITE_NUBES_MEDIAS(216, "Nubes medias noite"),
    NOITE_CHOIVA_DEBIL(217, "Choiva débil noite"),
    NOITE_CHUVASCOS_DEBILES(218, "Chuvascos débiles noite"),
    NOITE_TREBOADA_POUCAS_NUBES(219, "Treboada con poucas nubes noite"),
    NOITE_AUGA_NEVE(220, "Auga neve noite"),
    NOITE_SARABIA(221, "Sarabia noite");

    private final int codigo;
    private final String nome;

    EstadoCeo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
}
