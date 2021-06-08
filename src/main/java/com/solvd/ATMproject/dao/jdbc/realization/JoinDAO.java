package com.solvd.ATMproject.dao.jdbc.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBSDao;
import com.solvd.ATMproject.dao.interfaces.IJoinDAO;
import com.solvd.ATMproject.models.ATM;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class JoinDAO extends AbstractJDBSDao implements IJoinDAO {
    private String GET_BY_ID_ATM = "SELECT ATMsIdATMs FROM Address Ad JOIN ATMs A ON (Ad.ATMsIdATMs=A.idATMs)";
    @Override
    public void create(ATM entity) {

    }

    @Override
    public void update(ATM entity) {

    }

    @Override
    public ATM getById(int id) {
        return null;
    }

    @Override
    public void delete(ATM entity) {

    }

    @Override
    public ATM read(String s) {
        return null;
    }

    @Override
    public ATM getAtmByStreet(String street) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            ATM atm = null;
            try {
                connection = getConnectionPool().takeConnection();
                preparedStatement = connection.prepareStatement(GET_BY_ID_ATM);
                preparedStatement.setString(1, street);
                resultSet = preparedStatement.executeQuery();
                log.debug("Request was successful.");
                if (resultSet.next()) {
                    atm = new ATM();
                    atm.setIdATM(resultSet.getInt("id ATM"));
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
            return atm;
        }
    }

