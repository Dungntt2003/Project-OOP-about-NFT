package GetDataFromJson;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Modal.Collection;

public class getCollection {
	JsonParser jsonParser = new JsonParser();

	public ArrayList<Collection> getArrayList() {
		String strJson = jsonParser.getJSONFromFile("D:\\java\\OOP_Nhom21\\src\\FileJson\\dataCollection.json");
		try {
			ArrayList<Collection> CollectionList = new ArrayList<Collection>();
			JSONParser parser = new JSONParser();
			Object object = parser.parse(strJson);
			JSONArray mainJsonObject = (JSONArray) object;
			for (int i = 0; i < mainJsonObject.size(); i++) {
				Collection Collection = new Collection();
				JSONObject jsonObject = (JSONObject) mainJsonObject.get(i);
				String Title = (String) jsonObject.get("title");
				Collection.setTitle(Title);
				String autString = (String) jsonObject.get("author");
				Collection.setAuthor(autString);
				String dateString = (String) jsonObject.get("date");
				Collection.setDate(dateString);
				JSONArray jsonArrayTag = (JSONArray) jsonObject.get("tags");
				ArrayList<String> tagList = new ArrayList<String>();
				for (int j = 0; j < jsonArrayTag.size(); j++) {
					String string = (String) jsonArrayTag.get(j);
					tagList.add(string);
				}
				Collection.setTag(tagList);
				double price = (Double) jsonObject.get("price");
				long transaction = (Long) jsonObject.get("transaction");
				Collection.setPrice(Math.floor(price));
				Collection.setTransaction(transaction);
				System.out.println(transaction);
				CollectionList.add(Collection);
			}
			return CollectionList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
