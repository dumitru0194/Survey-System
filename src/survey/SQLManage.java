package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManage {
    Connection con;

    public SQLManage()throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,user,password);
    }

    public void newUser(String name, String uname, String pass) throws SQLException{
        String str = "INSERT INTO actors(fname, uname, pass) VALUES ('" + name + "','" + uname + "','" + pass + "');";
        Statement stm = con.createStatement();
        stm.executeUpdate(str);
    }

    public int authUser(String uname, String pass) throws SQLException{
        String str = "SELECT * FROM actors WHERE uname = '" + uname + "'";
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(str);
        if(!rst.next()){
            return -1;
        } else {
            if(rst.getString("pass").equals(pass)){
                return rst.getInt("id");
            } else {
                return 0;
            }
        }
    }

    public void newQuestion(String code, String question, String op1, String op2, String op3, String op4) throws SQLException{
        String str = "INSERT INTO questions VALUES ('" + code + "','" + question + "','" + op1 +"', '" + op2 +"', '" + op3 +"', '" + op4 +"')";
        Statement stm = con.createStatement();
        stm.executeUpdate(str);
    }

}
