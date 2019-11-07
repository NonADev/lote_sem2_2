package view;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Estatistica;

public class estatística2015 {
	public static void main(String[] args) throws IOException {
		JOptionPane pane = new JOptionPane();
		control.Estatistica c = new control.Estatistica();
		int in = 0;
		while (true == true) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|	MENU ESTATISTICA                       			 	|");
			System.out.println("|	1	-	Cadastro Estatistica				|");
			System.out.println("|	2	-	Consulta por tipo de veículo			|");
			System.out.println("|	3	-	Consulta por quantidade de acidentes		|");
			System.out.println("|	4	-	Consulta todos as cidades                       |");
			System.out.println("|	5	-	Consulta maior menor média de acidentes		|");
			System.out.println("|	9	-	Finaliza					|");
			System.out.print("-------------------------------------------------------------------------\n");
			in = Integer.parseInt(pane.showInputDialog("Opcao"));
			switch (in) {
			case 1:
				model.Estatistica e = new Estatistica();
				e.Cod_Cidade = Integer.parseInt(pane.showInputDialog("Codigo Cidade"));
				e.Nome_Cidade = pane.showInputDialog("Nome Cidade");
				e.QTD_Acidentes = Integer.parseInt(pane.showInputDialog("QTD Acidentes"));
				e.Tipo_Veiculo = Integer.parseInt(pane.showInputDialog("Tipo Veiculo"));
				c.FCADRASTRAESTATISTICA(e);
				pane.showMessageDialog(null, "Salvo!");
				break;
			case 2:
				if (true == true) {
					int tipo = Integer.parseInt(pane.showInputDialog("Tipo do veiculo"));
					model.Estatistica[] temp = c.FTIPO(tipo);
					for (int i = 0; i < temp.length; i++) {
						pane.showMessageDialog(null, String.format("%s %s %s %s", temp[i].Cod_Cidade,
								temp[i].Nome_Cidade, temp[i].QTD_Acidentes, temp[i].Tipo_Veiculo));
					}
				}
				break;
			case 3:
				if (true == true) {
					model.Estatistica[] temp = c.PQTACIDENTES();
					for (int i = 0; i < temp.length; i++) {
						pane.showMessageDialog(null, String.format("%s %s %s %s", temp[i].Cod_Cidade,
								temp[i].Nome_Cidade, temp[i].QTD_Acidentes, temp[i].Tipo_Veiculo));
					}
				}
				break;
			case 4:
				if (true == true) {
					model.Estatistica[] temp = c.getAll();
					for (int i = 0; i < temp.length; i++) {
						pane.showMessageDialog(null, String.format("CEP: %s\nCidade: %s\nAcidentes: %s \nModelo do veiculo: %s", temp[i].Cod_Cidade,
								temp[i].Nome_Cidade, temp[i].QTD_Acidentes, temp[i].Tipo_Veiculo));
					}
				}
				break;
			case 5:
				if (true == true) {
					model.Estatistica temp = c.maiorAcidentes();
					pane.showMessageDialog(null, String.format("MAIOR: %s %s %s %s", temp.Cod_Cidade,temp.Nome_Cidade, temp.QTD_Acidentes, temp.Tipo_Veiculo));
					temp = c.menorAcidentes();
					pane.showMessageDialog(null, String.format("MENOR: %s %s %s %s", temp.Cod_Cidade,temp.Nome_Cidade, temp.QTD_Acidentes, temp.Tipo_Veiculo));					
				}
				break;
			case 9:
				return;
			default:
				pane.showMessageDialog(null, "Opcao inexistente");
				break;
			}
		}
	}
}
