package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.votacao;

public class App {
	public static void main(String[] args) throws IOException {
		control.votacao a = new votacao();
		while(true==true) {
			System.out.println(
					"----------------------------------------------------------------\n" + 
					"|	SISTEMA DE VOTAÇÃO			|\n" + 
					"|      1 – Carregar Seção 				|\n" + 
					"|      2 – Classificar por Seção      		|\n" + 
					"|      3 – Gravar Registros                                |\n" + 
					"|      4 – Mostrar Indicadores                           |\n" + 
					"|      9 – Finalizar                                           	|\n" + 
					"----------------------------------------------------------------"
					);
			int in = Integer.parseInt(JOptionPane.showInputDialog("number: "));
			switch (in) {
			case 1:
				a.carregarSecao();
				break;
			case 2:
				a.classSecao();
				break;
			case 3:
				a.gravarRegistro();
				break;
			case 4:
				int in2;
				do{
					System.out.println("-----------------------------------------------------------------------\n" + 
							"|	    Mostrar Indicadores			               |\n" + 
							"|        Estatísticas de Votação em 2016		     |\n" + 
							"|  1 – Quantidade Eleitores por Seção	                         |\n" + 
							"|  2 –Seção com Maior e Menor número de Eleitores    |\n" + 
							"|  3 – Quantidade de votos por candidato                     |\n" + 
							"|  4 – 10 primeiros colocadas (nro  cand. e qtd votos ) |\n" + 
							"|  9 – Finaliza consulta	                		              |\n" + 
							"------------------------------------------------------------------------");
					in2 = Integer.parseInt(JOptionPane.showInputDialog("number:"));
					switch (in2) {
					case 1:
						a.qtdEleitoresSecao();
						break;
					case 2:
						a.maiorMenor();
						break;
					case 3:
						a.votesPerCandidate();
						break;
					case 4:
						a.top10();
						break;
					default:
						break;
					}
				} while(in2 != 9);
				break;
			case 9:
				return;
			default:
				break;
			}
			System.out.println("okasdksao");
		}
	}
}
