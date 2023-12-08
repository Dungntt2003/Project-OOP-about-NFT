package GetData;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataWeb {

    public static void main(String[] args) {
        String url = "https://cointelegraph.com/tags/nft";

        try {
            int numPages = 3; // Số trang cần lấy
            int delayInSeconds = 15; // Khoảng thời gian chờ giữa các trang (30 giây)

            JSONArray jsonArray = new JSONArray();

            for (int page = 1; page <= numPages; page++) {

                // Kết nối với trang web
                Connection connection = Jsoup.connect(url + "?page=" + page);
                Document doc = connection.get();

                Elements articles = doc.select("li[class*=group-][class*=inline][class*=mb-8]");

                if (articles.isEmpty()) {
                    System.out.println("Không tìm thấy yếu tố bài viết trên trang " + page);
                    continue;
                }

                for (Element article : articles) {
                    JSONObject entry = new JSONObject();

                    try {
                        // Lấy thông tin về tác giả (author), ngày (date), lượt xem (views), và thẻ (tag)
                        Element header = article.select("div.post-card-inline__header").first();
                        Element meta = header.select("div.post-card-inline__meta").first();
                        Element authorElement = meta.select("p.post-card-inline__author").first();
                        Element dateElement = meta.select("time.post-card-inline__date").first();

                        // Xử lý tiêu đề (title) để loại bỏ kí tự không mong muốn
                        Element titleElement = article.select("span.post-card-inline__title").first();
                        String titleText = titleElement.text().replaceAll("[\u2018\u2019]", "'").replace("\u2014", "-");
                        entry.put("title", titleText);

                        // Xử lý tên tác giả bỏ "by "
                        String authorText = authorElement.text().replace("by ", "");
                        entry.put("author", authorText);

                        // Lấy lượt xem (views)
                        Element stats = article.select("div.post-card-inline__stats").first();
                        Element viewsElement = stats.select("span.post-card-inline__stats-item span").last();
                        entry.put("views", viewsElement.text().trim());

                        // Lấy thẻ (tag)
                        Element tagElement = article.select("span.post-card-inline__badge").first();
                        entry.put("tags", tagElement.text());

                        // Định dạng lại ngày
                        String isoDate = dateElement.attr("datetime");
                        String formattedDate = formatDate(isoDate);
                        entry.put("date", formattedDate);

                        jsonArray.put(entry);
                    } catch (Exception e) {
                        System.out.println("Lỗi khi xử lý một bài viết: " + e.getMessage());
                    }
                }

                // Tạm dừng trong khoảng thời gian cố định trước khi lấy trang tiếp theo
                Thread.sleep(delayInSeconds * 1000);
            }

            // Viết mảng JSON ra tệp với bố cục đẹp
            try {
                FileWriter fileWriter = new FileWriter("cointelegraph.json");
                fileWriter.write(jsonArray.toString(4)); // 4 là mức lồng
                fileWriter.close();
                System.out.println("Successfully exported to cointelegraph.json");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Phương thức định dạng lại ngày
    private static String formatDate(String isoDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(isoDate);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return isoDate; // Nếu có lỗi, trả về ngày ban đầu
        }
    }
}
