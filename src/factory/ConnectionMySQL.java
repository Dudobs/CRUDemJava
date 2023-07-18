package factory;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CrudJava";

    /*
     * Conexão com o banco de dados
     */
    public static Connection createConnectionToMySQL() throws Exception {
        /*
        Faz com que a classe seja carregada pela JVM
            //Class.forName("com.mysql.jdbc.Driver");
        Na versão mais recente do driver JDBC do MySQL, não é necessário carregar manualmente a classe do driver
        usando Class.forName("com.mysql.jdbc.Driver"). O registro automático do driver é feito por meio do SPI do JDBC.
        */

        //Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {

        //Recuperar uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //Testar se a conexão é nula
        if(con!=null) {
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }
    }
}
