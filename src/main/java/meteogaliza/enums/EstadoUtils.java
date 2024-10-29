package meteogaliza.enums;

public interface EstadoUtils{
    int getCodigo();
    String getNome();

    static <E extends Enum<E> & EstadoUtils> String getNomePorCodigo(E[] estados, int codigo) {
        for (E estado : estados) {
            if (estado.getCodigo() == codigo) {
                return estado.getNome();
            }
        }
        throw new IllegalArgumentException("Código non válido: " + codigo);
    }

    static <E extends Enum<E> & EstadoUtils> int getCodigoPorNome(E[] estados, String nome) {
        for (E estado : estados) {
            if (estado.getNome().equalsIgnoreCase(nome)) {
                return estado.getCodigo();
            }
        }
        throw new IllegalArgumentException("Nome non válido: " + nome);
    }

    static <E extends Enum<E> & EstadoUtils> E getEstadoPorCodigo(E[] estados, int codigo) {
        for (E estado : estados) {
            if (estado.getCodigo() == codigo) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código no válido: " + codigo);
    }
}

