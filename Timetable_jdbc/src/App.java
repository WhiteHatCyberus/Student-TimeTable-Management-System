import java.sql.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        int i;
        String databaseName = "timetable";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        String userName = "root";
        String password = "ADMIN";
        Connection con = null;
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(false);
            st = con.createStatement();
            Scanner sc = new Scanner(System.in);
        boolean x = true;
        boolean menu = true;
            do {
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Admin");
                System.out.println("2. Teacher");
                System.out.println("3. Student");
                System.out.println("0. Exit");
                System.out.print("Option: ");
                int option = Integer.parseInt(sc.nextLine());
                System.out.println();
                if (option == 1)
                {
                    int count = 0;
                    do {
                        
                        System.out.print("User name: ");
                        String userinput = sc.nextLine();
                        System.out.print("Password: ");
                        String userpass = sc.nextLine();
                        if (userinput.equals("admin") && userpass.equals("password")) {         //checks entered admin login matches the login data
                            System.out.println("Login Successful");
                            boolean adminchoice = true;
                            do {
                                System.out.println();
                                System.out.println("1. Delete");
                                System.out.println("2. Insert");
                                System.out.println("3. View");
                                System.out.println("0. Exit");
                                System.out.print("option: ");
                                int adminopt = Integer.parseInt(sc.nextLine());
                                System.out.println();
                                if (adminopt == 1)
                                {
                                    System.out.print("Enter the class: ");
                                    int adminclass = Integer.parseInt(sc.nextLine());
                                    System.out.print("Enter the day: ");
                                    int adminday = Integer.parseInt(sc.nextLine());
                                    System.out.print("Enter the hour: ");
                                    int adminhour = Integer.parseInt(sc.nextLine());
                                    int adminsub = 0;
                                    System.out.println();
                                    if (adminclass == 1)
                                    {
                                        if (adminhour == 1)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM atest";
                                            rs = st.executeQuery(query);
                                            while (i < adminday) {
                                                rs.next();
                                                i++;
                                            }
                                            adminsub = rs.getInt("h1");
                                            query = "UPDATE atest set h1 = ? WHERE d_aid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setNull(1, java.sql.Types.INTEGER);
                                            pst.setInt(2, adminday);
                                            pst.executeUpdate();
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (adminsub == 301)
                                            {
                                                query = "UPDATE mpmc set h1 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(adminsub == 302)
                                            {
                                                query = "UPDATE mss set h1 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(adminsub == 303)
                                            {
                                                query = "UPDATE ssoft set h1 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                            
                                        }
                                        else if (adminhour == 2)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM atest";
                                            rs = st.executeQuery(query);
                                            while (i < adminday) {
                                                rs.next();
                                                i++;
                                            }
                                            adminsub = rs.getInt("h2");
                                            query = "UPDATE atest set h2 = ? WHERE d_aid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setNull(1, java.sql.Types.INTEGER);
                                            pst.setInt(2, adminday);
                                            pst.executeUpdate();
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (adminsub == 301)
                                            {
                                                query = "UPDATE mpmc set h2 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(adminsub == 302)
                                            {
                                                query = "UPDATE mss set h2 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(adminsub == 303)
                                            {
                                                query = "UPDATE ssoft set h2 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else if (adminhour == 3)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM atest";
                                            rs = st.executeQuery(query);
                                            while (i < adminday) {
                                                rs.next();
                                                i++;
                                            }
                                            adminsub = rs.getInt("h3");
                                            query = "UPDATE atest set h3 = ? WHERE d_aid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setNull(1, java.sql.Types.INTEGER);
                                            pst.setInt(2, adminday);
                                            pst.executeUpdate();
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (adminsub == 301)
                                            {
                                                query = "UPDATE mpmc set h3 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(adminsub == 302)
                                            {
                                                query = "UPDATE mss set h3 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(adminsub == 303)
                                            {
                                                query = "UPDATE ssoft set h3 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else
                                            System.out.println("Invalid Input");
                                    }
                                    if (adminclass == 2)
                                    {
                                        if (adminhour == 1)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM btest";
                                            rs = st.executeQuery(query);
                                            while (i < adminday) {
                                                rs.next();
                                                i++;
                                            }
                                            adminsub = rs.getInt("h1");
                                            query = "UPDATE btest set h1 = ? WHERE d_bid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setNull(1, java.sql.Types.INTEGER);
                                            pst.setInt(2, adminday);
                                            pst.executeUpdate();
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (adminsub == 301)
                                            {
                                                query = "UPDATE mpmc set h1 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(adminsub == 302)
                                            {
                                                query = "UPDATE mss set h1 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(adminsub == 303)
                                            {
                                                query = "UPDATE ssoft set h1 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");

                                        }
                                        else if (adminhour == 2)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM btest";
                                            rs = st.executeQuery(query);
                                            while (i < adminday) {
                                                rs.next();
                                                i++;
                                            }
                                            adminsub = rs.getInt("h2");
                                            query = "UPDATE btest set h2 = ? WHERE d_bid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setNull(1, java.sql.Types.INTEGER);
                                            pst.setInt(2, adminday);
                                            pst.executeUpdate();
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (adminsub == 301)
                                            {
                                                query = "UPDATE mpmc set h2 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(adminsub == 302)
                                            {
                                                query = "UPDATE mss set h2 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(adminsub == 303)
                                            {
                                                query = "UPDATE ssoft set h2 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else if (adminhour == 3)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM btest";
                                            rs = st.executeQuery(query);
                                            while (i < adminday) {
                                                rs.next();
                                                i++;
                                            }
                                            adminsub = rs.getInt("h3");
                                            query = "UPDATE btest set h3 = ? WHERE d_bid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setNull(1, java.sql.Types.INTEGER);
                                            pst.setInt(2, adminday);
                                            pst.executeUpdate();
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (adminsub == 301)
                                            {
                                                query = "UPDATE mpmc set h3 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(adminsub == 302)
                                            {
                                                query = "UPDATE mss set h3 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(adminsub == 303)
                                            {
                                                query = "UPDATE ssoft set h3 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, null);
                                                pst.setInt(2, adminday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else
                                            System.out.println("Invalid Input");
                                    }
                                    else
                                        System.out.println("Invalid Input");
                                }
                                if (adminopt == 2) {
                                    System.out.print("Enter the class: ");
                                    int upclass = Integer.parseInt(sc.nextLine());
                                    System.out.print("Enter the day: ");
                                    int upday = Integer.parseInt(sc.nextLine());
                                    System.out.print("Enter the hour: ");
                                    int uphour = Integer.parseInt(sc.nextLine());
                                    System.out.print("Enter the subject code to insert: ");
                                    int intsub = Integer.parseInt(sc.nextLine());
                                    int upsub = 0;
                                    System.out.println();
                                    if (upclass == 1)
                                    {
                                        if (uphour == 1)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM btest";
                                            rs = st.executeQuery(query);
                                            while (i < upday) {
                                                rs.next();
                                                i++;
                                            }
                                            upsub = rs.getInt("h1");
                                            if (intsub == upsub) {
                                                System.out.println("Class conflict. Cannot update timetable");
                                                continue;
                                            }
                                            query = "UPDATE atest set h1 = ? WHERE d_aid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setInt(1, intsub);
                                            pst.setInt(2, upday);
                                            pst.executeUpdate();
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (intsub == 301)
                                            {
                                                query = "UPDATE mpmc set h1 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(intsub == 302)
                                            {
                                                query = "UPDATE mss set h1 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(intsub == 303)
                                            {
                                                query = "UPDATE ssoft set h1 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                            
                                        }
                                        else if (uphour == 2)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM btest";
                                            rs = st.executeQuery(query);
                                            while (i < upday) {
                                                rs.next();
                                                i++;
                                            }
                                            upsub = rs.getInt("h2");
                                            if (intsub == upsub) {
                                                System.out.println("Class conflict. Cannot update timetable");
                                                continue;
                                            }
                                            query = "UPDATE atest set h2 = ? WHERE d_aid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setInt(1, intsub);
                                            pst.setInt(2, upday);
                                            pst.executeUpdate();
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (intsub == 301)
                                            {
                                                query = "UPDATE mpmc set h2 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(intsub == 302)
                                            {
                                                query = "UPDATE mss set h2 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(intsub == 303)
                                            {
                                                query = "UPDATE ssoft set h2 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else if (uphour == 3)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM btest";
                                            rs = st.executeQuery(query);
                                            while (i < upday) {
                                                rs.next();
                                                i++;
                                            }
                                            upsub = rs.getInt("h3");
                                            if (intsub == upsub) {
                                                System.out.println("Class conflict. Cannot update timetable");
                                                continue;
                                            }
                                            query = "UPDATE atest set h3 = ? WHERE d_aid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setInt(1, intsub);
                                            pst.setInt(2, upday);
                                            pst.executeUpdate();
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (intsub == 301)
                                            {
                                                query = "UPDATE mpmc set h3 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(intsub == 302)
                                            {
                                                query = "UPDATE mss set h3 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(intsub == 303)
                                            {
                                                query = "UPDATE ssoft set h3 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class A");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else
                                            System.out.println("Invalid Input");
                                    }
                                    else if (upclass == 2)
                                    {
                                        if (uphour == 1)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM atest";
                                            rs = st.executeQuery(query);
                                            while (i < upday) {
                                                rs.next();
                                                i++;
                                            }
                                            upsub = rs.getInt("h1");
                                            if (intsub == upsub) {
                                                System.out.println("Class conflict. Cannot update timetable");
                                                continue;
                                            }
                                            query = "UPDATE btest set h1 = ? WHERE d_bid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setInt(1, intsub);
                                            pst.setInt(2, upday);
                                            pst.executeUpdate();
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (intsub == 301)
                                            {
                                                query = "UPDATE mpmc set h1 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(intsub == 302)
                                            {
                                                query = "UPDATE mss set h1 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(intsub == 303)
                                            {
                                                query = "UPDATE ssoft set h1 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");

                                        }
                                        else if (uphour == 2)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM atest";
                                            rs = st.executeQuery(query);
                                            while (i < upday) {
                                                rs.next();
                                                i++;
                                            }
                                            upsub = rs.getInt("h2");
                                            if (intsub == upsub) {
                                                System.out.println("Class conflict. Cannot update timetable");
                                                continue;
                                            }
                                            query = "UPDATE btest set h2 = ? WHERE d_bid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setInt(1, intsub);
                                            pst.setInt(2, upday);
                                            pst.executeUpdate();
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (intsub == 301)
                                            {
                                                query = "UPDATE mpmc set h2 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(intsub == 302)
                                            {
                                                query = "UPDATE mss set h2 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(intsub == 303)
                                            {
                                                query = "UPDATE ssoft set h2 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                            else
                                                System.out.println("Invalid Input");
                                        }
                                        else if (uphour == 3)
                                        {
                                            i = 0;
                                            query = "SELECT* FROM atest";
                                            rs = st.executeQuery(query);
                                            while (i < upday) {
                                                rs.next();
                                                i++;
                                            }
                                            upsub = rs.getInt("h3");
                                            if (intsub == upsub) {
                                                System.out.println("Class conflict. Cannot update timetable");
                                                continue;
                                            }
                                            query = "UPDATE btest set h3 = ? WHERE d_bid = ?";
                                            pst = con.prepareStatement(query);
                                            pst.setInt(1, intsub);
                                            pst.setInt(2, upday);
                                            pst.executeUpdate();
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                            System.out.println();
                                            if (intsub == 301)
                                            {
                                                query = "UPDATE mpmc set h3 = ? where d_id1 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mpmc";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idmp = rs.getInt("d_id1");
                                                    String daymp = rs.getString("day");
                                                    String h1mp = rs.getString("h1");
                                                    String h2mp = rs.getString("h2");
                                                    String h3mp = rs.getString("h3");
                                                    
                                                    System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                                    
                                                }
                                            }
                                            else if(intsub == 302)
                                            {
                                                query = "UPDATE mss set h3 = ? where d_id2 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from mss";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idms = rs.getInt("d_id2");
                                                    String dayms = rs.getString("day");
                                                    String h1ms = rs.getString("h1");
                                                    String h2ms = rs.getString("h2");
                                                    String h3ms = rs.getString("h3");
                                                    
                                                    System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                    
                                                }
                                            }
                                            else if(intsub == 303)
                                            {
                                                query = "UPDATE ssoft set h3 = ? where d_id3 = ?";
                                                pst = con.prepareStatement(query);
                                                pst.setString(1, "Class B");
                                                pst.setInt(2, upday);
                                                pst.executeUpdate();
                                                query = "Select* from ssoft";
                                                rs = st.executeQuery(query);
                                                while (rs.next()) {
                                                    int d_idss = rs.getInt("d_id3");
                                                    String dayss = rs.getString("day");
                                                    String h1ss = rs.getString("h1");
                                                    String h2ss = rs.getString("h2");
                                                    String h3ss = rs.getString("h3");
                                                    
                                                    System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                    
                                                }
                                            }
                                        }
                                        else
                                            System.out.println("Invalid Input");
                                    }
                                    else
                                        System.out.println("Invalid Input");
                                }
                                else if (adminopt == 3) {
                                    
                                    System.out.println("1. Teacher");
                                    System.out.println("2. Student");
                                    System.out.print("Enter choice: ");
                                    int views = Integer.parseInt(sc.nextLine());
                                    System.out.println();
                                    if (views == 1) {
                                        System.out.println("Teacher view");
                                        System.out.println();
                                        query = "Select* from subject";
                                        rs = st.executeQuery(query);
                                        while (rs.next()) {
                                            int subc = rs.getInt("subcode");
                                            String subn = rs.getString("subname");
                                            String tean = rs.getString("teachname");
                                            System.out.println(subc + " " + subn + " " + tean);
                                        }
                                        System.out.print("Enter subject code: ");
                                        int tsubcode = Integer.parseInt(sc.nextLine());
                                        System.out.println();
                                        if (tsubcode == 301) {
                                            query = "Select* from mpmc";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_idmp = rs.getInt("d_id1");
                                                String daymp = rs.getString("day");
                                                String h1mp = rs.getString("h1");
                                                String h2mp = rs.getString("h2");
                                                String h3mp = rs.getString("h3");
                                                System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                                            }
                                        }
                                        else if (tsubcode == 302) {
                                            query = "Select* from mss";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_idms = rs.getInt("d_id2");
                                                String dayms = rs.getString("day");
                                                String h1ms = rs.getString("h1");
                                                String h2ms = rs.getString("h2");
                                                String h3ms = rs.getString("h3");
                                                System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                                                
                                            }
                                        }
                                        else if (tsubcode == 303) {
                                            query = "Select* from ssoft";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_idss = rs.getInt("d_id3");
                                                String dayss = rs.getString("day");
                                                String h1ss = rs.getString("h1");
                                                String h2ss = rs.getString("h2");
                                                String h3ss = rs.getString("h3");
                                                
                                                System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                                                
                                            }
                                        }
                                        else
                                            System.out.println("Invalid input");
                                    }
                                    else if (views == 2) {
                                        System.out.println("Student view");
                                        System.out.print("Enter the class: ");
                                        int classcode = Integer.parseInt(sc.nextLine());
                                        System.out.println();
                                        if (classcode == 1) {
                                            System.out.println("Class A");
                                            query = "Select* from atest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_AID");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                
                                            }
                                        }
                                        else if (classcode == 2) {
                                            System.out.println("Class B");
                                            query = "Select* from btest";
                                            rs = st.executeQuery(query);
                                            while (rs.next()) {
                                                int d_id = rs.getInt("D_bid");
                                                String day = rs.getString("DAY");
                                                int h1 = rs.getInt("H1");
                                                int h2 = rs.getInt("H2");
                                                int h3 = rs.getInt("H3");
                                                
                                                System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                                                

                                            }
                                        }
                                        else
                                            System.out.println("Invalid Input");
                                    }
                                }
                                else if (adminopt == 0) {
                                    x = false;
                                    adminchoice = false;
                                }
                            } while (adminchoice == true);
                        }
                        else {
                            System.out.println("Login Unsuccessful");
                            count++;
                            if (count < 3)
                                System.out.println("Try again");
                            else {
                                System.out.println("Username or password incorrect. Returning to main menu...");
                                x = false;
                            }
                        }
                    }while (x == true);
                }
                else if (option == 2) {
                    System.out.println("Teacher view");
                    System.out.println();
                    query = "Select* from subject";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        int subc = rs.getInt("subcode");
                        String subn = rs.getString("subname");
                        String tean = rs.getString("teachname");
                        System.out.println(subc + " " + subn + " " + tean);
                    }
                    System.out.print("Enter subject code: ");
                    int tsubcode = Integer.parseInt(sc.nextLine());
                    System.out.println();
                    if (tsubcode == 301) {
                        query = "Select* from mpmc";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            int d_idmp = rs.getInt("d_id1");
                            String daymp = rs.getString("day");
                            String h1mp = rs.getString("h1");
                            String h2mp = rs.getString("h2");
                            String h3mp = rs.getString("h3");
                            
                            System.out.println(d_idmp + "  " + daymp + "  " + h1mp + "  " + h2mp + "  " + h3mp);
                            
                        }
                    }
                    else if (tsubcode == 302) {
                        query = "Select* from mss";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            int d_idms = rs.getInt("d_id2");
                            String dayms = rs.getString("day");
                            String h1ms = rs.getString("h1");
                            String h2ms = rs.getString("h2");
                            String h3ms = rs.getString("h3");
                            
                            System.out.println(d_idms + "  " + dayms + "  " + h1ms + "  " + h2ms + "  " + h3ms);
                            
                        }
                    }
                    else if (tsubcode == 303) {
                        query = "Select* from ssoft";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            int d_idss = rs.getInt("d_id3");
                            String dayss = rs.getString("day");
                            String h1ss = rs.getString("h1");
                            String h2ss = rs.getString("h2");
                            String h3ss = rs.getString("h3");
                            
                            System.out.println(d_idss + "  " + dayss + "  " + h1ss + "  " + h2ss + "  " + h3ss);
                            
                        }
                    }
                    else
                        System.out.println("Invalid input");
                }
                else if (option == 3) {
                    System.out.println("Student view");
                    System.out.print("Enter the class: ");
                    int classcode = Integer.parseInt(sc.nextLine());
                    System.out.println();
                    if (classcode == 1) {
                        System.out.println("Class A");
                        query = "Select* from atest";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            int d_id = rs.getInt("D_AID");
                            String day = rs.getString("DAY");
                            int h1 = rs.getInt("H1");
                            int h2 = rs.getInt("H2");
                            int h3 = rs.getInt("H3");
                            
                            System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                            
                        }
                    }
                    else if (classcode == 2) {
                        System.out.println("Class B");
                        query = "Select* from btest";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            int d_id = rs.getInt("D_bid");
                            String day = rs.getString("DAY");
                            int h1 = rs.getInt("H1");
                            int h2 = rs.getInt("H2");
                            int h3 = rs.getInt("H3");
                            
                            System.out.println(d_id + "  " + day + "  " + h1 + "  " + h2 + "  " + h3);
                            

                        }
                    }
                    else
                        System.out.println("Invalid Input");
                }
                else if (option == 0)
                    break;
                else
                    System.out.println("Incorrect Input");        
            }while (menu == true);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver Error");
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("Connection Error");
            e.printStackTrace();
        }
        finally {
            if (st != null)
                st.close();
            if (pst != null)
                pst.close();
            if (rs != null)
                rs.close();
            if (con != null)
                con.close();
        }
    }
}
