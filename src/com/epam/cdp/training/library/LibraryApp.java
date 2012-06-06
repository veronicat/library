package com.epam.cdp.training.library;

public class LibraryApp {

	/**
	 * Library application.
	 */
	public static void main(String[] args) {
		
		Author authorArray[] = new Author[5];
		 
		for (int i = 0; i < authorArray.length-1; i++) {
			 authorArray[i] = new Author("Name"+i);
			 for (int j = 0; j < 3; j++) {
				 Book.addBook(authorArray[i], "BookName"+j, "Description"+j, "Date"+j, (10.05+j));
			 }
		 }
		//adding 4 authors with 3 books each
		 
		 authorArray[4] = new Author("Kolya");
		 Book.addBook(authorArray[4], "A Little Princess", "Princess book", "12.02.1990", 24.95);
		 Book.addBook(authorArray[4], "Wonderful Stories for Children", "Wonderful Stories for Children", "5.08.1998", 30.00);
		 Book.addBook(authorArray[4], "New Year", "New Year book", "26.11.2000", 35.95);
		 //adding Kolya author and his books 
		
		 Author authorKolya= null; 
		 for (int i = 0; i < authorArray.length; i++) {
				Author authorI = authorArray[i];
				if (authorI.getName().equals("Kolya")){
					authorKolya = authorI;
				}
		 }
		//to find author Kolya
		 
		Book.addBook(authorKolya, "NewBook1", "NBDescription1", "nbdata1", 18.05);
		Book.addBook(authorKolya, "NewBook2", "NBDescription2", "nbdata2", 0.05);
		//Add two new books of Kolya 
		
		Book editedBook = authorKolya.editBookDescription("New Year", "New description here!!!");
		System.out.println(editedBook.getName() + " description changed to " + editedBook.getDescription());
		System.out.println("Book of " +Book.getAuthorName(editedBook)+" was edited");
		
		Book.findBooksbyAuthor(authorKolya.getName());
		//Find books of the Kolya author
		
		Book.deleteAuthorCheapestBook(authorKolya);
		//Delete Kolya's cheapest book
	
	}
}
