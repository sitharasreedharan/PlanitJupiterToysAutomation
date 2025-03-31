package com.ui.dataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.ui.pojo.Contact;
import com.utility.CSVReaderUtility;

public class ContactDataProvider {
	@DataProvider(name = "ContactTestCSVDataProvider")
	public static Iterator<Object[]> provideContactData() {
	        List<Map<String, String>> csvData = CSVReaderUtility.readCSVFile("contactData.csv");
	        List<Object[]> contactList = new ArrayList<>();
	        for (Map<String, String> row : csvData) {
	            Contact contact = new Contact(row.get("foreName"), row.get("surName"), row.get("email"), row.get("telephone"), row.get("message"));
	            contactList.add(new Object[] { contact });
	        }	       
	        return contactList.iterator();
	    }

}
