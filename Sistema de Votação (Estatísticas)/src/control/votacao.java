package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class votacao {
	String archive = "Votacao2016.txt";

	public void carregarSecao() throws IOException {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			model.votacao a = new model.votacao();
			a.numCandidato = random.nextInt(301);
			a.numSecao = random.nextInt(11);
			this.save(a);
		}
	}

	public void gravarRegistro() throws IOException {
		model.votacao a = new model.votacao();
		a.numCandidato = Integer.parseInt(JOptionPane.showInputDialog("numero candidato (int)"));
		a.numSecao = Integer.parseInt(JOptionPane.showInputDialog("numero secao (int)"));
		this.save(a);
	}

	public int[] qtdEleitoresSecao() throws IOException {
		model.votacao[] votacoes = this.getAll();
		int secao[] = new int[11];
		for (int i = 0; i < 11; i++)
			secao[i] = 0;
		for (int i = 0; i < votacoes.length; i++) {
			System.out.println(votacoes[i].getNumSecao());
			secao[votacoes[i].getNumSecao()]++;
		}
		for (int i = 0; i < 11; i++) { // DEBUGGER
			System.out.println(String.format("Secao %s Eleitores %s", i, secao[i]));
		}
		return secao;
	}

	public void maiorMenor() throws IOException {
		int a[] = this.qtdEleitoresSecao(), maior = a[0], menor = a[0], maiorN = -1, menorN = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maior) {
				maior = a[i];
				maiorN = i;
			}
			if (a[i] < menor) {
				menor = a[i];
				menorN = i;
			}
		}
		JOptionPane.showMessageDialog(null,
				String.format("Maior %s (%s), Menor %s (%s)", maior, maiorN, menor, menorN));
	}

	public int[] votesPerCandidate() throws IOException {
		model.votacao[] v = this.getAll();
		int votCandidato[] = new int[301];
		for (int i = 0; i < 301; i++)
			votCandidato[i] = 0;
		for (model.votacao a : v) {
			votCandidato[a.numCandidato]++;
		}
		for (int i = 0; i < 301; i++) {
			System.out.println(String.format("Candidato %s Votos %s", i, votCandidato[i]));
		}
		return votCandidato;
	}

	public void top10() throws IOException {
		model.votacao[] v = this.getAll();
		int votCandidato[] = new int[301];
		for (int i = 0; i < 301; i++)
			votCandidato[i] = 0;
		for (model.votacao a : v) {
			votCandidato[a.numCandidato]++;
		}
		Arrays.sort(votCandidato);
		for(int i=votCandidato.length-1;i>=0;i--) {
			System.out.println(String.format("Candidato %s Votos %s", i, votCandidato[i]));
		}
	}

	public void save(model.votacao v) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(archive, true));
		writer.append(String.format("%s;%s", v.getNumCandidato(), v.getNumSecao()));
		writer.newLine();
		writer.close();
	}

	public model.votacao[] getAll() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		int counter = 0;
		while (reader.readLine() != null)
			counter++;
		reader = new BufferedReader(new FileReader(archive));
		model.votacao[] votacoes = new model.votacao[counter];
		for (int i = 0; i < counter; i++) {
			votacoes[i] = new model.votacao();
			String txt = reader.readLine();
			votacoes[i].setNumCandidato(Integer.parseInt(txt.split(";")[0]));
			votacoes[i].setNumSecao(Integer.parseInt(txt.split(";")[1]));
		}
		reader.close();
		return votacoes;
	}

	public model.votacao[] classSecao() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		int counter = 0;
		while (reader.readLine() != null)
			counter++;
		reader = new BufferedReader(new FileReader(archive));
		model.votacao[] votacoes = new model.votacao[counter];
		for (int i = 0; i < counter; i++) {
			votacoes[i] = new model.votacao();
			String txt = reader.readLine();
			votacoes[i].setNumCandidato(Integer.parseInt(txt.split(";")[0]));
			votacoes[i].setNumSecao(Integer.parseInt(txt.split(";")[0]));
		}
		reader.close();
		Arrays.sort(votacoes, (a, b) -> ("" + a.numSecao).compareTo("" + b.numSecao));
		JOptionPane.showMessageDialog(null, "dados classificados");
		return votacoes;
	}
}
