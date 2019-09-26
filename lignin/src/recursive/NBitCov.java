package recursive;
import java.util.*;
public class NBitCov {

	int[] arrA;
	ArrayList<int[]> IndexArr; 
	int i=0;

	public ArrayList<int[]> getArrA() {		
		return IndexArr;
	}

	public NBitCov(int n) {
		arrA = new int[n];
		IndexArr = new ArrayList<int[]>();
	}
	
	public void nBits(int n) {
		if (n <= 0) {
			IndexArr.add(arrA);
		} else {
			arrA[n - 1] = 0;
			nBits(n - 1);
			arrA[n - 1] = 1;
			nBits(n - 1);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int n = 2;
		NBitCov i = new NBitCov(n);
		i.nBits(n);		
		
	}
}