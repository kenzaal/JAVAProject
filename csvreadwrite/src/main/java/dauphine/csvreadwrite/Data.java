package dauphine.csvreadwrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
/*
 * Cette classe permet de récupérer toutes les informations relatives au colonnes 
 * à partir des fichiers Json
 */
public class Data {
	
	
	
	public static void printListColumn(ArrayList<Column> data) {
		for(Column e: data)
			System.out.println(e.toString());
	}
	

	public static ArrayList<Column> getdescData(String description_file_path) {
		ArrayList<Column> list = new ArrayList<Column>();
		JsonArray descData;

		try {
			descData = new Gson().fromJson(new FileReader(description_file_path), JsonArray.class);
			
			// initialize columns
			for (int i = 0; i < descData.size(); i++) {
				Column c = new Column();
				String name = descData.get(i).getAsJsonObject().get("name").getAsString();
				String type = descData.get(i).getAsJsonObject().get("name").getAsString();
				c.setName(name);
				c.setType(type);
				list.add(c);
			}

			} catch (FileNotFoundException e) {
			System.out.println("Error: file not found. ");
			e.printStackTrace();
		}
		return list;
	}
	
	public static ArrayList<String> getVerificationRules(JsonArray l) {
		ArrayList<String> ar = new ArrayList<String>();
		for(JsonElement e: l) {
			ar.add(e.getAsString().replaceAll("\"","")); 
		}
		return ar;

	}
	
	
	
	public static ArrayList<Column> getverifData(ArrayList<Column> list, String verification_file_path) {
		JsonArray verifjsondata;

		try {
			verifjsondata = new Gson().fromJson(new FileReader(verification_file_path), JsonArray.class);
		
			for (int i = 0; i < list.size(); i++) {
				String name = list.get(i).getName(); 
				for (int j = 0; j < verifjsondata.size(); j++) {
					String verifName  = verifjsondata.get(j).getAsJsonObject().get("name").getAsString();
					if (name.equals(verifName)) {
							list.get(i).setVerificationRules(Data.getVerificationRules(verifjsondata.get(j).getAsJsonObject().get("should").getAsJsonArray()));
					}
				}
			}

			} catch (FileNotFoundException e) {
			System.out.println("Error: file not found. ");
			e.printStackTrace();
		}
		return list;
	}
	
	public static ArrayList<Column> getAnnonymData(ArrayList<Column> list, String anonymisation_file_path) {
		JsonArray annonymjsondata;

		try {
			annonymjsondata = new Gson().fromJson(new FileReader(anonymisation_file_path), JsonArray.class);
		
			for (int i = 0; i < list.size(); i++) {
				String name = list.get(i).getName(); 
				for (int j = 0; j < annonymjsondata.size()-1; j++) {
					String anonymName  = annonymjsondata.get(j).getAsJsonObject().get("name").getAsString();
					if (name.equals(anonymName)) {
							list.get(i).setAnonymisationRule(annonymjsondata.get(j).getAsJsonObject().get("changeTo").getAsString());
					}
				}
			}

			} catch (FileNotFoundException e) {
			System.out.println("Error: file not found. ");
			e.printStackTrace();
		}
		return list;
	}
	
	public static ArrayList<Column> getAllColumnsInfo(ArrayList<Column> data, String description_file_path, String verification_file_path,
			String anonymisation_file_path)  {
		ArrayList<Column> descDtat = Data.getdescData(description_file_path);
		ArrayList<Column> verifData = Data.getverifData(descDtat, verification_file_path);
		ArrayList<Column> annonymData = Data.getAnnonymData(verifData, anonymisation_file_path);
		return annonymData;
	}
	
	public static void main(String[] args) {
		ArrayList<Column> list = new ArrayList<Column>();
		ArrayList<Column> data = Data.getAllColumnsInfo(list, "/home/kenza/Documents/Master1/Programmation-orientée-objet/Data_description.json",
				"/home/kenza/Documents/Master1/Programmation-orientée-objet/Data_to_Check.json", "/home/kenza/Documents/Master1/Programmation-orientée-objet/Data_to_anonymize.json");
	    
		System.out.println(data.get(0).name);
		
	   
}
}
