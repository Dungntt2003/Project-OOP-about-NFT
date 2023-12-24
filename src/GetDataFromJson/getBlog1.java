package GetDataFromJson;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Modal.Blog;

public class getBlog1 {
	JsonParser jsonParser = new JsonParser();
	ArrayList<String> tagList = new ArrayList<String>();
	int newestMonth;
	HashMap<String, Integer> hashMap = new HashMap<>();

	public ArrayList<Blog> getArrayList() {
		try {
			String strJson = jsonParser.getJSONFromFile("D:\\java\\OOP_Nhom21\\src\\FileJson\\decrypt.json");
			ArrayList<Blog> blogList = new ArrayList<Blog>();
			JSONParser parser = new JSONParser();
			Object object = parser.parse(strJson);
			JSONArray mainJsonObject = (JSONArray) object;
			for (int i = 0; i < mainJsonObject.size(); i++) {
				Blog blog = new Blog();
				JSONObject jsonObject = (JSONObject) mainJsonObject.get(i);
				String Title = (String) jsonObject.get("title");
				blog.setTitle(Title);
				String autString = (String) jsonObject.get("author");
				blog.setAuthor(autString);
				String dateString = (String) jsonObject.get("date");
				blog.setDate(dateString);
				String tagString = (String) jsonObject.get("tags");
				ArrayList<String> tagList2 = new ArrayList<String>();
				tagList2.add(tagString);
				blog.setTag(tagList2);
				String view = (String) jsonObject.get("view");
				blog.setView(0);
				blogList.add(blog);

			}
			return blogList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
