
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connn {
   Connection connection;
   Statement statement;

   public Connn() {
      try {
         this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_123", "root", "");
         this.statement = this.connection.createStatement();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}




