package Presenter;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import Model.BookDetail;
import Model.Books;
import Model.Editorial;

public class Main {

	static XStream xstream;

	public static String createXML() {
		BookDetail book_detail_1 = new BookDetail(1, "book one ", 10);
		BookDetail book_detail_2 = new BookDetail(2, "book two ", 999);

		List details_book_1 = new ArrayList();
		details_book_1.add(book_detail_1);

		List details_book_2 = new ArrayList();
		details_book_2.add(book_detail_2);

		Books book1 = new Books(details_book_1, "PEDRO");
		Books book2 = new Books(details_book_2, "PEPE");

		List list_books = new ArrayList();
		list_books.add(book1);
		list_books.add(book2);

		Editorial editorial = new Editorial("Anaya", list_books);

		return xstream.toXML(editorial);
	}

	public static void main(String[] args) {

		// CREATE XSTREAM
		xstream = new XStream(new DomDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.allowTypesByRegExp(new String[] { ".*" }); // SOLVE VULNERABILITY MESSAGE

		// CREATE ANNOTATIONS --- ex: @XStreamAlias("Books")
		xstream.processAnnotations(Books.class);
		xstream.processAnnotations(BookDetail.class);
		xstream.processAnnotations(Editorial.class);

		// ADD COLLECTIONS 
		xstream.addImplicitCollection(Books.class, "bookDetails");
		xstream.addImplicitCollection(Editorial.class, "books");

		// CREATE XML EXAMPLE
		String XML = createXML();
		System.out.println("******    XML    ******\n");
		System.out.println(XML + "\n");

		// GET OBJECT FROM XML EXAMPLE
		System.out.println("******    OBJETS FROM XML    ******\n");

		Editorial editorial = (Editorial) xstream.fromXML(XML);
		String editorial_name = editorial.getName();
		String book_pepe = editorial.getBooks().get(1).getAuthor();
		String name = editorial.getBooks().get(1).getBookDetails().get(0).getBookName();
		int price = editorial.getBooks().get(1).getBookDetails().get(0).getAmount();

		System.out.println(
				"Name: " + name + " Author: " + book_pepe + "  Editorial: " + editorial_name + "  price: " + price);

	}

}
