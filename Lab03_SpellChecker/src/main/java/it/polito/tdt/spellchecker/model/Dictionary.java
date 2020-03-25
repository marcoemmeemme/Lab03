
	package it.polito.tdt.spellchecker.model;
	import java.io.*;
	import java.util.*;

	public class Dictionary {
		List <String> dizionario=new LinkedList<String>();
		List <String> list=new LinkedList<String>();
		List<String> paroleSbagliate=new LinkedList<String>();
		private String ris;
		private int conta;
		public void loadDictionary(String language)
		{
			try
			{
				FileReader fr;
				String nomeFile="src/main/resources/"+language+".txt";
				fr=new FileReader(nomeFile);	
				BufferedReader br=new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null)
				{
					dizionario.add(word);
				}
				br.close();
			}
			catch(IOException e)
			{
				System.out.println("Errore nella lettura dei file");
			}
		}
		
		public String spellCheckText(String parola)
		{
			list=this.spezza(parola);
			for(String par:list)
			{	
				boolean check=false;
				for(String s:dizionario)
				{	
					if(par.compareTo(s)==0)
						check=true;
				}
				if(check==false)
					paroleSbagliate.add(par);
			}
			return this.stampa();
		}
		
		public List<String> spezza(String contenuto)
		{
			contenuto.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
			String[] campi=contenuto.split(" ");
			list=Arrays.asList(campi);
			return list;
		}
		
		public String stampa()
		{
			ris="";
			for(String p:paroleSbagliate)
			{
				ris+=p+"\n";
			}
			if(ris.isEmpty())
				return ris; 
			else return ris.substring(0,ris.length()-1);
		}
		
		public int conta()
		{
			conta=paroleSbagliate.size();
			return conta;
		}
		
		public void reset()
		{
			this.dizionario.removeAll(dizionario);
			this.paroleSbagliate.removeAll(paroleSbagliate);
		}
	}
