package com.dxc.pojos;

 

public class Book
{
    private int book_id;
    private String book_name;
    private String author;
    private int quantity;    
    public Book() {        
    }
    public Book(int a,String b,String c,int d)
    {
        this.book_id= a;
        this.book_name=b;
        this.author=c;
        this.quantity=d;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void display()
    {
        System.out.println(this.book_id+""+this.book_name+""+this.author+""+this.quantity);;
        
    }

 

}