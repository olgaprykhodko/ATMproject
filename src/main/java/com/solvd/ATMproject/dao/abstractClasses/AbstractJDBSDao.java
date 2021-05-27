package java.com.solvd.ATMproject.dao.abstractClasses;


import java.com.solvd.ATMproject.dao.pool.ConnectionPool;

public class AbstractJDBSDao {
    private ConnectionPool connectionPool = ConnectionPool.newInstance();

    protected ConnectionPool getConnectionPool() {

        return this.connectionPool;
    }
}
