package dauphine.csvreadwrite;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
		String description_file_path = "/home/kenza/Documents/Master1/Programmation-orientée-objet/Data_description.json";
		String verification_file_path = "/home/kenza/Documents/Master1/Programmation-orientée-objet/Data_to_Check.json";
		String anonymisation_file_path = "/home/kenza/Documents/Master1/Programmation-orientée-objet/Data_to_anonymize.json";
		String input_file_path = "/home/kenza/Documents/Master1/Programmation-orientée-objet/file1.csv";
		String output_file_path = "/home/kenza/Documents/Master1/Programmation-orientée-objet/file2.csv";
		
		Verification.verification(input_file_path, output_file_path, description_file_path, verification_file_path, ";");
		Annonymization.annonymization(input_file_path, output_file_path, description_file_path, verification_file_path,anonymisation_file_path, ";");
	}
	
	
	
}
