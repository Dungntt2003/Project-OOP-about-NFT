package Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonParser {
    public static String getJSONFromFile(String filename) {
        String jsonText = "";
        try {		
            BufferedReader bufferedReader = 
                          new BufferedReader(new FileReader(filename));
        
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }
        
            bufferedReader.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return jsonText;
    }
    
    public static String getJSONFromURL(String strUrl) {
        String jsonText = "";

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = 
                            new BufferedReader(new InputStreamReader(is));
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }

            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return jsonText;
    }
    
    public static void main(String[] args) {
        String strJson = getJSONFromFile("D:\\java\\Test_for_oop_pj\\src\\Data\\data.json");
//        String strJson = getJSONFromURL(
//            "https://raw.githubusercontent.com/BoostMyTool/JsonFile/master/example.json"
//        );
        
        System.out.println(strJson);
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJson);
            JSONObject mainJsonObject = (JSONObject) object;
            
            String Title = (String) mainJsonObject.get("title");
            System.out.println("Title : " + Title);
            
            String autString = (String) mainJsonObject.get("author");
            System.out.println("Author : " + autString);
            
            String dateString = (String)mainJsonObject.get("date");
            System.out.println("Date : " + dateString);         
            JSONArray jsonArrayTag = (JSONArray) mainJsonObject.get("tags");
            System.out.println(jsonArrayTag);
            for (int i = 0 ; i < jsonArrayTag.size() ; i++) {
            	System.out.println(jsonArrayTag.get(i));
            	String string = (String)jsonArrayTag.get(i);
            	System.out.println(string);
            }
//            
//            for (int i = 0; i < jsonArrayPhoneNumbers.size(); i++) {
//                JSONObject jsonPhoneNumber = (JSONObject) jsonArrayPhoneNumbers.get(i);
//                System.out.println("      Phone Number " + (i + 1));
//
//                String type = (String) jsonPhoneNumber.get("type");
//                System.out.println("      Type : " + type);
//
//                String number = (String) jsonPhoneNumber.get("number");
//                System.out.println("      Number : " + number);
//            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}