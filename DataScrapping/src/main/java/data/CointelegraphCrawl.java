package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CointelegraphCrawl {

    public static void main(String[] args) {
        String[] urls = {
                "https://cointelegraph.com/tags/bitcoin",
                "https://cointelegraph.com/tags/blockchain",
                "https://cointelegraph.com/tags/ai",
                "https://cointelegraph.com/tags/altcoin",
                "https://cointelegraph.com/tags/ethereum",
                "https://cointelegraph.com/tags/defi",
                "https://cointelegraph.com/tags/business",
                "https://cointelegraph.com/tags/nft"
        };

        int numPages = 5; // Số trang cần lấy
        int delayInSeconds = 1; // Khoảng thời gian chờ giữa các trang (10 giây)

        JSONArray jsonArray = new JSONArray();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        for (String url : urls) {
            for (int page = 1; page <= numPages; page++) {
                try {
                    driver.get(url + "?page=" + page);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    List<WebElement> articles = driver.findElements(By.cssSelector("li[class*=group-][class*=inline][class*=mb-8]"));

                    if (articles.isEmpty()) {
                        System.out.println("Không tìm thấy yếu tố bài viết trên trang " + page);
                        continue;
                    }

                    for (WebElement article : articles) {
                        JSONObject entry = new JSONObject();

                        try {
                            // Lấy thông tin về tác giả (author), ngày (date), lượt xem (views), và thẻ (tag)
                            WebElement header = article.findElement(By.cssSelector("div.post-card-inline__header"));
                            WebElement meta = header.findElement(By.cssSelector("div.post-card-inline__meta"));
                            WebElement authorElement = meta.findElement(By.cssSelector("p.post-card-inline__author"));
                            WebElement dateElement = meta.findElement(By.cssSelector("time.post-card-inline__date"));

                            // Xử lý tiêu đề (title) để loại bỏ kí tự không mong muốn
                            WebElement titleElement = article.findElement(By.cssSelector("span.post-card-inline__title"));
                            String titleText = titleElement.getText().replaceAll("[\u2018\u2019]", "'").replace("\u2014", "-");
                            entry.put("title", titleText);

                            // Lấy href
                            WebElement linkElement = article.findElement(By.cssSelector("a.post-card-inline__title-link"));
                            String href = linkElement.getAttribute("href"); // Get the href attribute
                            entry.put("href", href); // Add the base URL to create the full URL

                            // Xử lý tên tác giả bỏ "by "
                            String authorText = authorElement.getText().replace("by ", "");
                            entry.put("author", authorText);

                            // Lấy lượt xem (views)
                            WebElement stats = article.findElement(By.cssSelector("div.post-card-inline__stats"));
                            WebElement viewsElement = stats.findElement(By.cssSelector("span.post-card-inline__stats-item span:last-child"));
                            entry.put("views", viewsElement.getText().trim());

                            // Lấy thẻ (tag)
                            String[] urlParts = url.split("/");
                            String tag = urlParts[urlParts.length - 1];
                            entry.put("tags", tag);

                            // Định dạng lại ngày
                            String isoDate = dateElement.getAttribute("datetime");
                            String formattedDate = formatDate(isoDate);
                            entry.put("date", formattedDate);

                            jsonArray.put(entry);
                        } catch (Exception e) {
                            System.out.println("Lỗi khi xử lý một bài viết: " + e.getMessage());
                        }
                    }

                    // Tạm dừng trong khoảng thời gian cố định trước khi lấy trang tiếp theo
                    Thread.sleep(delayInSeconds * 1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Viết mảng JSON ra tệp với bố cục đẹp
        try {
            FileWriter fileWriter = new FileWriter("cointelegraph.json");
            fileWriter.write(jsonArray.toString(4)); // 4 là mức lồng
            fileWriter.close();
            System.out.println("Successfully exported to cointelegraph.json");
        } catch (Exception e) {
            System.out.println("Error processing an article: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
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
