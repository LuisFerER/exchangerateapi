package modelos;

import java.util.Map;

public record TipoDeCambioAPI(String result,
                              String base_code,
                              Map<String,Double> conversion_rates) {
}
