package Project;

import java.sql.*;
import java.util.Scanner;


public class StudentManager {
    public static void main(String[] args) {
        try
        {
           Class.forName(DBConfig.className);
           Connection connection  = DriverManager.getConnection(DBConfig.url,DBConfig.user,DBConfig.password);
           Scanner sc  = new Scanner(System.in);

           while(true)
           {
               System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");

               System.out.println("1. Insert Student");
               System.out.println("2. Update Marks");
               System.out.println("3. Delete Student");
               System.out.println("4. Search Student");
               System.out.println("5. EXIT");

               System.out.println("Enter your choice ");
               int choice  = sc.nextInt();

               switch (choice)
               {
                   case 1: // Insert

                       System.out.println("Enter the roll no. ");
                       int rollno = sc.nextInt();
                       System.out.println("Enter name : ");
                       String name  = sc.next();
                       System.out.println("Enter the Marks : ");
                       double marks = sc.nextDouble();

                       String query  = "insert into RowCol values(?,?,?)";
                       PreparedStatement ps1 = connection.prepareStatement(query);

                       ps1.setInt(1,rollno);
                       ps1.setString(2,name);
                       ps1.setDouble(3,marks);

                       int rows = ps1.executeUpdate();

                       System.out.println(rows + " record inserted");
                       break;

                   case 2: //Update

                       System.out.println("Enter roll no to Update : ");
                       int roll = sc.nextInt();
                       System.out.println("Enter New Marks");
                       double newMarks = sc.nextDouble();
                       System.out.println();

                       PreparedStatement ps2 = connection.prepareStatement("update RowCol set marks = ? where rollno = ?");
                       ps2.setDouble(1,newMarks);
                       ps2.setInt(2,roll);

                       int updated = ps2.executeUpdate();

                       System.out.println();

                       if(updated>0)
                       {
                           System.out.println("Record Updated.");
                       }
                       else {
                           System.out.println("Roll No. not  found");
                       }
                       break;

                   case 3: //Delete

                       System.out.println("Enter the roll no. to Delete : ");
                       int rn = sc.nextInt();

                       PreparedStatement ps3 = connection.prepareStatement("Delete from RowCol where rollno = ? ");
                       ps3.setInt(1,rn);
                       int delete = ps3.executeUpdate();

                       if(delete>0)
                       {
                           System.out.println("Deleted Successfully.");
                       }
                       else
                       {
                           System.out.println("Deletion Failed.");
                       }
                       break;

                   case 4: // Search
                       System.out.println("Enter roll no. to Search : ");
                       int r = sc.nextInt();
                       PreparedStatement ps4 = connection.prepareStatement("select * from RowCol where rollno=?");
                       ps4.setInt(1,r);

                       ResultSet rs = ps4.executeQuery();
                       if(rs.next())
                       {
                           System.out.println("Data Found : " + rs.getInt(1) + " | " + rs.getString(2) + " | "+ rs.getDouble(3));
                       }
                       else
                       {
                           System.out.println("Student not found");
                       }

                       break;

                   case 5: // Exit
                       System.out.println("Program Execution Successfully Done: \n ======= PROGRAM CLOSED =========");
                       System.exit(0);

                   default:
                       System.out.println("Invalid choice. Please try again. ");
               }
           }


        }
        catch (SQLException e)
        {
            System.out.println("Database Error: " + e.getMessage());
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}
