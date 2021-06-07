package com.solvd.ATMproject.dao.jdbs.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBSDao;
import com.solvd.ATMproject.dao.interfaces.IOperation;
import com.solvd.ATMproject.models.Operation;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperationDAO extends AbstractJDBSDao implements IOperation {
    private final static Logger LOGGER = LogManager.getLogger(CardDAO.class);
    private final String GET_OPERATION = "SELECT operationName, idOperation FROM Operation";
    private final String GET_OPERATION_BY_ID = "SELECT idOperation, operationName  FROM Operation WHERE idOperation  = ?";

    @Override
    public void create(Operation entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }

    @Override
    public void update(Operation entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }

    @Override
    public Operation getById(int id) {throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());

    }

    @Override
    public void delete(Operation entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }

    public Operation readOperation() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Operation operation = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_OPERATION);
            resultSet = preparedStatement.executeQuery();
            LOGGER.debug("List of operations: ");
            if (resultSet.next()) {
                operation = new Operation();
                operation.setIdOperation(resultSet.getInt(1));
                operation.setOperationName(resultSet.getString(2));
                LOGGER.debug("Operation: "+ operation);
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
        return operation;
    }

    @Override
    public Operation read(Integer idOperation) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Operation operation = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_OPERATION);
            preparedStatement.setInt(1, idOperation);
            resultSet = preparedStatement.executeQuery();
            LOGGER.debug("Request was successful.");
            if (resultSet.next()) {
                operation = new Operation();
                operation.setIdOperation(resultSet.getInt(1));
                operation.setOperationName(resultSet.getString(2));
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
        return operation;
    }
}
