package com.solvd.ATMproject.dao.abstractClass;

import com.solvd.ATMproject.dao.pool.ConnectionPool;

public class AbstractJDBSDao {
    private ConnectionPool connectionPool = ConnectionPool.newInstance();

    protected ConnectionPool getConnectionPool() {

        return this.connectionPool;
    }
}
