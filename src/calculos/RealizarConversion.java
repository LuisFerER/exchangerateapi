package calculos;

import modelos.TipoDeCambio;

public class RealizarConversion {

    private TipoDeCambio miTipo;
    private String tasa;

    public RealizarConversion(TipoDeCambio tipoDeCambio, String tasa){
        this.miTipo = tipoDeCambio;
        this.tasa = tasa;
    }

    public double resultadoConversion(){
        double tasa = miTipo.getTasasDeConversion().get(this.tasa);
        tasa = tasa * miTipo.getValorBase();
        return tasa;
    }

}
