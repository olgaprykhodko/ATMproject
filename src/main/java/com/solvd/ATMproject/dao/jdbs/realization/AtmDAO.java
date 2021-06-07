package com.solvd.ATMproject.dao.jdbs.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBSDao;
import com.solvd.ATMproject.dao.interfaces.IAtmDAO;
import com.solvd.ATMproject.models.ATM;
import com.solvd.ATMproject.models.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtmDAO extends AbstractJDBSDao implements IAtmDAO {
    private final static Logger LOGGER = LogManager.getLogger(AtmDAO.class);
    private String GET_BY_BANKNOTE = "SELECT commission FROM ATMs WHERE banknote = ?";

    @Override
    public ATM read(String currency) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ATM atm = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_BY_BANKNOTE);
            preparedStatement.setString(1, currency);
            resultSet = preparedStatement.executeQuery();
            LOGGER.debug("Request was successful.");
            if (resultSet.next()) {
                atm = new ATM();
                atm.setCommission(resultSet.getInt("commission"));
            }
        } catch (SQLException ex) {
            LOGGER.error("Error:" + ex);
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException ex) {
                LOGGER.error(ex);
            }
            getConnectionPool().returnConnection(connection);
        }
        return atm;
    }

    @Override
    public void create(ATM entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(ATM entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ATM getById(int id) {
        return null;
    }

    @Override
    public void delete(ATM entity) {
        throw new UnsupportedOperationException();
    }
}
