package co.edu.uptc.utilities;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Archive {

	public boolean OverwriteArchive(String route, String text) {

		// Ruta relativas (Recursos\Vacunacion\Recursos)
				// Ruta absoluta (C:\Users\PERSONAL\eclipse-workspace\Vacunacion\Recursos)
		
		File archive = new File(route); // Lo primero se define un objeto de tipo file, crea un archivo en memoria
		boolean exist = false;
		BufferedWriter bw; // Escribe y ya

		try {
			if (archive.exists()) {
				bw = new BufferedWriter(new FileWriter(archive));
				bw.write(text + ";\n");
				exist = true;
			} else {
				bw = new BufferedWriter(new FileWriter(archive));
				bw.write(text);
				exist = false;

			}
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return exist;
	}

	public void AddContents(String route, String text) {

		// String ruta = "Resources/" + nombre + ".txt"
		File archive = new File(route);
		String inf;
		try {

			FileWriter fstream = new FileWriter(archive, true);
			BufferedWriter out = new BufferedWriter(fstream);
			FileReader fr = new FileReader(archive);
			BufferedReader b = new BufferedReader(fr);
			while ((inf = b.readLine()) != null) {
			}
			out.write(text + ";\n");
			out.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String FullFileContent(String route) {

		File archive = new File(route);
		String chain = null;
		String chainLast = "++";

		try {

			FileReader f = new FileReader(archive);
			BufferedReader b = new BufferedReader(f);

			while ((chain + b.readLine()) != null) {
				chainLast = chain + "++" + chainLast;
			}

			b.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return chainLast;

	}

	public ArrayList<String> FileContents(String route) {

		File archive = new File(route);
		String chain = null;

		ArrayList<String> finalarray = new ArrayList<String>();

		try {

			FileReader f = new FileReader(archive);
			BufferedReader b = new BufferedReader(f);

			while ((chain = b.readLine()) != null) {
				finalarray.add(chain);
			}

			b.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return finalarray;

	}

	public void CreateDirectory(String route) {

		// File directorio = new
		// File("C:\\Users\\PERSONAL\\eclipse-workspace\\Vacunacion");
		File directory = new File(route);
		try {
			directory.mkdir();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("No se pudo crear el archivo");
		}

	}

	public void DeleteLine(String route, String LinDelete) {

		Random numrandom = new Random(3816L);
		File inputFile = new File(route);
		File outputFile = new File(
				inputFile.getParent() + "/" + String.valueOf(Math.abs(numrandom.nextInt())) + ".txt");

		try {
			FileReader f = new FileReader(inputFile);
			FileWriter g = new FileWriter(outputFile);
			BufferedReader reader = new BufferedReader(f);
			BufferedWriter writer = new BufferedWriter(g);

			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.trim().equals(LinDelete)) {
					continue;
				}
				writer.write(currentLine + "\n");
				// writer.write(currentLine + System.getProperty("line.separator"));
			}

			writer.close();
			reader.close();
			inputFile.delete();
			System.out.println("La linea de texto " + LinDelete + " ya fue eliminada");
			outputFile.renameTo(new File(route));

		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
			System.err.println("No se pudo borrar la linea");
		}

	}

	public void DeleteLineOfArchive(String route, int cont2) {
		File f = new File(route);
		File nf = new File(f.getParent() + "/Ejemplo1.txt");
		String inf;
		int cont = 1;
		if (f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader b = new BufferedReader(fr);
				FileWriter fw = new FileWriter(nf, true);
				BufferedWriter out = new BufferedWriter(fw);

				while ((inf = b.readLine()) != null) {
					if (cont != cont2) {
						if (nf.exists()) {
							// fw.append(inf + "\n");
							out.write(inf + "\n");
						}
					}
					++cont;
				}
				// fw.close();
				out.close();
				b.close();
				f.delete();
				System.out.println("La linea de texto " + cont2 + " de el archivo" + route + " ya fue eliminado");
				nf.renameTo(new File(route));
			} catch (IOException ex) {
				ex.printStackTrace();
				System.err.println(ex.getMessage());
				System.err.println("No se pudo borrar la linea");
			}
		}
	}

	public void DeleteArchive(String route) {
		File f = new File(route);
		f.delete();
	}

	public void DeleteDirectory(String route){
		
		File f = new File(route); // define la ruta del archivo
		if (f.exists() && f.isDirectory()) {// determina si es un archivo o un directorio
			if (f.listFiles().length == 0) {// Si no hay archivos en el directorio, elim�nelos directamente
				f.delete();
			} else {// Si lo hay, coloque el archivo en la matriz y determine si hay un directorio
					// subordinado
				File delFile[] = f.listFiles();
				
				for (int i = 0; i < f.listFiles().length; i++) {
					if (delFile[i].isDirectory()) {
						DeleteDirectory(delFile[i].getAbsolutePath()); // Llame al metodo del de forma recursiva y obtenga la ruta
															// del subdirectorio
					}
					delFile[i].delete(); // eliminar un archivo
				}
			}
		}
	}
	
	public void resetArchive(String Route) {

		File a = new File(Route);
		BufferedWriter bw;

		if (a.exists()) {

			try {

				bw = new BufferedWriter(new FileWriter(a));
				bw.write("");

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}
}
