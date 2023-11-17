package Object;

import java.util.Comparator;
import java.util.List;

public class Blog extends NFTs{
	private int pageViews;
    
    // Phương thức khởi tạo
    public Blog() {
    	
    }
    
    public Blog(int pageViews) {
        this.pageViews = pageViews;
    }

    // Getter
	public int getPageViews() {
		return this.pageViews;
	}

	// Phương thức in thông tin Blog
	public void printBlog() {
		System.out.println("Page Views: " + this.pageViews);
        System.out.println("---------------------");
	}

	// Phương thức sắp xếp theo số lượt xem blog
	public static void sortByView(List<Blog> blogs) {
		// Sắp xếp theo số lượt xem thứ tự tăng dần
		blogs.sort(Comparator.comparingInt(Blog::getPageViews));
		
		// Sắp xếp theo số lượt xem thứ tự giảm dần
		// blogs.sort(Comparator.comparingInt(Blog::getPageViews).reversed());
		
		// In trình tự đã sắp xếp
		for (Blog blog : blogs) {
			blog.printBlog();
		}
	}

}
