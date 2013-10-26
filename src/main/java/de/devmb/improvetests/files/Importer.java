package de.devmb.improvetests.files;

import java.io.File;

public class Importer {

	private File importFolder;

	public Importer(File importFolder) {
		this.importFolder = importFolder;
	}

	public int importFiles() {
		System.out.println(importFolder.getAbsolutePath());
		return importFolder.listFiles().length;
	}

}
