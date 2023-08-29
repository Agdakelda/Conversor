package main;

import conversorMoedas.ConversorMoeda;
import conversorTemperatura.ConversorTemperatura;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        ConversorTemperatura conversorTemperatura = new ConversorTemperatura();

        while (true) {
            String[] opcoes = {
                "<html><b><font color=\"blue\">Converter Moeda</font></b><br></html>",
                "<html><b><font color=\"purple\">Converter Temperatura Celsius</font></b><br></html>"
                ,"<html><b><font color=\"orange\">Converter Dólar para Reais</font></b><br></html>" ,
                "<html><b><font color=\"red\">Sair</font></b></html>" , 
                "<html><b><font color=\"green\">Fahreinheit X Celsius</b></html>",
            };

            int escolha = JOptionPane.showOptionDialog(
                null, "Escolha uma opção: ", 
                "Conversor Interativo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]
            );
           

            if (escolha == 0) {
                double valorReais = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em reais: "));
                double valorDolares = conversorMoeda.converterReaisParaDolar(valorReais);
                DecimalFormat df = new DecimalFormat("#.0");
                String valorDolaresFormatado = df.format(valorDolares);
                JOptionPane.showMessageDialog(
                    null,
                    valorReais + " Reais equivalem a " + valorDolaresFormatado + " Dólares.",
                    "Resultado da Conversão",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }  if (escolha == 1) {
                double valorCelsius = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em Celsius: "));
                double valorFahrenheit = conversorTemperatura.celsiusParaFahrenheit(valorCelsius);
                JOptionPane.showMessageDialog(
                    null,
                    valorCelsius + " Celsius equivalem a " + valorFahrenheit + " Fahrenheit.",
                    "Resultado da Conversão",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            if (escolha == 2) { // Nova opção: Converter Dólar para Reais
                double valorDolares = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em dólares: "));
                double valorReais = conversorMoeda.converterDolarParaReais(valorDolares);

				DecimalFormat df = new DecimalFormat("#.00"); // Formatação com duas casas decimais
                String valorReaisFormatado = df.format(valorReais);

                JOptionPane.showMessageDialog(
                    null,
                    valorDolares + " Dólares equivalem a " + valorReaisFormatado + " Reais.",
                    "Resultado da Conversão",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
            }
            if (escolha == 3) {
                JOptionPane.showMessageDialog(null, "Até logo!", "Encerrando o Programa", JOptionPane.INFORMATION_MESSAGE);
                break;
            } 
            if (escolha == 4) { // Converter Fahrenheit para Celsius
                double valorFahrenheit = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em Fahrenheit: "));
                double valorCelsiusConvertido = conversorTemperatura.fahrenheitParaCelsius(valorFahrenheit);
                DecimalFormat df = new DecimalFormat("#.0"); // Formatação com uma casa decimal
                String valorCelsiusFormatado = df.format(valorCelsiusConvertido);

                JOptionPane.showMessageDialog(
                    null,
                    valorFahrenheit + " Fahrenheit equivalem a " + valorCelsiusFormatado + " Celsius.",
                    "Resultado da Conversão",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
}
