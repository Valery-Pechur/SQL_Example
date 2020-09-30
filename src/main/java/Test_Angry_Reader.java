import java.sql.*;
import java.util.List;

public class Test_Angry_Reader {
    static List<Angry_Reader> angryReaderList;
    //«Злостный читатель» - читатель, которые максимальное количество раз обратился за книгами

    public static void main(String [] args) {

        String query = "SELECT student_id, last_name, first_name, NVL(Faculty, ‘No data’), NVL(Course_of_institute, ‘No data’)\n" +
                "FROM Students\n" +
                "WHERE Student_id IN (SELECT Student_id\n" +
                                      "FROM Accounting_of_books\n" +
                                      "GROUP BY Student_id\n" +
                                      "HAVING COUNT(*) = (SELECT MAX(COUNT(*))\n" +
                                      "FROM Accounting_of_books\n" +
                                      "GROUP BY Student_id))";

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb2", "hr", "hr")) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Angry_Reader ag = new Angry_Reader();
                    ag.setId(rs.getInt(1));
                    ag.setLastName(rs.getString(2));
                    ag.setFirstName(rs.getString(3));
                    ag.setFaculty(rs.getString(4));
                    ag.setCourse(rs.getInt(5));

                    angryReaderList.add(ag);
                }
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }
