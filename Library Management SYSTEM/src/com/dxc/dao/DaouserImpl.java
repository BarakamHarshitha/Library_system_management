package com.dxc.dao;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

 

import com.dxc.pojos.Book;

 public class DaouserImpl implements Idaouser
{
    private int c1,bookid,quantity,days;
    Book bd=new Book();
    private String bookname,bookauthor,username,userpassword;
    Scanner sc=new Scanner(System.in);
    private static Connection conn;
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
    public void verifydetails(String a, String p)
    {
        try {
            Statement stmt =conn.createStatement();
            ResultSet rset=stmt.executeQuery("select * from userdetails");
            while(rset.next())
            {
                if(rset.getString(2).equals(a) && rset.getString(3).equals(p))
                  System.out.println("you are logged as user");
                else
                {
                    System.out.println("userdetails are incorrect");
                    System.exit(0);
                
                }
                 break;
            }
            
        } catch (SQLException e) {
                    e.printStackTrace();
        }
        
    }

 

    public void getBooksLibrary()
    {
        try {
            Statement stmt=conn.createStatement();
            ResultSet rst=stmt.executeQuery("select * from book");
            while(rst.next())
            {
                System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"   "+rst.getString(3)+"   "+rst.getInt(4));
            }
            System.out.println();
            System.out.println("enter bookid to be issued :");
            bookid=sc.nextInt();
            System.out.println("enter username :");
            username=sc.next();
            System.out.println("enter password :");
            userpassword=sc.next();
            
            PreparedStatement pstmt1 =conn.prepareStatement("insert into userdetails values(?,?,?,500)");
            pstmt1.setInt(1, bookid);
            pstmt1.setString(2, username);
            pstmt1.setString(3, userpassword);
            
            pstmt1.execute();
            System.out.println("book issued to the user");
            System.out.println("how many books needed :");
            c1=sc.nextInt();
            PreparedStatement pstmt=conn.prepareStatement("update book set quantity=quantity-? where bookid =?");
            pstmt.setInt(1, c1);
            pstmt.setInt(2,bookid);            
            pstmt.execute();
            System.out.println("how many days you want book from library");
            days=sc.nextInt();
            PreparedStatement pstmt2=conn.prepareStatement("update userdetails set Librarybal=Librarybal-(?*5) where userid=?");
            pstmt2.setInt(1, days);
            pstmt2.setString(2, username);
            pstmt2.execute();
            
            
            } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void getListOfbooks()
    {
        try {
            System.out.println("enter author");
           bookauthor=sc.next();
            PreparedStatement pstmt=conn.prepareStatement("select * from book where bookauthor =?");
            pstmt.setString(1,bookauthor);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next())
            {
                System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"   "+rst.getString(3)+"   "+rst.getInt(4));
            }
            
            System.out.println();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void availableBalance()
    {
        try {
            PreparedStatement pstmt =conn.prepareStatement("select Librarybal from userdetails where userid=?");
            System.out.println("enter username");
            username=sc.next();
            pstmt.setString(1, username);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next())
            {
            System.out.println(rst.getInt(1));
            break;
            }
            System.out.println();
            
            
            
        }catch(Exception e) {
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
