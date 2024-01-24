package com.springBootwithRestApi.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springBootwithRestApi.model.Book;

@Service
public class BookService {
	
	static List<Book> list = new ArrayList();
	
	static {
		
		  list.add(new Book(2,"java core","james")); list.add(new
		  Book(5,"java advance","james")); list.add(new Book(3,"java spring","james"));
		  list.add(new Book(6,"java boot","james"));
		 
	}
	 
	//get All Book
	public List<Book> getAllBook(){
		return list;
		
	}
	
	//get single book
	
	public Book getBookById(int id) {
		Book book=null;
		try {
	    book = list.stream().filter(i->i.getBook_id()==id).findFirst().get();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}
	
	//adding book
	
	public Book addBook(Book book){
		list.add(book);
		return book;
	}
	
	//delete by Id
	public String deleteById(int id){
		return "deleted";
	}

	public void updateById(int id, Book book) {
		Function<Book, Book> f= i->{
			if(i.getBook_id()==id) {
				i.setBook_name(book.getBook_name());
			}
			return i;
		};
		List<Book> collect = list.stream().map(f).collect(Collectors.toList());
		
	
	}

	
   /* 
	public String updateById(int id, Book book) {
		Book book1 = new Book();
		book1.setBook_name(book.getBook_name());
       
		return "upated Successfully";
	}
	*/

}