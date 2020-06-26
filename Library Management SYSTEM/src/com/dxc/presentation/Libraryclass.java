package com.dxc.presentation;

 

import java.util.List;
import java.util.Scanner;

 

import com.dxc.pojos.Book;
import com.dxc.service.*;

 

public class Libraryclass {

 

    public static void main(String[] args) 
    {
        int c1;
        String A1,P1;
        Scanner sc=new Scanner(System.in);
        Iseviceadmin ias=new ServiceadminImpl();
        Iserviceuser ius=new ServiceuserImpl();
        List<Book> bd;
        
        while(true)
        {
            System.out.println("1.Admin Login page :");
            System.out.println("2.User Login page :");
            System.out.println("3.close System ");
            System.out.println("Enter the choice :");
            c1=sc.nextInt();
            switch(c1)
            {
            case 1:
                System.out.println("enter Admim  id :");
                A1=sc.next();
                System.out.println("enter Admin password :");
                P1=sc.next();
                 ias.verifydetails(A1,P1);
                 while(true)
                 {
                 System.out.println("1.Add or remove the books :");
                 System.out.println("2.Get list of books issued by particular user");
                 System.out.println("3.Get balance amount of particular user ");
                 System.out.println("4.close user account from library account ");
                 System.out.println("5.close System ");
                 c1=sc.nextInt();
                 switch(c1)
                 {
                 case 1:
                     ias.updateBooks();
                     break;
                 case 2:
                     ias.getListOfBooks();
                     break;
                 case 3:
                     ias.getBalance();
                     break;
                 case 4:
                     ias.closeUserAccount();
                     break;
                 case 5:
                     ius.closeSystem();
                    System.exit(0);
                    break;
                     
                 }
                 
                 }
        
                
            case 2:
                System.out.println("enter user id");
                A1=sc.next();
                System.out.println("enter user password");
                P1=sc.next();
                ius.verifydetails(A1, P1);
                while(true)
                {    
                System.out.println("1.Issue book from library");
                System.out.println("2.getListOfBooks by particular author");
                System.out.println("3.available balance in library");
                System.out.println("4.close System ");
                System.out.println("enter the choice :");
                c1=sc.nextInt();
                switch(c1)
                {
                case 1:
                    ius.getBooksLibrary();
                    break;
                case 2:
                    ius.getListOfbooks();
                    break;
                    
                case 3:
                    ius.availableBalance();
                    break;
                case 4:
                    ius.closeSystem();
                    System.exit(0);
                    break;
                }
                
                }
            case 3:
                ius.closeSystem();
                System.exit(0);
                break;
                
            }
            
            
        }
        
        
    }

 

}
