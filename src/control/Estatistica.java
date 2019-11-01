package control;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Estatistica {
	String arquivo = "./Estatistica.txt";

	public void FCADRASTRAESTATISTICA(model.Estatistica e) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true));
		writer.append(String.format("%s;%s;%s;%s", e.Cod_Cidade, e.Nome_Cidade, e.QTD_Acidentes, e.Tipo_Veiculo));
		writer.newLine();
		writer.close();
	}

	public model.Estatistica[] getAll() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));
		Object[] linhas = reader.lines().toArray();
		String rlinhas[] = new String[linhas.length];
		for (int i = 0; i < linhas.length; i++) {
			if (linhas[i] != "")
				rlinhas[i] = "" + linhas[i];
		}
		model.Estatistica[] returnLinhas = new model.Estatistica[rlinhas.length];
		for (int i = 0; i < linhas.length; i++) {
			returnLinhas[i] = new model.Estatistica();
			returnLinhas[i].Cod_Cidade = Integer.parseInt(rlinhas[i].split(";")[0]);
			returnLinhas[i].Nome_Cidade = rlinhas[i].split(";")[1];
			returnLinhas[i].QTD_Acidentes = Integer.parseInt(rlinhas[i].split(";")[2]);
			returnLinhas[i].Tipo_Veiculo = Integer.parseInt(rlinhas[i].split(";")[3]);
		}
		reader.close();
		return returnLinhas;
	}
	
	public model.Estatistica[] acimaMedia() throws IOException{
		Estatistica est = new Estatistica();
		model.Estatistica e[] = est.getAll();
		ArrayList<model.Estatistica> lista = new ArrayList();
		//GET MEDIA
		double media = 0;
		for(int i=0;i<e.length;i++) {
			media+=e[i].QTD_Acidentes;
		}		
		media/=e.length;
		
		// RETURN PEOPLE
		int counter = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[i].QTD_Acidentes > media) {
				lista.add(e[i]);
				counter++;
			}
		}
		model.Estatistica[] returnTipo = new model.Estatistica[counter];
		Iterator<model.Estatistica> iterator = lista.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			returnTipo[i] = iterator.next();
		}
		return returnTipo;
		
	}
	
	public model.Estatistica menorAcidentes() throws IOException{
		control.Estatistica c = new control.Estatistica();
		model.Estatistica[] lis = c.getAll();
		model.Estatistica fin = new model.Estatistica();
		fin = lis[0];
		for(int i=1;i<lis.length;i++) {
			if(fin.QTD_Acidentes>lis[i].QTD_Acidentes) {
				fin = lis[i];
			}
		}
		return fin;		
	}

	public model.Estatistica maiorAcidentes() throws IOException{
		control.Estatistica c = new control.Estatistica();
		model.Estatistica[] lis = c.getAll();
		model.Estatistica fin = new model.Estatistica();
		fin = lis[0];
		for(int i=1;i<lis.length;i++) {
			if(fin.QTD_Acidentes<lis[i].QTD_Acidentes) {
				fin = lis[i];
			}
		}
		return fin;		
	}

	public model.Estatistica PCONSULTAACIDENTES (model.Estatistica e) throws IOException{
		control.Estatistica c = new control.Estatistica();
		model.Estatistica[] lis = c.getAll();
		for(int i=0;i<lis.length;i++) {
			if(e.Cod_Cidade==lis[i].Cod_Cidade) {
				lis[0] = lis[i];
			}
		}
		return lis[0];
	}	
	
	public model.Estatistica[] PQTACIDENTES() throws IOException{
		Estatistica est = new Estatistica();
		model.Estatistica e[] = est.getAll();
		ArrayList<model.Estatistica> lista = new ArrayList();
		int counter = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[i].QTD_Acidentes>100 && e[i].QTD_Acidentes<500) {
				lista.add(e[i]);
				counter++;
			}
		}
		model.Estatistica[] returnTipo = new model.Estatistica[counter];
		Iterator<model.Estatistica> iterator = lista.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			returnTipo[i] = iterator.next();
		}
		return returnTipo;		
	}

	public model.Estatistica[] FTIPO(int a) throws IOException {
		Estatistica est = new Estatistica();
		model.Estatistica e[] = est.getAll();
		ArrayList<model.Estatistica> lista = new ArrayList();
		int counter = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[i].Tipo_Veiculo == a) {
				lista.add(e[i]);
				counter++;
			}
		}
		model.Estatistica[] returnTipo = new model.Estatistica[counter];
		Iterator<model.Estatistica> iterator = lista.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			returnTipo[i] = iterator.next();
		}
		return returnTipo;
	}
}
