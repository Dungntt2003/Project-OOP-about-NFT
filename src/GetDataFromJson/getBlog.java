package GetDataFromJson;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Modal.Blog;

public class getBlog {
	JsonParser jsonParser = new JsonParser();

	public ArrayList<Blog> getArrayList() {
		try {
			String strJson = jsonParser.getJSONFromFile("D:\\java\\OOP_Nhom21\\src\\FileJson\\dataBlog.json");
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
				JSONArray jsonArrayTag = (JSONArray) jsonObject.get("tags");
				ArrayList<String> tagList = new ArrayList<String>();
				for (int j = 0; j < jsonArrayTag.size(); j++) {
					String string = (String) jsonArrayTag.get(j);
					tagList.add(string);
				}
				blog.setTag(tagList);
				long view = (Long) jsonObject.get("view");
				blog.setView(view);
				blogList.add(blog);
			}
			return blogList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
