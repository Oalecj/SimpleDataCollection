import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

public class CerealEater {
	public static void main(String[] args) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Load Cereal Types in File?",
				"CerealEater", dialogButton);
		if (dialogResult == 0) {
			try (FileInputStream fs = new FileInputStream("cereal.bin")) {
				ObjectInputStream oi = new ObjectInputStream(fs);
				Cereal[] cereal1 = (Cereal[])oi.readObject();
				//System.out.println(cereal1 + " and  " + cereal2);
				JOptionPane.showMessageDialog(null, "User likes " + cereal1[0] + " and  " + cereal1[1] + "\nbut does not like " + cereal1[2], "Cereal Types Loaded", 1);
				oi.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found: " + "cereal.bin", "Fatal error!", 2);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "File IO error: " + "cereal.bin", "Fatal error!", 2);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "ClassNotFound Error", "Fatal error!", 2);
				e.printStackTrace();
			}
		} else {
			System.exit(0);
		}
	}
}
