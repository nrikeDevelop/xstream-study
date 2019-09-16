package Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BookDetails")
public class BookDetail {
	private int bookId;
	private String bookName;
	private int amount;

	public BookDetail(int bookId, String bookName, int amount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.amount = amount;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
