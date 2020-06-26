package com.dxc.service;

 

import com.dxc.dao.Idaouser;
import com.dxc.dao.DaouserImpl;

 

public class ServiceuserImpl implements Iserviceuser
{
    Idaouser iua=new DaouserImpl();
    public void verifydetails(String a, String p)
    {
        iua.verifydetails(a,p);
    }
   public void getBooksLibrary()
    {
        iua.getBooksLibrary();
    }
    public void getListOfbooks()
    {
        iua.getListOfbooks();
    }
    public void availableBalance()
    {
        iua.availableBalance();
    }
    public void closeSystem()
    {
        iua.closeSystem();
    }

 

}
