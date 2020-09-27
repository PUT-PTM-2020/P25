import java.util.ArrayList;
import java.util.List;

public class DataCointaner {
	public static List<Double> data = new ArrayList<>();
	public static void readTemp() {
		data.clear();
		try {
		FileReader.read("temp.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeTemp() {
		
		try {
			FileWriter.write("temp.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void readHum() {
		data.clear();
		try {
		FileReader.read("hum.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeHum() {
		try {
			FileWriter.write("hum.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void readPre() {
		data.clear();
		try {
		FileReader.read("pre.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writePre() {
		try {
			FileWriter.write("pre.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void readAir() {
		data.clear();
		try {
		FileReader.read("air.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeAir() {
		try {
			FileWriter.write("air.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void readHgh() {
		data.clear();
		try {
		FileReader.read("hgh.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeHgh() {
		try {
			FileWriter.write("hgh.wth", data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
