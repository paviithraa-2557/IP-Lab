/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unique;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Triesha Kenneth
 */
@WebService(serviceName = "EmpInfoWS")
public class EmpInfoWS {

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getInfo")
    public Vector getInfo(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Vector v=new Vector();
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/EmpDB");
            Statement st=con.createStatement();
            String sql="";
            sql = "select name, mark from students where id = " + id;
        
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                v.addElement(rs.getString(1));
                v.addElement(rs.getInt(2));
                
            }
                
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
        return v;
    }
    

    /**
     * This is a sample web service operation
     */
    
}
