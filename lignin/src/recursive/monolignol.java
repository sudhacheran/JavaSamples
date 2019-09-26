package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class monolignol {
	static int NoOfBond = 3;
	static int id=0;
	String type;
	monolignol bondl;
	monolignol bond2;
	monolignol bond3;
	int objId;	
	String[] edgeType = new String[5];
	ArrayList<String> edWgt= new ArrayList<String>();
	Labels lbl;
	boolean isEdgUpdated = false;	
		
	public monolignol(String type) {
		super();
		this.type = type;
		this.objId = ++id;	
		lbl = new Labels(this.objId,this.type);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public monolignol getBondl() {
		return bondl;
	}
	public void setBondl(monolignol bondl) {
		if (bondl != null) 
		this.bondl = bondl;
	}
	public monolignol getBond2() {
		
		return bond2;
	}
	public void setBond2(monolignol bond2) {
		if (bond2 != null) 
		this.bond2 = bond2;
	}
	public monolignol getBond3() {
		return bond3;
	}
	public void setBond3(monolignol bond3) {
		if (bond3 != null) 
		this.bond3 = bond3;
	}
	
	public ArrayList<String> getEdWgt() {
		return edWgt;
	}
	public void setEdWgt(ArrayList<String> edWgt) {
		this.edWgt = edWgt;
	}
	public String[] getEdgeType() {
		return edgeType;
	}
	public void setEdgeType(String[] edgeType) {
		this.edgeType = edgeType;
	}
	@Override
	public String toString() {
		return "monolignol [type=" + type + ", bondl=" + bondl + ", bond2=" + bond2 + ", bond3=" + bond3 + ", objId="
				+ objId + ", edgeType=" + Arrays.toString(edgeType) + ", lbl=" + lbl + "]\n";
	}
		 

}


