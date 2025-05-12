package modelos;

import java.util.Map;

public class TipoDeCambio {

    private String resultado;
    private String codigoBase;
    private Map<String, Double> tasasDeConversion;
    private Double valorBase;
    private Double valorConvertido;

    public TipoDeCambio(){

    }

    public TipoDeCambio(TipoDeCambioAPI resultadoConsulta) {
        this.resultado = resultadoConsulta.result();
        this.codigoBase = resultadoConsulta.base_code();
        this.tasasDeConversion = resultadoConsulta.conversion_rates();
    }

    public String getResultado() {
        return resultado;
    }

    public String getCodigoBase() {
        return codigoBase;
    }

    public Map<String, Double> getTasasDeConversion() {
        return tasasDeConversion;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(Double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }
}
