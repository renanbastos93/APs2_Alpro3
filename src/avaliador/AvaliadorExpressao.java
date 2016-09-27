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
        String res = "1-2+3*4/5+1"; // "1 2 + 3 2 / + 4 -
        // 3*2*(5-1) == 5 1 - 2 * 3 *
        System.out.println("res:" + newFormula(res));
//        System.out.println("calc:" + calcFormula(newFormula(res)));

    }

    private static boolean eOperador(String op) {
        String oper = "-+/*";
        if (oper.contains(op)) {
            return true;
        }
        return false;
    }

    private static int prioridadeOperador(String op) {
        String oper = "-+*/";
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            case "(":
                return 0;
        }
        return -1;
    }

    ;
        
    public static String newFormula(String formula) {

        Pilha<String> operator = new Pilha<>();
        String resposta = "";
        String ultimo = "";
        String retirado = "";

        int cont = 0;
        for (int i = 0; i < formula.length(); i++) {
            System.out.println(retirado);
            ultimo = Character.toString(formula.charAt(i));
            cont = i;
            if (!eOperador(ultimo)) {
                while (Character.isDigit(formula.charAt(cont))) {
                    i = cont;
                    resposta += formula.charAt(cont);
                    if (cont == formula.length() - 1) {
                        break;
                    }
                    cont++;
                }
            } else if (operator.isEmpty()) {
                System.out.println(ultimo);
                operator.push(ultimo);
                resposta += retirado.trim();
            } else {
                retirado = operator.pop();
                resposta += retirado.trim();
            }
        }
        resposta += operator.pop();
        return resposta.trim();

    }

    public static double calcFormula(String formula) {

        Pilha<Double> pilha = new Pilha<>();
        Scanner entrada = new Scanner(formula); //2 5 * 4 -
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
