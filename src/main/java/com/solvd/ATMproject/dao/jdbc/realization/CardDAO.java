package com.solvd.ATMproject.dao.jdbc.realization;

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
    public Card read(String cardNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Card card = null;
        try {
            connection = getConnectionPool().takeConnection();
            preparedStatement = connection.prepareStatement(GET_BY_ID_CARD);
            preparedStatement.setString(1, cardNumber);
            resultSet = preparedStatement.executeQuery();
            LOGGER.debug("Request was successful.");
            if (resultSet.next()) {
                card = new Card();
                card.setStatus(resultSet.getString("cardNumber"));
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
    public Card getById(int id) {
        throw new UnsupportedOperationException();
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
    public void delete(Card entity) {
        throw new UnsupportedOperationException();
    }
}
