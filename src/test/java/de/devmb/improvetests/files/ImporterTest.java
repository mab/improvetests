package de.devmb.improvetests.files;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ImporterTest {

	@Rule
	public TemporaryFolder testDir = new TemporaryFolder();

	@Test
	public void testImporterWithoutTemporaryFolder() throws IOException {
		// prepare
		File importFolder = new File("importFolder");
		importFolder.mkdirs();
		new File(importFolder, "test.txt").createNewFile();
		Importer importer = new Importer(importFolder);

		// test
		assertThat(importer.importFiles(), is(1));
	}

	@Test
	public void testUsingTemporaryFolder() throws IOException {
		// prepare
		testDir.newFile("someFile.txt");
		Importer importer = new Importer(testDir.getRoot());

		// test
		assertThat(importer.importFiles(), is(1));
	}
}
