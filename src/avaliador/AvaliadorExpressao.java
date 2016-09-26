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
        String expressao = "2 5 * 4 -";
        Scanner entrada = new Scanner(expressao);
        Pilha<Double> pilha = new Pilha<>();
        
        public double calcFormula(String formula){
            while(entrada.hasNext()){
			if(entrada.hasNextDouble()){
				pilha.push(entrada.nextDouble());
			}
			if(entrada.hasNext("[-+/*]")){
				Double rhs = pilha.pop();
				Double lhs = pilha.pop();
				
				switch(entrada.next()){
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
				}
				
			}
					
		}
            return pilha.pop();
        }
        

}
