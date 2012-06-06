package com.epam.cdp.training.library;

import java.util.*;

public class Book {

	/*
	 * Book class. Helps you to store all the books, Create new books, find
	 * existing books
	 */

	private static ArrayList<Book> bookArray = new ArrayList<Book>();
	// array that stores all books
	private String name;
	private String description;
	private String date;
	private Double price;
	private Author author;

	public Book(Author pAuthor, String pName, String pDescription,
			String pDate, Double pPrice) {
		super();
		this.setAuthor(pAuthor);
		this.setName(pName);
		this.setDescription(pDescription);
		this.setDate(pDate);
		this.setPrice(pPrice);
		bookArray.add(this);
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String pDescription) {
		this.description = pDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDate(String pDate) {
		this.date = pDate;
	}

	public String getDate() {
		return date;
	}

	public void setPrice(Double pPrice) {
		this.price = pPrice;
	}

	public Double getPrice() {
		return price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * This method is used to get a name of the book author.
	 * 
	 * @param book
	 *            - Book object
	 * 
	 * @return - Author name as a String
	 */
	public static String getAuthorName(Book book) {
		String authorName = null;
		authorName = book.getAuthor().getName();
		return authorName;
	}

	/**
	 * This method is used to add a new book.
	 * 
	 * @param pAuthor
	 *            - author object pName - book name pDescription - book
	 *            description pDate - book date pPrice - book price
	 * 
	 * @return - Book object
	 */
	public static Book addBook(Author pAuthor, String pName,
			String pDescription, String pDate, Double pPrice) {
		Book newBook = new Book(pAuthor, pName, pDescription, pDate, pPrice);
		System.out.println("Book with name " + newBook.getName() + " of "
				+ Book.getAuthorName(newBook) + " author was added");
		return newBook;
	}

	/**
	 * This method is used to find a book by its name.
	 * 
	 * @param pName
	 *            - book name
	 * 
	 * @return - Book object or null if no books found
	 */
	public static Book findBookbyName(String pName) {
		Book foundBook = null;
		ListIterator<Book> it = bookArray.listIterator();
		while (it.hasNext()) {
			Book bookI = it.next();
			if (bookI.getName().equals(pName)) {
				foundBook = bookI;
			}

		}
		return foundBook;
	}

	/**
	 * This method is used to find books by its Author name.
	 * 
	 * @param pName
	 *            - Author name
	 * 
	 * @return - ArrayList of Book objects
	 */
	public static ArrayList<Book> findBooksbyAuthor(String pName) {
		List<Book> foundBooks = new ArrayList<Book>();
		ListIterator<Book> it = bookArray.listIterator();
		while (it.hasNext()) {
			Book bookI = it.next();
			if (Book.getAuthorName(bookI).equals(pName)) {
				foundBooks.add(bookI);
			}
		}
		System.out.println("Author " + pName + " has " + foundBooks.size()
				+ " books");
		return (ArrayList<Book>) foundBooks;
	}

	/**
	 * This method is used to find cheapest book in bookArray.
	 * 
	 * @param author
	 *            - Author of the book(object)
	 * 
	 * @return - Book object
	 */
	public static Book findCheapestBook(Author author) {
		ListIterator<Book> it = bookArray.listIterator();
		if (bookArray.size() == 0) {
			return null;
		}

		Book cheapestBook = bookArray.get(0);
		while (it.hasNext()) {
			Book bookI = it.next();
			if (bookI.author.equals(author)) {
				if (bookI.getPrice() < cheapestBook.getPrice()) {
					cheapestBook = bookI;
				}
			}
		}
		System.out.println("The cheapest book of " + author.getName()
				+ " author is " + cheapestBook.getName() + " which prise is "
				+ cheapestBook.getPrice());
		return cheapestBook;
	}

	/**
	 * This method is used to delete the cheapest book of the author
	 * 
	 * @param author
	 *            - Author of the book(object)
	 * 
	 * @return - Book object
	 */
	public static Book deleteAuthorCheapestBook(Author author) {
		return Book.deleteBook(Book.findCheapestBook(author));
	}

	/**
	 * This method is used to delete book from bookArray.
	 * 
	 * @param objBook
	 *            - Book object
	 * 
	 * @return - Book object
	 */
	public static Book deleteBook(Book objBook) {
		int index = bookArray.indexOf(objBook);
		System.out.println("Book which name is " + objBook.getName()
				+ " was deleted from the Books Array");
		return bookArray.remove(index);
	}

}
