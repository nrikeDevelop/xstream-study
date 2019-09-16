package Model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Books")
public class Books
{
    public List<BookDetail> bookDetails = new ArrayList<BookDetail>();
    public String Author;
    
	public Books(List<BookDetail> bookDetails, String author) {
		super();
		this.bookDetails = bookDetails;
		Author = author;
	}
	public List<BookDetail> getBookDetails() {
		return bookDetails;
	}
	public void setBookDetails(List<BookDetail> bookDetails) {
		this.bookDetails = bookDetails;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}

    
    
    
}
