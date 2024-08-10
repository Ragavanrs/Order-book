package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;
    
    private String img;
    
    private String isbn;
    
    private Long price;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Order> orders;

    // Lombok @Data should generate these, but adding explicitly
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

	public void setImg(String img) {
		this.img = img;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getImg() {
		return img;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	
    
}
