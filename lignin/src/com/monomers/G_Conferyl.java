package com.monomers;


import java.io.IOException;
import java.util.ArrayList;

import org.openscience.cdk.Atom;
import org.openscience.cdk.AtomContainer;
import org.openscience.cdk.Bond;
import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.config.Isotopes;
import org.openscience.cdk.depict.DepictionGenerator;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IMolecularFormula;
import org.openscience.cdk.layout.StructureDiagramGenerator;
import org.openscience.cdk.smiles.SmiFlavor;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.tools.manipulator.MolecularFormulaManipulator;




public class G_Conferyl {
	
	 IAtom o1,o2,o3,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12;
	 IAtom c1,c2,c3,c4,c5,c6,betaC,alphaC,gammaC,c7;
	 IBond b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17;
	 IAtomContainer mol;
	
	 String smile;
	 
	 public String getSmile() {
		return smile;
	}


	public void setSmile(String smile) {
		this.smile = smile;
	}


	public IAtomContainer getMol() {
		return mol;
	}


	public void setMol(IAtomContainer mol) {
		this.mol = mol;
	}

	ArrayList<IAtom> bondingAtom = new ArrayList<IAtom>();	 
	 
	 public G_Conferyl(int i)
	 {
		 c1 = new Atom(6);		 
		 c1.setAtomTypeName("c1_"+i);
		 
		 c2 = new Atom(6);
		 c2.setAtomTypeName("c2_"+i);

		 c3 = new Atom(6);
		 c3.setAtomTypeName("c3_"+i);

		 c4 = new Atom(6);
		 c4.setAtomTypeName("c4_"+i);

		 c5 = new Atom(6);
		 c5.setAtomTypeName("c5_"+i);

		 c6 = new Atom(6);
		 c6.setAtomTypeName("c6_"+i);
		 
		 c7 = new Atom(6);
		 c7.setAtomTypeName("c7_"+i);
		 

		 betaC = new Atom(6);
		 betaC.setAtomTypeName("bC_"+i);

		 alphaC = new Atom(6);
		 alphaC.setAtomTypeName("aC_"+i);

		 gammaC = new Atom(6);
		 gammaC.setAtomTypeName("gC_"+i);

		 o1 = new Atom(8);
		 o1.setAtomTypeName("O1_"+i);
		 o2 = new Atom(8);
		 o2.setAtomTypeName("O2_"+i);
		 o3 = new Atom(8);
		 o3.setAtomTypeName("O4_"+i);
		 //o4 = new Atom(8);
		 //o4.setAtomTypeName("O4_"+i);
		 
		 h1 = new Atom(1);
		 h1.setAtomTypeName("H1_"+i);
		 
		 h2 = new Atom(1);
		 h2.setAtomTypeName("H2_"+i);
		 h3 = new Atom(1);
		 h3.setAtomTypeName("H3_"+i);
		 h4 = new Atom(1);
		 h4.setAtomTypeName("H4_"+i);
		 
	    		 
		 b1= new Bond(c1,c2,IBond.Order.DOUBLE);
		 b2= new Bond(c2,c3);
		 b3= new Bond(c3,c4,IBond.Order.DOUBLE);
		 b4= new Bond(c4,c5);
		 b5= new Bond(c5,c6,IBond.Order.DOUBLE);
		 b6= new Bond(c1,c6);
		 b1.setProperty(CDKConstants.ISAROMATIC, true);
		 b2.setProperty(CDKConstants.ISAROMATIC, true);
		 b3.setProperty(CDKConstants.ISAROMATIC, true);
		 b4.setProperty(CDKConstants.ISAROMATIC, true);
		 b5.setProperty(CDKConstants.ISAROMATIC, true);
		 b6.setProperty(CDKConstants.ISAROMATIC, true);
		 
		 
		 b7= new Bond(c1,alphaC);		
		 b8= new Bond(alphaC,betaC,IBond.Order.DOUBLE);
		 b9= new Bond(betaC,gammaC);
		 b10 = new Bond(c4,o3); // Phenol oxygen
		 b11 = new Bond(gammaC,o1); //Gamma oxygen
		 b12 = new Bond(c3,o2); //Methoxy oxygen
		 b13 = new Bond(o2,c7);
		 b14 = new Bond(o1,h1); 
		 b15 = new Bond(c7,h3);
		 b16 = new Bond(c7,h2);
		 b17 = new Bond(c7,h4);
		
		 mol = new AtomContainer();
		 mol.addAtom(c1);
		 mol.addAtom(c2);
		 mol.addAtom(c3);
		 mol.addAtom(c4);
		 mol.addAtom(c5);
		 mol.addAtom(c6);		
		 mol.addAtom(alphaC);
		 mol.addAtom(betaC);
		 mol.addAtom(gammaC);
		 mol.addAtom(c7);
		 
		 mol.addAtom(o1);
		 mol.addAtom(o2);
		 mol.addAtom(o3);
		/* mol.addAtom(h1);
		 mol.addAtom(h2);
		 mol.addAtom(h3);
		 mol.addAtom(h4);*/
		 mol.addBond(b1);
		 mol.addBond(b2);
		 mol.addBond(b3);
		 mol.addBond(b4);
		 mol.addBond(b5);
		 mol.addBond(b6);
		 mol.addBond(b7);
		 mol.addBond(b8);
		 mol.addBond(b9);
		 mol.addBond(b10);
		 mol.addBond(b11);
		 mol.addBond(b12);
		 mol.addBond(b13);
		/* mol.addBond(b14);
		 mol.addBond(b15);
		 mol.addBond(b16);
		 mol.addBond(b17);*/
		 setBondingAtom(bondingAtom);
	 }

	 
	 public ArrayList<IAtom> getBondingAtom() {
		return bondingAtom;
	}
	 
	private void setBondingAtom(ArrayList<IAtom> bondingAtom) {
		bondingAtom = new ArrayList<IAtom>();
		bondingAtom.add(c4);
		bondingAtom.add(c5);
		bondingAtom.add(c1);
		bondingAtom.add(betaC);
		bondingAtom.add(alphaC);		
		this.bondingAtom = bondingAtom;
	}
	
	public static void main(String s[]) throws IOException
	{
		G_Conferyl g = new G_Conferyl(1);
		g.toIMage(100);
		System.out.println(getMolWt(g.getMol())+"-"+g.getSmile());
	}
	
	public static double getMolWt(IAtomContainer mol) throws IOException
	{
		Isotopes isotopeInfo = Isotopes.getInstance();
		double molWeight = 0.0;
		for (int i=0;i<mol.getAtomCount();i++) {
		  molWeight += isotopeInfo.getNaturalMass(mol.getAtom(i));
		}
		return Math.round(molWeight);
	}
	

	public void toIMage(int i)
	 {
		 try {
			 				
				StructureDiagramGenerator sdg = new StructureDiagramGenerator();
				sdg.generateCoordinates(mol);
				IAtomContainer OutMol = sdg.getMolecule();
				SmilesGenerator sg      = new SmilesGenerator(SmiFlavor.Absolute);
				String          smi     = sg.create(OutMol);
				this.setSmile(smi);
				
				IMolecularFormula moleFormula = MolecularFormulaManipulator.getMolecularFormula(OutMol);
				System.out.println(MolecularFormulaManipulator.getHillString(moleFormula));
						
			new DepictionGenerator().withAtomColors().withCarbonSymbols().withAtomNumbers().depict(OutMol)
			          .writeTo("struct/g"+i+".png");
		
			
		} catch (IOException | CDKException e) {
			
			e.printStackTrace();
		}
	 }
}
