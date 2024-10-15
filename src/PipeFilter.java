import java.util.ArrayList;

public class PipeFilter {

    public ArrayList<String> process(ArrayList<String> inputLines) {
        ArrayList<String> filteredLines = new ArrayList<>();
        for (String line : inputLines) {
            filteredLines.add(line.toLowerCase());
        }
        return filteredLines;
    }
}
