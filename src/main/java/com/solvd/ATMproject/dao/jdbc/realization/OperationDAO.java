package com.solvd.ATMproject.dao.jdbc.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBCDao;
import com.solvd.ATMproject.dao.interfaces.IOperation;
import com.solvd.ATMproject.models.Operation;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class OperationDAO extends AbstractJDBCDao implements IOperation {
    private final String GET_OPERATION = "SELECT operationName, idOperation FROM Operations";
    private final String GET_OPERATION_BY_ID = "SELECT idOperations, operationName FROM Operations WHERE idOperations = ?";

    @Override
    public void create(Operation entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Operation entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Operation getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Operation entity) {
        throw new UnsupportedOperationException();
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
            log.debug("List of operations: ");
            if (resultSet.next()) {
                operation = new Operation();
                operation.setIdOperation(resultSet.getInt(1));
                operation.setOperationName(resultSet.getString(2));
                log.debug("Operation: " + operation);
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
            preparedStatement = connection.prepareStatement(GET_OPERATION_BY_ID);
            preparedStatement.setInt(1, idOperation);
            resultSet = preparedStatement.executeQuery();
            log.debug("Request was successful.");
            if (resultSet.next()) {
                operation = new Operation();
                operation.setIdOperation(resultSet.getInt(1));
                operation.setOperationName(resultSet.getString(2));
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
        return operation;
    }
}
