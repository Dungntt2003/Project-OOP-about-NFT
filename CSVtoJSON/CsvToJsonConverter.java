package GetData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvToJsonConverter {

    public static void main(String[] args) {
        String csvFilePath = "D:\\GetData\\Test1\\OOP_Nhom21\\OpenSea\\opensea.csv";
        String jsonFilePath = "D:\\GetData\\Test1\\OOP_Nhom21\\OpenSea\\opensea.json";

        try {
            String csvData = readCsvFile(csvFilePath);
            JSONArray jsonArray = convertCsvToJson(csvData);
            writeJsonFile(jsonArray, jsonFilePath);
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readCsvFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static JSONArray convertCsvToJson(String csvData) {
        String[] lines = csvData.split("\n");
        String[] headers = lines[0].split(",");
        JSONArray jsonArray = new JSONArray();

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(",");
            JSONObject jsonObject = new JSONObject();

            for (int j = 0; j < headers.length; j++) {
                jsonObject.put(headers[j], values[j]);
            }

            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }

    private static void writeJsonFile(JSONArray jsonArray, String filePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString(2)); // The second parameter is the indentation level
        }
    }
}
