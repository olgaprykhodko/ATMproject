package com.solvd.ATMproject.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
    private final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static final int MAX_POOL_SIZE = 5;
    private static ConnectionPool connectionPool;
    private static final ArrayList<Connection> freeConnections = new ArrayList<>(MAX_POOL_SIZE);
    private static final ArrayList<Connection> usedConnections = new ArrayList<>(MAX_POOL_SIZE);

    private ConnectionPool() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionPool newInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public synchronized Connection takeConnection() {
        int connectionsAmount = freeConnections.size() + usedConnections.size();
        Connection connection = null;
        if (connectionsAmount == 0 || (connectionsAmount < 5 && freeConnections.size() == 0)) {
            try {
                connection = DriverManager.getConnection("JDBC:mysql://127.0.0.1:3306/solvd?user=root&password=1qaz2WSX_");
                usedConnections.add(connection);
            } catch (SQLException ex) {
                LOGGER.error("SQL error", ex);
            }
        } else if (connectionsAmount <= 5 && freeConnections.size() > 0) {
            usedConnections.add(freeConnections.get(0));
            connection = freeConnections.remove(0);
        }
        return connection;
    }

    public synchronized void returnConnection(Connection connection) {
        freeConnections.add(connection);
        usedConnections.remove(connection);
    }
}
