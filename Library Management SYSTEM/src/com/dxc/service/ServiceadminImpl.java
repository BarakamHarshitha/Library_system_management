package com.dxc.service;

 

import com.dxc.dao.DaoadminImpl;
import com.dxc.dao.Idaoadmin;

 

public class ServiceadminImpl implements Iseviceadmin
{
    Idaoadmin iad=new DaoadminImpl();
    public void verifydetails(String a,String p)
    {
        iad.verifydetails(a,p);
        
    }
    public void updateBooks()
    {
        iad.updateBooks();
    }
    public void getListOfBooks()
    {
        iad.getListOfBooks();
    }
    public void getBalance()
    {
        iad.getBalance();
    }
    public void closeUserAccount() 
    {
        iad.closeUserAccount();        
    }

 

}
 