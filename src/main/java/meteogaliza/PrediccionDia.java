package meteogaliza;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrediccionDia {
    private Date dataPredicion; // Guádala para que la ponga mejor como LocalDate
    private int nivelAviso;
    private int tMax;
    private int tMin;
    private int uvMaz;
    private List<VariableFranxa> listaVariableFranxa;

    public PrediccionDia() {
        listaVariableFranxa = new ArrayList<>();
    }

    public PrediccionDia(Date dataPredicion, int nivelAviso, int tMax, int tMin, int uvMaz, List<VariableFranxa> listaVariableFranxa) {
        this.dataPredicion = dataPredicion;
        this.nivelAviso = nivelAviso;
        this.tMax = tMax;
        this.tMin = tMin;
        this.uvMaz = uvMaz;
        this.listaVariableFranxa = listaVariableFranxa;
    }

    public Date getDataPredicion() {
        return dataPredicion;
    }

    public PrediccionDia setDataPredicion(Date dataPredicion) {
        this.dataPredicion = dataPredicion;
        return this;
    }

    public int getNivelAviso() {
        return nivelAviso;
    }

    public PrediccionDia setNivelAviso(int nivelAviso) {
        this.nivelAviso = nivelAviso;
        return this;
    }

    public int gettMax() {
        return tMax;
    }

    public PrediccionDia settMax(int tMax) {
        this.tMax = tMax;
        return this;
    }

    public int gettMin() {
        return tMin;
    }

    public PrediccionDia settMin(int tMin) {
        this.tMin = tMin;
        return this;
    }

    public int getUvMaz() {
        return uvMaz;
    }

    public PrediccionDia setUvMaz(int uvMaz) {
        this.uvMaz = uvMaz;
        return this;
    }

    public List<VariableFranxa> getListaVariableFranxa() {
        return listaVariableFranxa;
    }

    public PrediccionDia addListaVariableFranxa(VariableFranxa variableFranxa){
        listaVariableFranxa.add(variableFranxa);
        return this;
    }

    public PrediccionDia setListaVariableFranxa(List<VariableFranxa> listaVariableFranxa) {
        this.listaVariableFranxa = listaVariableFranxa;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrediccionDia{");
        sb.append("dataPredicion='").append(dataPredicion).append('\'');
        sb.append(", nivelAviso=").append(nivelAviso);
        sb.append(", tMax=").append(tMax);
        sb.append(", tMin=").append(tMin);
        sb.append(", uvMaz=").append(uvMaz);
        sb.append(", listaVariableFranxa=").append(listaVariableFranxa);
        sb.append('}');
        return sb.toString();
    }
}
