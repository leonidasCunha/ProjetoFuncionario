package javafxmvc.model.dao;

import java.sql.Connection;


public class EmpregadoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

   
}
