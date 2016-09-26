/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliador;

/**
 *
 * @author Renan Bastos
 */
import java.util.Scanner;

import datastructures.Pilha;

public class AvaliadorExpressao {

    private String expressao = ""; //2 5 * 4 -;
    private Pilha<Double> pilha = new Pilha<>();
    Pilha<String> operator = new Pilha<>();

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public static void main(String[] args) {
        System.out.println("res:" + newFormula("159+3+7"));
    }

    public static String newFormula(String formula) {

        Pilha<String> operator = new Pilha<>();
        String resposta = "";
        String operadores = "+-/*";
        String ultimo;
        int cont = 0;
        /* 
            Falta tratar vezes e dividir
        */
        for (int i = 0; i < formula.length(); i++) {
            ultimo = Character.toString(formula.charAt(i));
            cont = i;
            if (!operadores.contains(ultimo)) {
                while (Character.isDigit(formula.charAt(cont))) {
                    i = cont;
                    resposta += " " + formula.charAt(cont);
                    if(cont == formula.length()-1){
                        break;
                    }
                    cont++;
                }

            } else if (operator.isEmpty()) {
                operator.push(ultimo);
            } else {
                resposta += " " + operator.pop();
                operator.push(ultimo);
            }
        }
        resposta += " " + operator.pop();
        return resposta.trim();
    }

    public double calcFormula(String formula) {
        Scanner entrada = new Scanner(newFormula(formula)); //2 5 * 4 -
        while (entrada.hasNext()) {
            if (entrada.hasNextDouble()) {
                pilha.push(entrada.nextDouble());
            }
            if (entrada.hasNext("[-+/*]")) {
                Double rhs = pilha.pop();
                Double lhs = pilha.pop();
                switch (entrada.next()) {

                    case "+":
                        pilha.push(lhs + rhs);
                        break;
                    case "-":
                        pilha.push(lhs - rhs);
                        break;
                    case "/":
                        pilha.push(lhs / rhs);
                        break;
                    case "*":
                        pilha.push(lhs * rhs);
                        break;
                    default:
                        System.out.println("Deu erro na expressao");
                        break;
                }

            }

        }
        return pilha.pop();
    }

}
