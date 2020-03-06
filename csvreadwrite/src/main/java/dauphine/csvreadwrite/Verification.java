package dauphine.csvreadwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Verification {
	
	
	public static void verification(String inputCsvFile, String outputCsvFile, String description_file_path, String verification_file_path, String sep) throws Exception {
        BufferedReader br = null;
        String line = "";
       
        
        ArrayList<Column> dataDescription = Data.getdescData(verification_file_path);
        ArrayList<Column> dataToCheck = Data.getverifData(dataDescription, verification_file_path);
        int nb_column = dataToCheck.size();
        
        File dataOUT = new File(outputCsvFile);
		FileWriter fw = new FileWriter(dataOUT);
		BufferedWriter bw = new BufferedWriter(fw);

        try {

            br = new BufferedReader(new FileReader(inputCsvFile));
            while ((line = br.readLine()) != null) {
            	boolean valide = false;
                String[] colomns = line.split(sep);

                //do the verifications
                for(int i = 0; i < nb_column; i ++) {
                	String col = colomns[i];
                	String expected_type = dataToCheck.get(i).type;
                	ArrayList<String> verifRule = dataToCheck.get(i).verificationRules;
                	if(DescriptionRules.compare_type(expected_type, col)) {
                		if(VerificationRules.check(verifRule, col)) {
                			valide = true;
                		}
                	}
                }
                if(valide) {
                	bw.write(line);
					bw.write("\n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    bw.close();
					fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}
	
	
}
