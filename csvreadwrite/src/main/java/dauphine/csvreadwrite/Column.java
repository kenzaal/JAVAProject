package dauphine.csvreadwrite;

import java.util.ArrayList;

public class Column {
	String name;
	String type;
	ArrayList<String> verificationRules;
	String anonymisationRule;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getAnonymisationRule() {
		return anonymisationRule;
	}
	
	public void setVerificationRules(ArrayList<String> verificationRules) {
		this.verificationRules = verificationRules;
	}
	
	public void setAnonymisationRule(String anonymisationRule) {
		this.anonymisationRule = anonymisationRule;
	}
	
	public ArrayList<String> getVerificationRules() {
		return verificationRules;
	}
	
	@Override
	public String toString() {
		
		return this.name;
	}
	
}