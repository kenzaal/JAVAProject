package dauphine.csvreadwrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
/**
 * Cette classe permet de récupérer toutes les informations relatives au colonnes 
 * à partir des fichiers Json.
 * 
 * @author Kenza SAAL
 */
public class Data {
	
	
	/**
	 * Affiche les informations d'une colonne
	 * @param: liste de colonnes  
	 */
	public static void printListColumn(ArrayList<Column> data) {
		for(Column e: data)
			System.out.println(e.toString());
	}

	/**
	 * Initialise et atribue nom et type aux colonnes 
	 * @param: chemin du fichier json 
	 */
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
	
	
	/**
	 * obtenir les règles de vérification.
	 * aléatoire
	 * 
	 * @param: JsonArray extrait d'un fichier json
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> getVerificationRules(JsonArray l) {
		ArrayList<String> ar = new ArrayList<String>();
		for(JsonElement e: l) {
			ar.add(e.getAsString().replaceAll("\"","")); 
		}
		return ar;

	}
	
	
	/**
	 * Ajouter les régles de vérification au attributs de colonne. 
	 * 
	 * @param ArrayList<Column> list de colonne
	 * @param String
	 * @return ArrayList<Column> list de colonne avec l'attribut "verificationRules" modifié.
	 * 
	 */
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
	
	/**
	 * Ajouter la régle d'annonymisation au attributs de colonne. 
	 * 
	 * @param ArrayList<Column> list de colonne
	 * @param String
	 * @return ArrayList<Column> list de colonne avec l'attribut "annonymizationRule" modifié.
	 * 
	 */
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
	/**
	 * Renvoie un tableau de Column qui contient toutes les informations relatives au colonnes 
	 * à partir des fichiers Json.
	 */
	public static ArrayList<Column> getAllColumnsInfo(String description_file_path, String verification_file_path, String anonymisation_file_path)  {
		ArrayList<Column> descDtat = Data.getdescData(description_file_path);
		ArrayList<Column> verifData = Data.getverifData(descDtat, verification_file_path);
		ArrayList<Column> annonymData = Data.getAnnonymData(verifData, anonymisation_file_path);
		return annonymData;
	}
	
}
