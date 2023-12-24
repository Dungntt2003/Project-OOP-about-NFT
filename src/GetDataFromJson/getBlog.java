package GetDataFromJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Modal.Blog;

public class getBlog {
	JsonParser jsonParser = new JsonParser();
	ArrayList<String> tagList = new ArrayList<String>();
	int newestMonth;
	HashMap<String, Integer> hashMap = new HashMap<>();

	public ArrayList<Blog> getArrayList() {
		try {
			String strJson = jsonParser.getJSONFromFile("D:\\java\\OOP_Nhom21\\src\\FileJson\\cointelegraph.json");
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
				String hrefString = (String) jsonObject.get("href");
				blog.setHref(hrefString);
				String dateString = (String) jsonObject.get("date");
				blog.setDate(dateString);
				String tagString = (String) jsonObject.get("tags");
				if (checkString(tagString))
					tagList.add(tagString);
				ArrayList<String> tagList2 = new ArrayList<String>();
				tagList2.add(tagString);
				blog.setTag(tagList2);
				String view = (String) jsonObject.get("views");
				blog.setView(Long.parseLong(view));
				blogList.add(blog);

				if (i == 0) {
					newestMonth = getMonth(dateString);
					hashMap.put(tagString, Integer.parseInt(view));
				} else {
					if (getMonth(dateString) == newestMonth) {
						if (hashMap.containsKey(tagString)) {
							int currentValue = hashMap.get(tagString);
							currentValue += Integer.parseInt(view);
							hashMap.put(tagString, currentValue);
						} else {
							hashMap.put(tagString, Integer.parseInt(view));
						}
					}
				}

			}
			return blogList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean checkString(String tag) {
		for (String a : tagList) {
			if (a.equalsIgnoreCase(tag)) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<String> getListTag() {
		return tagList;
	}

	public int getMonth(String date) {
		String[] parts = date.split("/");
		return Integer.parseInt(parts[1]);
	}

	public List<String> getHotTag() {
		List<Map.Entry<String, Integer>> sortedTags = new ArrayList<>(hashMap.entrySet());
		sortedTags.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
		List<String> topThreeTags = new ArrayList<>();
		for (int i = 0; i < Math.min(3, sortedTags.size()); i++) {
			topThreeTags.add(sortedTags.get(i).getKey());
		}

		return topThreeTags;
	}

}
