import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader {
	public static void read(String fileName, List<Double> list) throws FileNotFoundException{
		File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String line = new String("");
        while (true) {
        	line = scanner.nextLine();
        	if(line.equals("EXIT")) break;
        	list.add(Double.valueOf(line));
        }
        scanner.close();
	}
}
