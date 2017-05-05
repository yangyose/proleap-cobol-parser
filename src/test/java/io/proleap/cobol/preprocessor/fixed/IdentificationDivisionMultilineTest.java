package io.proleap.cobol.preprocessor.fixed;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.preprocessor.impl.CobolPreprocessorImpl;

public class IdentificationDivisionMultilineTest {

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/preprocessor/fixed/IdentificationDivisionMultiline.cbl");
		final File libDirectory = inputFile.getParentFile();
		final String preProcessedInput = new CobolPreprocessorImpl().process(inputFile, libDirectory,
				CobolSourceFormatEnum.FIXED);

		final File expectedFile = new File(
				"src/test/resources/io/proleap/cobol/preprocessor/fixed/IdentificationDivisionMultiline.cbl.preprocessed");
		final String expected = FileUtils.readFileToString(expectedFile);
		assertEquals(expected, preProcessedInput);
	}
}