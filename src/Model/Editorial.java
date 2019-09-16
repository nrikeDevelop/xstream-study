package Model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Editorial")
public class Editorial {

	public String name;
	public List<Books> books = new ArrayList<Books>();

	public Editorial(String name, List<Books> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public Editorial() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

}
