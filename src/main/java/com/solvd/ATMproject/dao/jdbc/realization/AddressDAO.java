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

    private final static String GET_ADDRESS_BY_STREET = "SELECT ATMsIdATMs FROM Address WHERE street = ?";


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
            if (rs.next()) {
                address = new Address();
                address.setIdATM(rs.getInt("ATMsIdATMs"));
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
    @Override
    public void create(Address entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }

    @Override
    public void update(Address entity) {
        throw new NotImplementedException("Method 'delete' not implemented for " + this.getClass());
    }

    @Override
    public Address getById(int id) {
        return null;
    }
}
