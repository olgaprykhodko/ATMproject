package com.solvd.ATMproject.dao.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBSDao;
import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.models.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO extends AbstractJDBSDao implements ICardDAO {
    private final static Logger LOGGER = LogManager.getLogger(CardDAO.class);
    private String GET_BY_ID_CARD = "SELECT status FROM cards WHERE UsersIdUsers = ?";

    @Override
    public Card getById(int idUsers) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Card card = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_BY_ID_CARD);
            preparedStatement.setInt(1, idUsers);
            resultSet = preparedStatement.executeQuery();
            LOGGER.debug("Request was successful.");
            if (resultSet.next()) {
                card = new Card();
                card.setBalance(resultSet.getInt("balance"));
                card.setStatus(resultSet.getString("status"));
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
        return card;
    }

    @Override
    public void create(Card entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Card entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Card getById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Card entity) {
        throw new UnsupportedOperationException();
    }
}
