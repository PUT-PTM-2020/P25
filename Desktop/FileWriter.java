import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
	public static void write(String fileName, List<Double> list) throws FileNotFoundException{
		PrintWriter zapis = new PrintWriter(fileName);
		for(double x : list) {
			zapis.println(String.valueOf(x));
		}
		zapis.println("EXIT");
        zapis.close();
	}
}
