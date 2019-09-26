package construct;
import javax.swing.JOptionPane;
public class GUI {
	public static void main(String[] args) {
		String dp;
		int n1;
		try {
			dp = JOptionPane.showInputDialog("Enter the dp (2-7)");		
			n1 = Integer.parseInt(dp);
			testclass.runData(n1);
			JOptionPane.showMessageDialog(null, "Datafile & Images generated! \nFileName: DataSet.txt\nImage Folder: struct\\" , "Results", JOptionPane.PLAIN_MESSAGE );
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Enter value between 2 to 7 for DP \nPlease execute again" , "Error", JOptionPane.PLAIN_MESSAGE );
		}
		System.exit(0);		
	}
}