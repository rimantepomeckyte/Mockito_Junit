import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    StudentDAOI studentDAOI;

    public StudentDAO(StudentDAOI studentDAOI){
        this.studentDAOI = studentDAOI;
    }
    public Student searchById(int id) {
        Student student = this.studentDAOI.searchById(id);
        return student;
    }


    public void insert(Student student) {
        String query = "INSERT INTO students (name,school,group2,average2) VALUES (?,?,?,?)";


        String url = "jdbc:mysql://localhost:3306/db";

        try {
            Connection jungtis = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = jungtis.prepareStatement(query);
            st.setString(1, student.getVardas());
            st.setString(2, student.getMokykla());
            st.setString(3, student.getGrupe());
            st.setDouble(4, student.getVidurkis());

            st.executeUpdate();
            st.close();  // uzdaroma prisijungimas prie db


            System.out.println("Duomenys iterpti sekmingai");
        } catch (SQLException e) {
            System.out.println("Total FAIL");
            e.printStackTrace();
        }
    }

    public void update(Student student) {

        String query = "Update students  SET name=?,school=?,group2=?,average2=? WHERE id=?";
        String url = "jdbc:mysql://localhost:3306/db";

        try {
            Connection jungtis = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = jungtis.prepareStatement(query);
            st.setString(1, student.getVardas());
            st.setString(2, student.getMokykla());
            st.setString(3, student.getGrupe());
            st.setDouble(4, student.getVidurkis());
            st.setInt(5,student.getId());

            st.executeUpdate();
            st.close();  // uzdaroma prisijungimas prie db

            System.out.println("Duomenys readaguoti sekmingai");
        } catch (SQLException e) {
            System.out.println("Duomenu readagavimas nepavyko");
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String query = "DELETE FROM students WHERE id=?";
        String url = "jdbc:mysql://localhost:3306/db";

        try {
            Connection jungtis = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = jungtis.prepareStatement(query);
            st.setInt(1, id);

            st.executeUpdate();
            st.close();  // uzdaroma prisijungimas prie db

            System.out.println("Duomenys istrinti sekmingai");
        } catch (SQLException e) {
            System.out.println("Duomenu istrinti nepavyko");
            e.printStackTrace();
        }
    }
}
