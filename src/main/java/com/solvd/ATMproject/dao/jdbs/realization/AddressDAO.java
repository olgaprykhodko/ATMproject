package com.solvd.ATMproject.dao.jdbs.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBSDao;
import com.solvd.ATMproject.dao.interfaces.IAddressDAO;
import com.solvd.ATMproject.models.Address;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class AddressDAO extends AbstractJDBSDao implements IAddressDAO {

    private final static String INSERT_ADDRESS = "INSERT INTO ADDRESS (country, city, street) VALUES (?, ?, ?)";
    private final static String GET_ADDRESS_BY_STREET = "SELECT * FROM ADDRESS WHERE Street = ?";

    @Override
    public void create(Address entity) {
        Connection con = getConnectionPool().takeConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Address address = null;
        try {
            ps = con.prepareStatement(INSERT_ADDRESS);
            ps.setString(1, entity.getCountry());
            ps.setString(2, entity.getCity());
            ps.setString(2, entity.getStreet());
            ps.executeUpdate();
            log.debug("Request was successful.");
            if (rs.next()) {
                address = new Address();
                log.debug("Model address get value from Data base");
                address.setCountry(rs.getString("id"));
                address.setStreet(rs.getString("street"));
                address.setCity(rs.getString("city"));
            }
        } catch (SQLException ex) {
            log.error("Error:" + ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                log.error(ex);
            }
            getConnectionPool().returnConnection(con);
        }
    }

    @Override
    public void update(Address entity) {
        Connection con = getConnectionPool().takeConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(GET_ADDRESS_BY_STREET);
            ps.setString(1, entity.getStreet());
            ps.executeUpdate();
            log.debug("Request was completed");
        } catch (SQLException ex) {
            log.error("Error:" + ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                log.error(ex);
            }
            getConnectionPool().returnConnection(con);
        }
    }

    @Override
    public void add(Address entity) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT_ADDRESS);
            log.debug("Determine the values of the parameters");
            ps.setString(1, entity.getCountry());
            ps.setString(2, entity.getCity());
            ps.setString(3, entity.getStreet());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Execute error", e);
        } finally {
            getConnectionPool().returnConnection(con);
            log.debug("Connection returned to the pool");
            try {
                if (ps != null) {
                    ps.close();
                }
                log.debug("result and statement are closed");
            } catch (SQLException e) {
                log.error("Closing error", e);
            }
        }
    }

    @Override
    public Address read(String street) {
        Connection con = getConnectionPool().takeConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Address address = null;
        try {
            ps = con.prepareStatement(GET_ADDRESS_BY_STREET);
            ps.setString(1, street);
            rs = ps.executeQuery();
            log.debug("Request was successful.");
            if (rs.next()) {
                address = new Address();
                address.setStreet(rs.getString("street"));
            }
        } catch (SQLException ex) {
            log.error("Error:" + ex);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                log.error(ex);
            }
            getConnectionPool().returnConnection(con);
        }
        return address;
    }

    @Override
    public Address getById(int id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public void delete(Address entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }
}
