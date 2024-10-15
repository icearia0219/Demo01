import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainProgramSubprogram {

    public ArrayList<String> process(String filePath) {
        ArrayList<String> lines = readFile(filePath);
        return convertToLowerCase(lines);
    }

    private ArrayList<String> readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private ArrayList<String> convertToLowerCase(ArrayList<String> lines) {
        ArrayList<String> lowerCaseLines = new ArrayList<>();
        for (String line : lines) {
            lowerCaseLines.add(line.toLowerCase());
        }
        return lowerCaseLines;
    }
}
