package com.btp.service;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.btp.common.DbConnector;
import com.btp.models.Professional;
import com.btp.models.User;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private DbConnector dbc;

    public void registerUser(User userInfo) throws SQLException {
        CallableStatement cs;
        String fullName = userInfo.getFullName();
        String email = userInfo.getEmail();
        String password = userInfo.getPassword();
        String school = userInfo.getSchool();
        int isActive = userInfo.getIsActive();
        cs = dbc.getConn().prepareCall("{call dbo.REGISTER_USER(?,?,?,?,?)}");
        cs.setString("full_name", fullName);
        cs.setString("email", email);
        cs.setString("password", password);
        cs.setString("school", school);
        cs.setInt("is_active", isActive);
        cs.execute();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = getByEmail(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new AccessDeniedException("User data is not available");
        }

        return user;
    }

    public synchronized User getByEmail(String email) throws SQLException {
        CallableStatement cs;
        User user = null;
        Professional professional = null;
        cs = dbc.getConn().prepareCall("{call dbo.GET_BY_EMAIL(?,?,?,?,?,?)}");
        cs.setString("email", email);
        cs.registerOutParameter("user_id", Types.INTEGER);
        cs.registerOutParameter("full_name", Types.VARCHAR);
        cs.registerOutParameter("password", Types.VARCHAR);
        cs.registerOutParameter("school", Types.VARCHAR);
        cs.registerOutParameter("is_active", Types.INTEGER);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            user = new User(rs.getInt("user_id"), rs.getString("full_name"), email,
            rs.getString("password"), rs.getString("school"), rs.getInt("is_active"), professional);
        }

        cs = dbc.getConn().prepareCall("{call dbo.GET_PROFESSIONAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setInt("user_id", user.getUserId());
        cs.registerOutParameter("professional_id", Types.INTEGER);
        cs.registerOutParameter("company_name", Types.VARCHAR);
        cs.registerOutParameter("is_active", Types.INTEGER);
        cs.registerOutParameter("category_name", Types.VARCHAR);
        cs.registerOutParameter("profession_name", Types.VARCHAR);
        cs.registerOutParameter("job_title", Types.VARCHAR);
        cs.registerOutParameter("avg_rating", Types.FLOAT);
        cs.registerOutParameter("years_of_experience", Types.INTEGER);
        cs.registerOutParameter("queue_size", Types.INTEGER);
        cs.registerOutParameter("reply_time", Types.INTEGER);
        cs.registerOutParameter("about_me", Types.VARCHAR);
        cs.registerOutParameter("job_description", Types.VARCHAR);
        cs.registerOutParameter("full_name", Types.VARCHAR);

        rs = cs.executeQuery();

        while (rs.next()) {
            professional = new Professional(rs.getInt("professional_id"),rs.getInt("user_id"),rs.getString("company_name"),
                                    rs.getInt("is_active"),rs.getString("category_name"),rs.getString("profession_name"),
                                    rs.getString("job_title"), rs.getFloat("avg_rating"),rs.getInt("years_of_experience"),
                                    rs.getInt("queue_size"),rs.getInt("reply_time"),rs.getString("about_me"),
                                    rs.getString("job_description"), rs.getString("full_name"));
        }

        if (professional != null) {
            user.setProfessional(professional);
        }

        return user;
    }

	public User loginUser(String email, String password) throws SQLException {
        CallableStatement cs;
        User user = null;
        Professional professional = null;

        cs = dbc.getConn().prepareCall("{call dbo.LOGIN_USER(?,?,?,?,?,?)}");
        cs.setString("email", email);
        cs.setString("password", password);
        cs.registerOutParameter("user_id", Types.INTEGER);
        cs.registerOutParameter("full_name", Types.VARCHAR);
        cs.registerOutParameter("school", Types.VARCHAR);
        cs.registerOutParameter("is_active", Types.INTEGER);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            user = new User(rs.getInt("user_id"), rs.getString("full_name"), email,
            password, rs.getString("school"), rs.getInt("is_active"), new Professional());
        }

        if (user != null) {
            cs = dbc.getConn().prepareCall("{call dbo.GET_PROFESSIONAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("user_id", user.getUserId());
            cs.registerOutParameter("professional_id", Types.INTEGER);
            cs.registerOutParameter("company_name", Types.VARCHAR);
            cs.registerOutParameter("is_active", Types.INTEGER);
            cs.registerOutParameter("category_name", Types.VARCHAR);
            cs.registerOutParameter("profession_name", Types.VARCHAR);
            cs.registerOutParameter("job_title", Types.VARCHAR);
            cs.registerOutParameter("avg_rating", Types.FLOAT);
            cs.registerOutParameter("years_of_experience", Types.INTEGER);
            cs.registerOutParameter("queue_size", Types.INTEGER);
            cs.registerOutParameter("reply_time", Types.INTEGER);
            cs.registerOutParameter("about_me", Types.VARCHAR);
            cs.registerOutParameter("job_description", Types.VARCHAR);
            cs.registerOutParameter("full_name", Types.VARCHAR);
    
            rs = cs.executeQuery();
    
            while (rs.next()) {
                professional = new Professional(rs.getInt("professional_id"),rs.getInt("user_id"),rs.getString("company_name"),
                                        rs.getInt("is_active"),rs.getString("category_name"),rs.getString("profession_name"),
                                        rs.getString("job_title"), rs.getFloat("avg_rating"),rs.getInt("years_of_experience"),
                                        rs.getInt("queue_size"),rs.getInt("reply_time"),rs.getString("about_me"),
                                        rs.getString("job_description"),rs.getString("full_name"));
            }
    
            if (professional != null) {
                user.setProfessional(professional);
            }
        }

        return user;
	}

}