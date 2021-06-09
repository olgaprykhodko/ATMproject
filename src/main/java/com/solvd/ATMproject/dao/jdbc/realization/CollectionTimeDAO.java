package com.solvd.ATMproject.dao.jdbc.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBCDao;
import com.solvd.ATMproject.dao.interfaces.IDateDAO;
import com.solvd.ATMproject.models.CashCollection;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Date;

@Log4j2
public class CollectionTimeDAO extends AbstractJDBCDao implements IDateDAO {
    private String GET_TIME = "SELECT Schedule FROM CashCollection WHERE Schedule = ?";


    @Override
    public void create(CashCollection entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(CashCollection entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CashCollection getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(CashCollection entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CashCollection read(Date schedule) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CashCollection collection = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_TIME);
            preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                collection = new CashCollection();
                collection.setSchedule(resultSet.getDate("schedule"));
            }
        } catch (SQLException ex) {
            log.error("Error:" + ex);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                log.error(ex);
            }
            getConnectionPool().returnConnection(connection);
        }
        return collection;
    }
}
