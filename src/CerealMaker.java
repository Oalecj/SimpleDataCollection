import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

class CerealMaker {
	public static void main(String[] args) {
		// Get variables to write to file!
		String name1 = JOptionPane
				.showInputDialog("Enter the name of a cereal you like!");
		String name2 = JOptionPane
				.showInputDialog("Enter the name of another cereal you like!");
		String name3 = JOptionPane
				.showInputDialog("Enter the name of another cereal you don't like!");
		// What file to write to?
		String file = (JOptionPane
				.showInputDialog("Name of file to write info? (Don't type .bin)") + ".bin");
		// Initialize array!
		Cereal[] cereals = { new Cereal(name1, true), new Cereal(name2, true),
				new Cereal(name3, true) };
		// Try ---> Catch
		try (FileOutputStream neti = new FileOutputStream(file)) {
			ObjectOutputStream os = new ObjectOutputStream(neti);
			// Write the array!
			os.writeObject(cereals);
			// Close ObjectOutputStream!
			os.close();
			// Tell the user the process was a success!
			JOptionPane.showMessageDialog(null, "Saved output to " + file,
					"SUCCESS!", 1);
		} catch (FileNotFoundException e) {
			//File can't be created!
			JOptionPane.showMessageDialog(null, "File not found: " + file,
					"Fatal error!", 2);
			e.printStackTrace();
		} catch (IOException e) {
			//Possible permissions fail?
			JOptionPane.showMessageDialog(null, "File IO error: " + file,
					"Fatal error!", 2);
			e.printStackTrace();
		}

	}
}
