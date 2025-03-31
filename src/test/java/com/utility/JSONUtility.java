package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.ui.pojo.Config;

public class JSONUtility {

	public static Config readJSON() {
		Gson gson = new Gson();
		try {
			File jsonFile = Paths.get(System.getProperty("user.dir"), "config", "config.json").toFile();
			FileReader reader = new FileReader(jsonFile); 
			Config config = gson.fromJson(reader, Config.class);
			reader.close();
			return config;
		} catch (IOException e) {
			e.printStackTrace();
			return null; //  null if there's an error reading the file
		}
	}

}
