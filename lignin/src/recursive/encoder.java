package recursive;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encoder {
	
	 //Inputs 
	static String[] bonds = { "B04", "55", "B5","A04","BB" }; // Bonds possible
	static int[] bondper = { 35, 25, 10, 25, 5 };  // Ratio of the bonds

	static String[] mono = { "G", "H", "S" }; // Monomer units
	static int[] monoPer = {35, 30, 35 }; // Ratio of the units
	
	static int dp =15; // No of monomer units
		
	public Object encode(Edges ed,monolignol l1, monolignol l2)
	{		
		if (checkID(l1.getBondl(),l2.objId) && checkID(l1.getBond2(),l2.objId) && checkID(l1.getBond3(),l2.objId))
		{	
			if (l1.getBondl() == null)
			{
				l1.setBondl(l2);
			}
			else
				if (l1.getBond2() == null)
				{
					l1.setBond2(l2);
				}
			else if (l1.getBond3() == null) 
			{
				l1.setBond3(l2);
			}		
	
			if (!isFilled (l1.objId, ed))
			{
				l1 = getEdgeType(ed,l1);		
				if (l1.isEdgUpdated)
				{
					ed.getpNode().add(l1.objId);
					ed.getcNode().add(l2.objId);				
					ed.setEdWgt(l1.getEdWgt());	
					ed.setMonoL(l1);		
				}
			}		
		}
		return ed;			
	}
	public static void main(String s[])
	{
		ArrayList<monolignol> monoList = new ArrayList<monolignol>();
		encoder en = new encoder();
		String[] monoArr = getList(mono, monoPer, dp);
		for(int i=0;i<dp;i++)
		{
			monolignol m1 = new monolignol(monoArr[i]);			
			monoList.add(m1);     
		}		
		ArrayList<Integer> getSeq = Combination.printCombination(dp);		
		Edges edg = new Edges();
		String[] bondArr = getList(bonds, bondper, getSeq.size()/2);
		ArrayList<String> bondList = new ArrayList<String>();
		for(int i=0;i<bondArr.length;i++)
		{
			bondList.add(bondArr[i]);
		}
		edg.setEdWgt(bondList);
		for (int i=0;i<getSeq.size();i+=2)
		{
			edg = (Edges) en.encode(edg, monoList.get(getSeq.get(i)-1),monoList.get(getSeq.get(i+1)-1));
			monoList.set(getSeq.get(i)-1,(monolignol) edg.getMonoL());						
		}			
		ArrayList<Integer> edgWtIn = new ArrayList<Integer>();
		for(monolignol mono: monoList)
		{			
			String[] ed= mono.getEdgeType();
			boolean setVal = false;
			for(int c=0;c<ed.length;c++)
			{
				setVal = false;
				for(int k=0;k<bonds.length;k++)
				{
					if (!setVal && ed[c]!=null && ed[c].equals(bonds[k]))
					{
						edgWtIn.add(k+1);
						setVal = true;
					}
				}
			}
		}
		edg.setEdgWgtIn(edgWtIn);
		sop(edg);	
		try {
		PrintWriter writer;		
		writer = new PrintWriter("DataSet.txt", "UTF-8");		
		writer.println("Vertex\tMonomer\tConnections\tBond-type\tLabel-index");
		int oldNode=0;
		for(int i=0;i<edg.getpNode().size();i++)
		{
			int nodeId = edg.getpNode().get(i);
			monolignol monomer = monoList.get(nodeId-1);
			monolignol child1 = monomer.getBondl();
			monolignol child2 = monomer.getBond2();
			monolignol child3 = monomer.getBond3();
			String nodeType = monomer.getType();
			String connection1 = (child1 == null)?"-1":""+child1.objId;
			String connection2 = (child2 == null)?"-1":""+child2.objId;
			String connection3 = (child3 == null)?"-1":""+child3.objId;
			String bondtype ="";
			int lbl = monomer.lbl.getIndex();
			for (int b=0;b<monomer.getEdgeType().length;b++)
				if (monomer.getEdgeType()!=null && monomer.getEdgeType()[b] != null)
				{
					List<String> bndL = Arrays.asList(bonds);
					bondtype = bondtype.concat(" "+(bndL.indexOf(monomer.getEdgeType()[b])+1)).concat(" ");
				}
	
			if (nodeId!= oldNode)
			{
				writer.println(nodeId+"#\t\t"+nodeType+"\t\t"+connection1+"\t"+connection2+"\t"+connection3+"\t"+bondtype+"\t\t"+lbl);
				oldNode = nodeId;
			}
		}
		oldNode=0;
		for(int i=0;i<edg.getcNode().size();i++)			
		{
			int nodeId = edg.getcNode().get(i);
			monolignol monomer = monoList.get(nodeId-1);
			monolignol child1 = monomer.getBondl();
			monolignol child2 = monomer.getBond2();
			monolignol child3 = monomer.getBond3();
			String nodeType = monomer.getType();
			String connection1 = (child1 == null)?"-1":""+child1.objId;
			String connection2 = (child2 == null)?"-1":""+child2.objId;
			String connection3 = (child3 == null)?"-1":""+child3.objId;
			String bondtype ="";
			for (int b=0;b<monomer.getEdgeType().length;b++)
				if (monomer.getEdgeType()!=null && monomer.getEdgeType()[b] != null)
				{
					List<String> bndL = Arrays.asList(bonds);
					bondtype = bondtype.concat(" "+(bndL.indexOf(monomer.getEdgeType()[b])+1)).concat(" ");
				}				
			
			int lbl = monomer.lbl.getIndex();
			ArrayList<Integer> pNodeList = edg.getpNode();
			
			if (!pNodeList.contains(nodeId))
			{
				if (nodeId!= oldNode)
				{
					writer.println(nodeId+"#\t\t"+nodeType+"\t\t"+connection1+"\t"+connection2+"\t"+connection3+"\t"+bondtype+"\t\t"+lbl);
					oldNode = nodeId;
				}
			}
		}		
		writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
	}
	
	static boolean checkID(monolignol obj, int id2)
	{	
		if (obj==null || obj.objId != id2)
		{
			return true;
		}
		return false;
	}
	
	static boolean isFilled(int id,Edges ed)
	{
		boolean isfill=false;
		int cnt=0;
		for(int pVer:ed.getpNode())
		{
			if (id == pVer)
			{
				cnt++;
			}
		}		
		if (cnt >= 3) isfill = true;
		return isfill;
	}
	
	static void sop(Object s)
	{
		System.out.println(s);
	}
	
	
	
	static String[] getList(String[] str, int[] bondper, int dp) {
		
		String[] strBonds = new String[dp];
		int[] totcnt = new int[str.length];
		// initializing the totcount[] for each bond with 1  
		for(int inc=0; inc < totcnt.length; inc++)
		{
			totcnt[inc]+=1;
		}
		// Loop to create the possible bond names (or) monomer names with the dp count
		int cnt = 0;
		boolean brkLoop = false;
		while (!brkLoop) {
			for (int j = 0; j < str.length; j++) {
				double cal = calPer(bondper[j], dp);		
				if (cal > 0 && totcnt[j] <= cal ) {						
					strBonds[cnt++] = str[j];	
					totcnt[j] = totcnt[j]+1;	
				}
			}
			brkLoop = true;
			for (int j = 0; j < str.length; j++) {
				double cal = calPer(bondper[j], dp);		
				if (cal > 0 && totcnt[j] <= cal) {	
					brkLoop = false;
				}				
			}
		}
		//Loop to add bonds at the end for chain length
		while (cnt < dp)
		{
			for (int k=0;k<str.length;k++)
	      	 {
	            if (cnt >= dp)
	            {
	              break;
	            }
	            strBonds[cnt++]=str[k];
	         }
		}				
		return strBonds;
	}
	
	static double calPer(int val, int dp) {
		if (val == 0)
			return val;
		double flrval = dp * (val / 100f);		
		return ((flrval > 0.5) ? Math.floor(flrval) : 0);
	}
	
	static monolignol getEdgeType(Edges ed, monolignol m1)
	{	
		
		m1.isEdgUpdated = false;
		ArrayList<String> edgArr = ed.getEdWgt();
		String c[]=new String[3];
	    List<String> newEdg = Arrays.asList(m1.getEdgeType());
	    int cnt=0;
	    for(String s: newEdg)
	    {
	    	if (s!=null)
	    	c[cnt++] = ""+s.charAt(0);
	    }	    
		for(int k=0;k<m1.getEdgeType().length;k++)
		{	 
			  for (int j=0;j<edgArr.size();j++) 
			  {
				  String oldegd = edgArr.get(j);
				  String oldC = ""+oldegd.charAt(0);
				  if (!Arrays.asList(m1.getEdgeType()).contains(edgArr.get(j)) && !Arrays.asList(c).contains(oldC))
				  {			
					  if (m1.getEdgeType()[k]==null || m1.getEdgeType()[k].isEmpty())
					  {
						
						  m1.getEdgeType()[k]= edgArr.get(j);
						  edgArr.remove(edgArr.get(j));						  
						  m1.setEdWgt(edgArr);		
						  m1.isEdgUpdated = true;					 				 
						  return m1;
					  }
				  }			  
			  }			 
		  }
		return m1;				
	}
	
	
}
