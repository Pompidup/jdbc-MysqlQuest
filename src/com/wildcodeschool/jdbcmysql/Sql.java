package com.wildcodeschool.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Sql {
    public List<Jedi> getJediMaster(){
        List<Jedi> jedi1List = new ArrayList<Jedi>();
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");


        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        Connection connect = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password");
            statement = connect.createStatement();
            result = statement.executeQuery("SELECT * FROM jedi_masters");

            while (result.next() ){

                String name = result.getString("name");
                String surname = result.getString("surname");
                Jedi jedis = new Jedi();
                jedis.setName(name);
                jedis.setSurname(surname);
                jedi1List.add(jedis);

            }
        }
        catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        finally {

            try {
                if(result != null)
                    result.close();
                if(statement != null)
                    statement.close();
                if(connect != null)
                    connect.close();
            }catch(SQLException ignore) {
                System.out.println(ignore);
            }

        }
        return jedi1List;
    }
}
