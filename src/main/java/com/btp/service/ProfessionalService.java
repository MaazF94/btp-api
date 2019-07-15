package com.btp.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
        cs = dbc.getConn().prepareCall("{call dbo.REGISTER_PROFESSIONAL(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
        cs.setString("full_name", professional.getFullName());
        cs.registerOutParameter("professional_id", Types.INTEGER);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            professionalId = rs.getInt("professional_id");
        }

        return professionalId;
	}

	public List<Professional> getSearchResult(String searchQuery) throws SQLException {
        CallableStatement cs;
        List<Professional> searchResult = new ArrayList<Professional>();
        Professional professional = null;

        cs = dbc.getConn().prepareCall("{call dbo.GET_SEARCH_RESULT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString("search_query", searchQuery);
        cs.registerOutParameter("user_id", Types.INTEGER);
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

        ResultSet rs = cs.executeQuery();
    
            while (rs.next()) {
                professional = new Professional(rs.getInt("professional_id"),rs.getInt("user_id"),rs.getString("company_name"),
                                        rs.getInt("is_active"),rs.getString("category_name"),rs.getString("profession_name"),
                                        rs.getString("job_title"), rs.getFloat("avg_rating"),rs.getInt("years_of_experience"),
                                        rs.getInt("queue_size"),rs.getInt("reply_time"),rs.getString("about_me"),
                                        rs.getString("job_description"), rs.getString("full_name"));
                searchResult.add(professional);
            }
		return searchResult;
	}

}