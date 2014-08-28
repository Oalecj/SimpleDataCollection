import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

class CerealMaker {
	public static void main(String[] args) {
		String name1 = JOptionPane.showInputDialog("Enter the name of a cereal you like!");
		String name2 = JOptionPane.showInputDialog("Enter the name of another cereal you like!");
		String name3 = JOptionPane.showInputDialog("Enter the name of another cereal you don't like!");
		String file = "cereal.bin";
		Cereal[] cereals = {new Cereal(name1, true), new Cereal(name2, true), new Cereal(name3, true)};
		try(FileOutputStream netflix = new FileOutputStream(file)) {
			ObjectOutputStream os = new ObjectOutputStream(netflix);
			os.writeObject(cereals);
			os.close();
		JOptionPane.showMessageDialog(null, "Saved output to cereal.bin", "SUCCESS!", 1);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found: " + file, "Fatal error!", 2);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File IO error: " + file, "Fatal error!", 2);
			e.printStackTrace();
		}
		
	}
}
