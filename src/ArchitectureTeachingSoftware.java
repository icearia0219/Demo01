import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class ArchitectureTeachingSoftware extends Application {

    private ComboBox<String> architectureComboBox;
    private TextArea resultArea;
    private File selectedFile;
    private TextArea infoArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("经典软件体系结构教学软件");

        // 创建布局
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // 创建选择体系结构的下拉菜单
        Label label = new Label("选择体系结构风格：");
        grid.add(label, 0, 0);

        architectureComboBox = new ComboBox<>();
        architectureComboBox.getItems().addAll("主程序-子程序", "面向对象", "事件系统", "管道-过滤器");
        grid.add(architectureComboBox, 1, 0);

        // 文件选择按钮
        Button fileButton = new Button("选择文件");
        grid.add(fileButton, 0, 1);

        // 处理按钮
        Button processButton = new Button("处理");
        grid.add(processButton, 1, 1);

        // 文件选择逻辑
        fileButton.setOnAction(e -> handleFileSelection());

        // 处理按钮逻辑
        processButton.setOnAction(e -> handleProcess());

        // 结果显示区域
        resultArea = new TextArea();
        resultArea.setPrefHeight(200);
        resultArea.setPrefWidth(400);
        grid.add(resultArea, 0, 2, 2, 1);

        // 信息显示区域，用于展示文字说明、代码结构
        infoArea = new TextArea();
        infoArea.setPrefHeight(150);
        infoArea.setPrefWidth(400);
        grid.add(infoArea, 0, 3, 2, 1);

        // 设置场景
        Scene scene = new Scene(grid, 600, 500); // 调整窗口高度以容纳更多内容
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleFileSelection() {
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            resultArea.appendText("已选择文件: " + selectedFile.getName() + "\n");
        }
    }

    private void handleProcess() {
        String selectedArchitecture = architectureComboBox.getValue();
        if (selectedFile == null || selectedArchitecture == null) {
            resultArea.appendText("请先选择文件并选择体系结构风格\n");
            return;
        }

        switch (selectedArchitecture) {
            case "主程序-子程序":
                handleMainProgramSubprogram();
                break;
            case "面向对象":
                handleObjectOriented();
                break;
            case "事件系统":
                handleEventSystem();
                break;
            case "管道-过滤器":
                handlePipeFilter();
                break;
        }
    }

    private void handleMainProgramSubprogram() {
        // 处理逻辑并显示文字说明、代码结构
        displayInfo(
            "主程序-子程序架构:\n主程序控制整个流程，通过调用不同的子程序完成任务。适合任务流程明确、顺序执行的情况。",
            "代码示例:\npublic class MainProgramSubprogram {\n    public void process() {\n        readFile();\n        convertToLowerCase();\n    }\n}"
        );

        // 调用处理逻辑
        MainProgramSubprogram processor = new MainProgramSubprogram();
        ArrayList<String> result = processor.process(selectedFile.getAbsolutePath());
        displayResult(result);
    }

    private void handleObjectOriented() {
        // 处理逻辑并显示文字说明、代码结构
        displayInfo(
            "面向对象架构:\n将功能划分为不同的对象，每个对象封装不同的功能模块，利用对象之间的交互来完成任务。适合复用性强、结构复杂的应用场景。",
            "代码示例:\npublic class LowerCaseConverter {\n    public String convert(String text) {\n        return text.toLowerCase();\n    }\n}"
        );

        ObjectOriented processor = new ObjectOriented();
        processor.readFile(selectedFile.getAbsolutePath());
        ArrayList<String> result = processor.convertToLowerCase();
        displayResult(result);
    }

    private void handleEventSystem() {
        // 处理逻辑并显示文字说明、代码结构
        displayInfo(
            "事件驱动架构:\n基于事件的机制，当特定事件发生时，触发相应的处理器来执行任务。适合异步处理和实时性要求高的场景。",
            "代码示例:\npublic void onEventTriggered() {\n    processEvent();\n}"
        );

        // 未实现具体逻辑
    }

    private void handlePipeFilter() {
        // 处理逻辑并显示文字说明、代码结构
        displayInfo(
            "管道-过滤器架构:\n数据流经过多个过滤器，每个过滤器处理一个特定任务，适合数据处理任务链条较长的情况。",
            "代码示例:\npublic class PipeFilter {\n    public void process() {\n        filter1();\n        filter2();\n    }\n}"
        );

        PipeFilter processor = new PipeFilter();
        ObjectOriented inputProcessor = new ObjectOriented();
        inputProcessor.readFile(selectedFile.getAbsolutePath());
        ArrayList<String> inputLines = inputProcessor.getLines();
        ArrayList<String> result = processor.process(inputLines);
        displayResult(result);
    }

    // 显示转换结果
    private void displayResult(ArrayList<String> result) {
        resultArea.clear();  // 清空之前的输出
        for (String line : result) {
            resultArea.appendText(line + "\n");
        }
    }

    // 显示体系结构的文字说明和代码示例
    private void displayInfo(String description, String code) {
        infoArea.clear();
        infoArea.appendText(description + "\n\n" + code);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
