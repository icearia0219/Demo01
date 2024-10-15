import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectOriented {
    private ArrayList<String> lines = new ArrayList<>();

    // 读取文件
    public void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取文件行数据
    public ArrayList<String> getLines() {
        return lines;
    }

    // 转换为小写
    public ArrayList<String> convertToLowerCase() {
        ArrayList<String> lowerCaseLines = new ArrayList<>();
        for (String line : lines) {
            lowerCaseLines.add(line.toLowerCase());
        }
        return lowerCaseLines;
    }
}
