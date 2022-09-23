package co.edu.unbosque.models.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandler {
	private File file;

	public FileHandler(File file) {
		this.file = file;
	}

	public String readFile() throws IOException, FileNotFoundException, NullPointerException {
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader line = null;

		try {
			fis = new FileInputStream(this.file);
			isr = new InputStreamReader(fis);
			line = new BufferedReader(isr);

			if (this.file.exists()) {
				String fileLine = "";
				String fullFile = fileLine;

				while (fileLine != null) {
					fileLine = line.readLine();

					if (fileLine != null) {
						fullFile = fullFile + "\n" + fileLine;
					}

				}

				return fullFile;
			} else {
				throw new FileNotFoundException();
			}

		} catch (IOException e) {
			System.out.println("Unable to read file");
			e.printStackTrace();
			return "Unable to read file";
		} finally {
			line.close();
		}

	}
}
