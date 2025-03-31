package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderUtility {

	public static List<Map<String, String>> readCSVFile(String filename) {

		File csvFile = Paths.get(System.getProperty("user.dir"), "testData", filename).toFile();
		FileReader fileReader = null;
		CSVReader csvReader = null;
		List<Map<String, String>> dataList = new ArrayList<>();

		try {

			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			String[] header = csvReader.readNext();
			String[] line;
			while ((line = csvReader.readNext()) != null) {
				Map<String, String> rowMap = new HashMap<>();
				for (int i = 0; i < header.length; i++) {
					rowMap.put(header[i], line[i]);
				}
				dataList.add(rowMap);
			}

		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		} finally {
			try {
				if (csvReader != null) {
					csvReader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return dataList;
	}

}
