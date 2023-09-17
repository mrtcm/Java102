import java.util.Comparator;
import java.util.TreeSet;

public class main {
	public static void main(String[] args) {
		TreeSet<Book> bookList = new TreeSet<>();
		TreeSet<Book> bookList2 = new TreeSet<>(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.getPageNumber() - o2.getPageNumber();
			}
			
		});
		
		
		bookList.add(new Book("c", 10, "yazar5", "4 Ocak 2023"));
		bookList.add(new Book("s", 20, "yazar1", "1 Ocak 2023"));
		bookList.add(new Book("d", 2230, "yazar2", "10 Ocak 2023"));
		bookList.add(new Book("a", 210, "yazar3", "2 Ocak 2023"));
		bookList.add(new Book("ds", 320, "yazar4", "3 Ocak 2023"));
		
		
		bookList2.add(new Book("c", 10, "yazar5", "4 Ocak 2023"));
		bookList2.add(new Book("s", 20, "yazar1", "1 Ocak 2023"));
		bookList2.add(new Book("d", 2230, "yazar2", "10 Ocak 2023"));
		bookList2.add(new Book("a", 210, "yazar3", "2 Ocak 2023"));
		bookList2.add(new Book("ds", 320, "yazar4", "3 Ocak 2023"));
		
		// kitap adına göre sıralama
		for (Book book : bookList) {
			System.out.println(book);
		}
	
		// sayfa sayısına göre sıralama
		for (Book book : bookList2) {
			System.out.println(book);
		}
	}
}
