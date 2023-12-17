package GetDataFromJson;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Modal.Tweet;

public class getTweet {
	JsonParser jsonParser = new JsonParser();

	public ArrayList<Tweet> getArrayList() {
		String strJson = jsonParser.getJSONFromFile("D:\\java\\OOP_Nhom21\\src\\FileJson\\dataTweet.json");

//	      System.out.println(strJson);
		try {
			ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
			JSONParser parser = new JSONParser();
			Object object = parser.parse(strJson);
			JSONArray mainJsonObject = (JSONArray) object;
			for (int i = 0; i < mainJsonObject.size(); i++) {
				Tweet tweet = new Tweet();
				JSONObject jsonObject = (JSONObject) mainJsonObject.get(i);
				String Title = (String) jsonObject.get("title");
				tweet.setTitle(Title);
				String autString = (String) jsonObject.get("author");
				tweet.setAuthor(autString);
				String dateString = (String) jsonObject.get("date");
				tweet.setDate(dateString);
				JSONArray jsonArrayTag = (JSONArray) jsonObject.get("tags");
				ArrayList<String> tagList = new ArrayList<String>();
				for (int j = 0; j < jsonArrayTag.size(); j++) {
					String string = (String) jsonArrayTag.get(j);
					tagList.add(string);
				}
				tweet.setTag(tagList);
				long like = (Long) jsonObject.get("like");
				tweet.setLike(like);
				tweetList.add(tweet);
			}
			return tweetList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
