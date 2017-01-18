package com.sh.map.preprocess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;

import com.sh.map.data.SFMovie;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

// Adapted simple utility to read/write mapped object to/from CSV
// using http://www.univocity.com/pages/parsers-tutorial
// this is not component-tested since it does not part of service
public class SFMovieCSVUtil {

	public static List<SFMovie> readObjects(InputStream stream) {
	    BeanListProcessor<SFMovie> rowProcessor = new BeanListProcessor<SFMovie>(SFMovie.class);

	    CsvParserSettings parserSettings = new CsvParserSettings();
	    parserSettings.setRowProcessor(rowProcessor);
	    parserSettings.setHeaderExtractionEnabled(true);

	    CsvParser parser = new CsvParser(parserSettings);
	    parser.parse(stream);

	    List<SFMovie> beans = rowProcessor.getBeans();
	    return beans;
	}
	
	public static void writeCSV(List<SFMovie> objects, File outputFile) throws IOException {
		Writer write = new FileWriter(outputFile);

		CsvWriterSettings settings = new CsvWriterSettings();

		settings.setRowWriterProcessor(new BeanWriterProcessor<SFMovie>(SFMovie.class));

		CsvWriter writer = new CsvWriter(write, settings);

		writer.writeHeaders();

		for (SFMovie sfMovie : objects) {
			writer.processRecord(sfMovie);
		}
		    
		writer.close();
	}
}
