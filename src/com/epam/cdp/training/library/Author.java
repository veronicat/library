package com.epam.cdp.training.library;

public class Author {

	/*
	 * Author class. Helps you to add new authors, Edit existing books of the
	 * author.
	 */

	private String name;

	// attribute for author name

	public Author(String pName) {
		super();
		this.setName(pName);
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getName() {
		return name;
	}

	/**
	 * This method is used to edit book description. First this method finds a
	 * book by its name.
	 * 
	 * @param pName
	 *            - book name pDescription - new book description
	 * 
	 * @return - Book object or null if no books found
	 */
	public Book editBookDescription(String pName, String pDescription) {
		Book editedBook = Book.findBookbyName(pName);
		if (editedBook != null) {
			editedBook.setDescription(pDescription);
			return editedBook;
		} else {
			return null;
		}
	}

}
