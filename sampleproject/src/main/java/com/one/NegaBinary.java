package com.one;

import java.util.ArrayList;

class NegaBinary 
{
    public static int[] solution (int[] A) 
    {
       //Looping through Array A to find the decimal number
        int sumd=0;
              
        for (int i=0;i<=A.length-1;i++)
        {
            sumd += A[i]* Math.pow(-2, i);            
        }
        
        ArrayList<Integer> Arr = new ArrayList<Integer>();
        int divS = -1* sumd;
        while (divS != 0)
        {
        	int remS = divS%(-2);
        	divS /= -2;
        	if (remS < 0)
        	{
        		remS +=2;
        		divS +=1;
        	}
        	Arr.add(remS);
        	
        }      
        int[] k = new int[Arr.size()];
        Object[] obj = Arr.toArray();
        for (int i=0;i<k.length; i++)
		{	
        	k[i] = (int) obj[i];
		}
       
        return k;
    }
    
    
    
    
    
    
}