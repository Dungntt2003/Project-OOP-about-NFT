package GetDataFromJson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonParser {
	public static String getJSONFromFile(String filename) {
		String jsonText = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

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

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

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
//    public static void main(String[] args) {
//		
//	}
//    public static ArrayList<Blog> getArrayList() {
//    	String strJson = getJSONFromFile("D:\\java\\Test_for_oop_pj\\src\\Data\\data.json");
//      
//      System.out.println(strJson);
//      try {
//      	ArrayList<Blog> blogList = new ArrayList<Blog>();
//          JSONParser parser = new JSONParser();
//          Object object = parser.parse(strJson);
//          JSONArray mainJsonObject = (JSONArray) object;
//          for (int i = 0 ; i < mainJsonObject.size(); i++) {
//          	Blog blog = new Blog();
//          	JSONObject jsonObject = (JSONObject)mainJsonObject.get(i);
//          	String Title = (String) jsonObject.get("title");
//          	blog.setTitle(Title);
//          	String autString = (String) jsonObject.get("author");
//            	blog.setAuthor(autString);
//            	String dateString = (String)jsonObject.get("date");
//            	blog.setDate(dateString);        
//            	JSONArray jsonArrayTag = (JSONArray) jsonObject.get("tags");
//            	ArrayList<String> tagList = new ArrayList<String>();
//            	for (int j = 0 ; j < jsonArrayTag.size() ; j++) {
//	              	String string = (String)jsonArrayTag.get(j);
//	              	tagList.add(string);
//            	}
//            	blog.setTag(tagList);
//            	blog.setView(100);
//          	blogList.add(blog);
//          }
//          return blogList;
//      }
//      catch(Exception ex) {
//          ex.printStackTrace();
//      }
//      return null;
//	}
}