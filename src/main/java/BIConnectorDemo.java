import java.sql.*;

public class BIConnectorDemo {

    //Update with your configs:
    private static final String dbUser = "test_user";
    private static final String dbPassword = "test_password";
    private static final String host = "democluster-biconnector.2e57g.mongodb.net";
    private static final String port = "27015";
    private static final String db = "test";

    public static void main(final String[] args) {
        String URL = "jdbc:mysql://"+host+":"+port+"/"+db+"?useSSL=true&enabledTLSProtocols=TLSv1.2";
        try {
            java.util.Properties p = new java.util.Properties();
            p.setProperty("user", dbUser);
            p.setProperty("password", dbPassword);
            Connection conn = DriverManager.getConnection(URL, p);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show tables");
            System.out.println("List of tables for "+db+" database:");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

