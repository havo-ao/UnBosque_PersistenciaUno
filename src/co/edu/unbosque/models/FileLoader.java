package co.edu.unbosque.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import co.edu.unbosque.models.persistence.FileHandler;

public class FileLoader {
	private String fileText;
	private FileHandler fileHandler;
	private File file;

	public FileLoader(File file) {
		this.file = file;
		this.fileHandler= new FileHandler(this.file);
	}
	
	public String readFile() throws FileNotFoundException, IOException {
		this.fileText = fileHandler.readFile();
		return this.fileText;
	}

}
