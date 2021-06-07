package com.solvd.ATMproject.dao.abstractClasses;

import com.solvd.ATMproject.pool.ConnectionPool;

public class AbstractJDBSDao {
    private ConnectionPool connectionPool = ConnectionPool.newInstance();

    protected ConnectionPool getConnectionPool() {

        return this.connectionPool;
    }
}
