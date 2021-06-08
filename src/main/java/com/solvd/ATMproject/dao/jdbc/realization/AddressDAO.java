package com.solvd.ATMproject.dao.jdbc.realization;

import com.solvd.ATMproject.dao.abstractClasses.AbstractJDBCDao;
import com.solvd.ATMproject.dao.interfaces.IAddressDAO;
import com.solvd.ATMproject.models.Address;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class AddressDAO extends AbstractJDBCDao implements IAddressDAO {

    private final static String INSERT_ADDRESS = "INSERT INTO ADDRESS (country, city, street) VALUES (?, ?, ?)";
    private final static String GET_ADDRESS_BY_STREET = "SELECT * FROM address WHERE street = ?";

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
    public Address getById(int id) {
        return null;
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
                address.setIdATM(rs.getInt("idATMs"));
                log.debug("Id ATMs" + address);
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
    public void delete(Address entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }
}
