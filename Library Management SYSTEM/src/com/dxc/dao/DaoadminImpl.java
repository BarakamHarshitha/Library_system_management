package com.dxc.dao;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 

import com.dxc.pojos.Book;

 

public class DaoadminImpl implements Idaoadmin
{
    private int c1,bookid,quantity;
    Book bd;
    private String bookname,bookauthor,username;
    Scanner sc=new Scanner(System.in);
    private static Connection conn;
    private List<Book> l=new ArrayList<>();
    static
    {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        
        	 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","root");
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    public void verifydetails(String a,String p)
    {
        try {
            Statement stmt =conn.createStatement();
            ResultSet rset=stmt.executeQuery("select * from admin");
            while(rset.next())
            {
                if(rset.getString(1).equals(a) && rset.getString(2).equals(p))
                  System.out.println("you are logged as admin");
                else {
                    System.out.println("admindetails are incorrect");
                System.exit(0);
                }
                break;
            }
            
        } catch (SQLException e) {
                    e.printStackTrace();
        }
        
    }
    public void updateBooks()
    {
        try {
        
        System.out.println("1.add a book ");
        System.out.println("2.remove a book ");
        c1=sc.nextInt();
        switch(c1)
        {
        case 1:
            PreparedStatement pstmt1 =conn.prepareStatement("insert into book values(?,?,?,?)");
    
            System.out.println("enter bookid");
            bookid=sc.nextInt();
            pstmt1.setInt(1, bookid);
            System.out.println("enter bookname");
            
            bookname=sc.next();
            pstmt1.setString(2, bookname);
            System.out.println("enter author");
            
            bookauthor=sc.next();
            pstmt1.setString(3, bookauthor);
            System.out.println("enter quantyties ");
            
            quantity=sc.nextInt();
            pstmt1.setInt(4, quantity);
            pstmt1.execute();    
            System.out.println("book added into bookdetails");
            break;
        case 2:
            Statement stmt =conn.createStatement();
            ResultSet rset=stmt.executeQuery("select * from book ");
            while(rset.next())
            {
                bd=new Book(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4));
                l.add(bd);
            }
            for(Book bd:l)
            {
                System.out.println(bd.getBook_id()+"  "+bd.getBook_name()+"  "+bd.getAuthor()+"  "+bd.getQuantity());
            }
            System.out.println("enter the bookid :");
            bookid=sc.nextInt();
            PreparedStatement pstmt =conn.prepareStatement("delete from book where bookid=?");
            pstmt.setInt(1, bookid);
            pstmt.execute();
            break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void getListOfBooks()
    {
        try {
            System.out.println("enter the username:");
            username=sc.next();
            PreparedStatement pstmt1 =conn.prepareStatement("select bookid from userdetails where userid=?");
            
            pstmt1.setString(1, username);
            ResultSet rset = pstmt1.executeQuery();
            int count=0;
            while(rset.next())
            {
                System.out.println(rset.getInt(1));
                count=count+1;
            }
            
            while(count>=1)
            {
            System.out.println("enter the bookid :");
            bookid=sc.nextInt();
            PreparedStatement pstmt =conn.prepareStatement("select bookid,bookname,bookauthor from book where bookid=?");
            pstmt.setInt(1, bookid);
            ResultSet rst=pstmt.executeQuery();
                while(rst.next())
                {
                	System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"  "+rst.getString(3));
              
                }
            count--;
            }
            
        }catch (Exception e) {
            e.printStackTrace();

 

        }
    }
    public void getBalance()
    {
        try {
            PreparedStatement pstmt =conn.prepareStatement("select Librarybal from userdetails"
            		+ " where userid=?");
            System.out.println("enter username");
            username=sc.next();
            pstmt.setString(1, username);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next())
            {
            System.out.println(rst.getInt(1));
            break;
            }
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void closeUserAccount()
    {
        try {
        Statement stmt =conn.createStatement();
        ResultSet rset=stmt.executeQuery("select * from userdetails ");
        while(rset.next())
        {
            System.out.println(rset.getInt(1)+rset.getString(2)+rset.getString(3)+rset.getInt(4));
        }
        
        System.out.println("enter the bookid :");
        bookid=sc.nextInt();
        PreparedStatement pstmt =conn.prepareStatement("delete from userdetails where bookid=?");
        pstmt.setInt(1, bookid);
        pstmt.execute();
        
        }
     catch(Exception e) {
        e.printStackTrace();
    }
    
    
}
    public void closeSystem()
    {

 

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
