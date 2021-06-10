package com.solvd.ATMproject.dao.jdbc.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBCDao;
import com.solvd.ATMproject.dao.interfaces.IAtmDAO;
import com.solvd.ATMproject.models.ATM;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class AtmDAO extends AbstractJDBCDao implements IAtmDAO {
    private String GET_BY_ID = "SELECT commission FROM ATMs WHERE idATMs = ?";


    @Override
    public ATM getById(int idATMs) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ATM atm = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, idATMs);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                atm = new ATM();
                atm.setCommission(resultSet.getInt("commission"));
            }
        } catch (SQLException ex) {
            log.error("Error:" + ex);
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException ex) {
                log.error(ex);
            }
            getConnectionPool().returnConnection(connection);
        }
        return atm;
    }

    @Override
    public void delete(ATM entity) {

        throw new UnsupportedOperationException();
    }

    @Override
    public ATM read(Integer integer) {
        return null;
    }

    @Override
    public void create(ATM entity) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void update(ATM entity) {

        throw new UnsupportedOperationException();
    }
}


