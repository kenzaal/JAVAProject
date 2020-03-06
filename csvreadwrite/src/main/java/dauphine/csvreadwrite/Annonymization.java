package dauphine.csvreadwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Annonymization {

	public static void annonymization(String inputCsvFile, String outputCsvFile, String description_file_path,
			String verification_file_path, String anonymisation_file_path, String sep) throws Exception {
		BufferedReader br = null;
		String line = "";

		ArrayList<Column> data = Data.getAllColumnsInfo(description_file_path, verification_file_path,
				anonymisation_file_path);
		int nb_column = data.size();

		File dataOUT = new File(outputCsvFile);
		FileWriter fw = new FileWriter(dataOUT);
		BufferedWriter bw = new BufferedWriter(fw);

		try {

			br = new BufferedReader(new FileReader(inputCsvFile));
			while ((line = br.readLine()) != null) {
				boolean valide = false;
				String lineToWrite = "";
				String[] colomns = line.split(sep);

				// do the annonymisation
				for (int i = 0; i < nb_column; i++) {
					String col = colomns[i];
					String expected_type = data.get(i).type;
					String changeTo = data.get(i).getAnonymisationRule();
					if (DescriptionRules.compare_type(expected_type, col)) {
						valide = true;
						if (changeTo != null) {
							if (changeTo.equals("RANDOM_LETTER")) {
								lineToWrite.concat(AnonymizationRules.rondomLetter(col));
							}
							if (changeTo.equals("RANDOM_LETTER_FOR_LOCAL_PART")) {
								lineToWrite.concat(AnonymizationRules.randomLetterForRandomPart(col));
							}
						}
						lineToWrite.concat(col);
					}
				}
				if (valide) {
					bw.write(lineToWrite);
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
