package GetDataFromJson;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Modal.Tweet;

public class getTweet {
	JsonParser jsonParser = new JsonParser();

	public ArrayList<Tweet> getArrayList() {
		String strJson = jsonParser.getJSONFromFile("D:\\java\\OOP_Nhom21\\src\\FileJson\\twitter.json");
		try {
			ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
			JSONParser parser = new JSONParser();
			Object object = parser.parse(strJson);
			JSONArray mainJsonObject = (JSONArray) object;
			for (int i = 0; i < mainJsonObject.size(); i++) {
				Tweet tweet = new Tweet();
				JSONObject jsonObject = (JSONObject) mainJsonObject.get(i);
				String autString = (String) jsonObject.get("author");
				tweet.setAuthor(autString);
				String dateString = (String) jsonObject.get("date");
				tweet.setDate(dateString);
				String replieString = (String) jsonObject.get("replies");
				tweet.setReplies(replieString);
				String repostString = (String) jsonObject.get("reposts");
				tweet.setReposts(repostString);
				String likeString = (String) jsonObject.get("likes");
				tweet.setLikes(likeString);
				String viewString = (String) jsonObject.get("views");
				tweet.setViews(viewString);
				String hashtahString = (String) jsonObject.get("hashtags");
				ArrayList<String> hashtagList = new ArrayList<String>();
				hashtagList.add(hashtahString);
				tweet.setTag(hashtagList);
				String text = (String) jsonObject.get("text");
				tweet.setText(text);
				tweetList.add(tweet);
			}
			return tweetList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
