package com.btp.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.btp.common.DbConnector;
import com.btp.models.Professional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {

    @Autowired
    private DbConnector dbc;

	public int createProfessional(Professional professional) throws SQLException {
        CallableStatement cs;
        int professionalId = 0;
        cs = dbc.getConn().prepareCall("{call dbo.REGISTER_PROFESSIONAL(?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setInt("user_id", professional.getUserId());
        cs.setString("company_name", professional.getCompanyName());
        cs.setInt("is_active", professional.getIsActive());
        cs.setString("category_name", professional.getCategoryName());
        cs.setString("profession_name", professional.getProfessionName());
        cs.setString("job_title", professional.getJobTitle());
        cs.setInt("years_of_experience", professional.getYearsOfExperience());
        cs.setInt("queue_size", professional.getQueueSize());
        cs.setInt("reply_time", professional.getReplyTime());
        cs.setString("about_me", professional.getAboutMe());
        cs.setString("job_description", professional.getJobDescription());
        cs.registerOutParameter("professional_id", Types.INTEGER);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            professionalId = rs.getInt("professional_id");
        }

        return professionalId;
	}

}