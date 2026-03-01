package com.capgemini.assignment3_27feb.dao;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String isbn;
    private int publishYear;
    private int copiesTotal;
    private int copiesAvailable;
    private String status;

    @ManyToMany
    @JoinTable(
        name="book_author",
        joinColumns=@JoinColumn(name="book_id"),
        inverseJoinColumns=@JoinColumn(name="author_id")
    )
    private Set<Author> authors;

    @ManyToOne
    private Category category;

    @ManyToOne
    private LibraryBranch branch;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getCopiesTotal() {
		return copiesTotal;
	}

	public void setCopiesTotal(int copiesTotal) {
		this.copiesTotal = copiesTotal;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	public Book(Long bookId, String title, String isbn, int publishYear, int copiesTotal, int copiesAvailable,
			String status, Set<Author> authors, Category category, LibraryBranch branch) {
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.copiesTotal = copiesTotal;
		this.copiesAvailable = copiesAvailable;
		this.status = status;
		this.authors = authors;
		this.category = category;
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", publishYear=" + publishYear
				+ ", copiesTotal=" + copiesTotal + ", copiesAvailable=" + copiesAvailable + ", status=" + status
				+ ", authors=" + authors + ", category=" + category + ", branch=" + branch + "]";
	}
    
    
}