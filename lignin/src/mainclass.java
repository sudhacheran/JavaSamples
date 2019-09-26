import java.util.ArrayList;
import java.util.List;

import com.polymergen.GeneratePolymer;

public class mainclass {
	

public static void main(String[] args) {
		
		int dp = 150;
		int noOfPer = 100;

		String[] str = { "B04", "BB", "55", "B5", "B1", "405" };
		int[] bondper = { 50, 10, 10, 10, 10, 10 };

		String[] mono = { "G", "H", "S" };
		int[] monoPer = { 50, 10, 40 };
		
		GeneratePolymer gp = new GeneratePolymer();
		List<String> polymentString = gp.getPossiblePolymer(str, bondper, mono, monoPer, dp,noOfPer);
		
		System.out.println(polymentString);
}


}