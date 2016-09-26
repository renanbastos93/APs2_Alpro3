package controller;

import avaliador.AvaliadorExpressao;
import datastructures.ListaEncadeada;
import model.SpreadsheetModel;
import view.Spreadsheet;

public class CalcMachine {
//        AvaliadorExpressao avaliador = new AvaliadorExpressao();
        ListaEncadeada<String> avaliador = new ListaEncadeada<String>();
        ListaEncadeada<String> cells = new ListaEncadeada<String>();
        AvaliadorExpressao formulas = new AvaliadorExpressao();

	public static void main(String[] args) {
		(new CalcMachine()).run();
	}

	private void run() {
		SpreadsheetModel m = new SpreadsheetModel() {
			@Override
			public void setFormula(String cell, String formula) {
                            
                            cells.append(cell);
                            formulas.setExpressao(formula);
                            avaliador.append(formulas.getExpressao());
                            Double frm = formulas.calcFormula(formulas.getExpressao());
                            System.out.println(cell + " : " + frm);
			}
			
			@Override
			public String getValue(String cell) {
                            return String.format("%06g", Math.random()*100 - 50);
			}

			@Override
			public String getFormula(String cell) {
				return "="+cell;
			}
		};
		
		(new Spreadsheet(m)).start();
	}
}
