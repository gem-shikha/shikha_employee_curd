package com.spring.curd.withJdbc;

import java.sql.*;
import java.util.Scanner;

public class SpringWithJdbc {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shikha_db";

    //  mysql database credentials
    static final String USER_NAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("JDBC Data Interaction without Spring\n");
        // variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = null;
        try{
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            // create SQL statement and fire query
            System.out.println("ID\t\t\t\tNAME\t\t\t\tDEPARTMENT\t\t\t\t\t\tGRADE");
            System.out.println("=======================================================================");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter what you want to do:");
            System.out.println("Press 1 for Insert");
            System.out.println("Press 2 for Update");
            System.out.println("Press 3 for Delete");
            System.out.println("Press 4 for fetch");
            int a = sc.nextInt();
            switch(a) {
                case 1:{
                    sql="INSERT INTO employee_table (name, department, grade) VALUES (?, ?, ?, ?)";

                    PreparedStatement statement1=connection.prepareStatement(sql);
                    statement1.setInt(1,14);
                    statement1.setString(2,"Alax");
                    statement1.setString(3,"IT");
                    statement1.setString(4,"I1");
                    int inserInit = statement1.executeUpdate();
                    if(inserInit > 0){
                        System.out.println(inserInit +""+ "Row inserted successfully!");
                    }
                    break;
                }
                case 2: {
                    sql = "SELECT emp_id,name,department,grade FROM employee_table";
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sql);
                    // extracts resultset and get each value
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt(1)+"\t\t\t\t"+resultSet.getString(2)+"\t\t\t\t"+resultSet.getString(3)+"\t\t\t\t\t\t"+resultSet.getString(4));
                /*
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));*/
                    }
                    //

                }
                    break;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

}
