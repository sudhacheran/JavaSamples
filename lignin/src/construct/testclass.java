package construct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openscience.cdk.Bond;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IBond;

import com.monomers.G_Conferyl;

import construct.Lignin;
import construct.childNode;
import construct.encodercopy;

public class testclass {
	
	public static void main(String s[]) throws IOException
	{
		runData(4);
	}
	
	public static void runData(int dp) throws IOException
	{
		Date dt = new Date();
		List<Lignin> ligninList = encodercopy.generateEncodedFile(dp);
		System.out.println(ligninList);
		int i=0;
		for (Lignin lignin:ligninList)
		{
			if(lignin.getPType().contains("G"))
			{
				G_Conferyl g = new G_Conferyl(1);
				List<Integer> cc = new ArrayList<Integer>(); 
				List<childNode> cNList = lignin.getcNode();	
				for (childNode cN: cNList)
				{
					 //Child object initialization
					int gp = Integer.parseInt(""+cN.getpType().charAt(0));
					int gc = Integer.parseInt(""+cN.getcType().charAt(0));
					if (cN.getpType().equals(lignin.getPType()))
					{
						if(cN.getcType().contains("G"))
						{
							cc.add(gc);
							//System.out.println("Entered 1");
							G_Conferyl g2 = new G_Conferyl(gc);							
							if (cN.getBondType().equals("B04"))
								g = generateStruct (g,g2,"bC_1","O4_"+gc);
							else if (cN.getBondType().equals("BB"))
								g = generateStruct (g,g2,"bC_1","bC_"+gc);
							else if (cN.getBondType().equals("55"))
								g = generateStruct (g,g2,"c5_1","c5_"+gc);
							else if (cN.getBondType().equals("A04"))
								g = generateStruct (g,g2,"aC_1","O4_"+gc);
							else if (cN.getBondType().equals("B5"))
								g = generateStruct (g,g2,"bC_1","c5_"+gc);
						}					
					}
					else 
					{	
						//System.out.println("gc="+gp+"gc="+gc+"cc="+cc);
						if (cc.contains(gp) && cc.contains(gc))
						{	
							//System.out.println("Entered 2");
							if (cN.getBondType().equals("B04"))
								g = generateStruct (g,"bC_"+gp,"O4_"+gc);
							else if (cN.getBondType().equals("BB"))
								g = generateStruct (g,"bC_"+gp,"bC_"+gc);
							else if (cN.getBondType().equals("55"))
								g = generateStruct (g,"c5_"+gp,"c5_"+gc);
							else if (cN.getBondType().equals("A04"))
								g = generateStruct (g,"aC_"+gp,"O4_"+gc);
							else if (cN.getBondType().equals("B5"))
								g = generateStruct (g,"bC_"+gp,"c5_"+gc);							
						}	
						else if (!cc.contains(gc))
						{
							cc.add(gc);							
							G_Conferyl g2 = new G_Conferyl(gc);
							//System.out.println("Entered 3");
							if (cN.getBondType().equals("B04"))
								g = generateStruct (g,g2,"bC_"+gp,"O4_"+gc);
							else if (cN.getBondType().equals("BB"))
								g = generateStruct (g,g2,"bC_"+gp,"bC_"+gc);
							else if (cN.getBondType().equals("55"))
								g = generateStruct (g,g2,"c5_"+gp,"c5_"+gc);
							else if (cN.getBondType().equals("A04"))
								g = generateStruct (g,g2,"aC_"+gp,"O4_"+gc);
							else if (cN.getBondType().equals("B5"))
								g = generateStruct (g,g2,"bC_"+gp,"c5_"+gc);
						}	
					}
				}
				g.toIMage(i++);
				
				System.out.println("Lignin="+i+",MolWt="+G_Conferyl.getMolWt(g.getMol())+"Struct="+lignin+"SMILEString="+g.getSmile());
			}			
		}
		Date dt2 = new Date();		
		System.out.println("Time taken="+ getDifference(dt,dt2));
		
	}
	
	static G_Conferyl generateStruct(G_Conferyl g, G_Conferyl g2, String b1, String b2)
	{
		IAtomContainer g1_mol = g.getMol();		
		IAtomContainer g2_mol = g2.getMol();
		IAtom atm1 = null, atm2 = null, atm3=null;
		
		for (int i=0;i<g1_mol.getAtomCount();i++)
		{
			if (g1_mol.getAtom(i).getAtomTypeName()!=null  && g1_mol.getAtom(i).getAtomTypeName().equals(b1))
			{
				atm1 = 	g1_mol.getAtom(i);				
				if (i>1)
				{
					atm3 = g1_mol.getAtom(i-1);					
					IBond bnd2 = g1_mol.getBond(atm3, atm1);
					if (bnd2!=null && bnd2.getOrder().equals(IBond.Order.DOUBLE))
					{
						bnd2.setOrder(IBond.Order.SINGLE);
					}
				}
			}
		}
		
		for (int i=0;i<g2_mol.getAtomCount();i++)
		{
			if (g2_mol.getAtom(i).getAtomTypeName()!= null && g2_mol.getAtom(i).getAtomTypeName().equals(b2))
				atm2 = 	g2_mol.getAtom(i);
			g1_mol.addAtom(g2_mol.getAtom(i));			
		}
		
		for (int i=0;i<g2_mol.getBondCount();i++)
		{
			g1_mol.addBond(g2_mol.getBond(i));			
		} 
		IBond bnd = new Bond(atm1,atm2);
		g1_mol.addBond(bnd);
		return g;
	}
	
	static G_Conferyl generateStruct(G_Conferyl g, String b1, String b2)
	{
		IAtomContainer g1_mol = g.getMol();		
		IAtom atm1 = null, atm2 = null, atm3=null;
		
		for (int i=0;i<g1_mol.getAtomCount();i++)
		{
			if (g1_mol.getAtom(i).getAtomTypeName()!=null  && g1_mol.getAtom(i).getAtomTypeName().equals(b1))
			{
				atm1 = 	g1_mol.getAtom(i);	
				//System.out.println(b1+"-"+atm1.getAtomTypeName());
				if (i>1)
				{
					atm3 = g1_mol.getAtom(i-1);					
					IBond bnd2 = g1_mol.getBond(atm3, atm1);
					if (bnd2!=null && bnd2.getOrder().equals(IBond.Order.DOUBLE))
					{
						bnd2.setOrder(IBond.Order.SINGLE);
					}
				}
			}			
		}
		
		for (int i=0;i<g1_mol.getAtomCount();i++)
		{
			if (g1_mol.getAtom(i).getAtomTypeName()!= null && g1_mol.getAtom(i).getAtomTypeName().equals(b2))
			{
				atm2 = 	g1_mol.getAtom(i);
				//System.out.println(b2+"-"+atm2.getAtomTypeName());				
			}
						
		}	
		IBond bnd = new Bond(atm1,atm2);
		g.getMol().addBond(bnd);
		
		return g;
	}
	
	 private static String getDifference(Date d1, Date d2) 
	 {
			String result = null;
			/** in milliseconds */
			long diff = d2.getTime() - d1.getTime();
			/** remove the milliseconds part */
			diff = diff / 1000;
			//long days = diff / (24 * 60 * 60);
			long hours = diff / (60 * 60) % 24;
			long minutes = diff / 60 % 60;
			long seconds = diff % 60;
			result = hours+":"+minutes+":"+seconds;
			return result;
	 }
}
