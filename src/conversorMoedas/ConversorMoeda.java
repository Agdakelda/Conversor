package conversorMoedas;

public class ConversorMoeda {
 private static final double taxaDolarParaReais = 5.4;
 	public double converterReaisParaDolar(double reais) {
 		return reais/taxaDolarParaReais;
 	}
 	public double converterDolarParaReais(double dolares) {
 		return dolares*taxaDolarParaReais;
 	}
}
