package recursive;

import java.util.ArrayList;

public class Edges {
	
	ArrayList<Integer> pNode= new ArrayList<Integer>();
	ArrayList<Integer> cNode= new ArrayList<Integer>();
	ArrayList<String> edWgt= new ArrayList<String>();
	ArrayList<Integer> edgWgtIn= new ArrayList<Integer>();
	Object monoL = new Object();
	
	
	
	public Object getMonoL() {
		return monoL;
	}
	public void setMonoL(Object monoL) {
		this.monoL = monoL;
	}
	public ArrayList<Integer> getpNode() {
		return pNode;
	}
	public void setpNode(ArrayList<Integer> pNode) {
		this.pNode = pNode;
	}
	public ArrayList<Integer> getcNode() {
		return cNode;
	}
	public void setcNode(ArrayList<Integer> cNode) {
		this.cNode = cNode;
	}
	
	public ArrayList<String> getEdWgt() {
		return edWgt;
	}
	public void setEdWgt(ArrayList<String> edWgt) {
		this.edWgt = edWgt;
	}
	
	
	public ArrayList<Integer> getEdgWgtIn() {
		return edgWgtIn;
	}
	public void setEdgWgtIn(ArrayList<Integer> edgWgtIn) {
		this.edgWgtIn = edgWgtIn;
	}
	@Override
	public String toString() {
		return "Edges [pNode=" + pNode + ", cNode=" + cNode + ", edgWgtIn=" + edgWgtIn + "]";
	}
		
	
	

}
