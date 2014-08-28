import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

public class CerealEater {
	public static void main(String[] args) {
		//What file should I load from?
		String file = (JOptionPane.showInputDialog("What file should I load from? (Don't type .bin)") + ".bin");
			try (FileInputStream fs = new FileInputStream(file)) {
				ObjectInputStream oi = new ObjectInputStream(fs);
				Cereal[] cereal1 = (Cereal[])oi.readObject();
				//System.out.println(cereal1 + " and  " + cereal2);
				JOptionPane.showMessageDialog(null, "User likes " + cereal1[0] + " and  " + cereal1[1] + "\nbut does not like " + cereal1[2], "Cereal Types Loaded", 1);
				oi.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found: " + file, "Fatal error!", 2);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "File IO error: " + file, "Fatal error!", 2);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "ClassNotFound Error", "Fatal error!", 2);
				e.printStackTrace();
			}
	}
}
