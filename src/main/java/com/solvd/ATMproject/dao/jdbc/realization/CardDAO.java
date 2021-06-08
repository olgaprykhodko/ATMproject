package com.solvd.ATMproject.dao.jdbc.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBCDao;
import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.models.Card;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class CardDAO extends AbstractJDBCDao implements ICardDAO {
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
            log.debug("Request was successful.");
            if (resultSet.next()) {
                card = new Card();
                card.setStatus(resultSet.getString("cardNumber"));
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
