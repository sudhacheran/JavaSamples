package struct;

import java.util.List;

enum BLOC 
{ 
    BetaC, AlphaC, C5, CO4; 
}

public class monoLig {
	
	static int id=0;
	String Node ="";
	boolean betaC=false;
	boolean alphaC=false;
	boolean C4O=false;
	boolean C5=false;
	monoLig(String cNode)
	{
		id = id++;
		Node = cNode;
	}	
	List<Bonds> bonds;
	
	
	
	
	
}

class Bonds
{
	monoLig m1;
	BLOC bond;
	Bonds(monoLig m1, BLOC bond)
	{
		this.m1 = m1;
		this.bond = bond;
	}
}





