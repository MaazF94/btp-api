package com.btp.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.btp.common.DbConnector;
import com.btp.models.NavBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfCategoriesService {

    @Autowired
    private DbConnector dbc;

    public ArrayList<NavBar> getProfessions() {
        ArrayList<NavBar> navBarLst = new ArrayList<NavBar>();
        try {
            CallableStatement cs = dbc.getConn().prepareCall("{call dbo.GET_PROFESSIONS}");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            int count = 0;
            while (rs.next()) {
                if (navBarLst.size() > 0) {
                    // if id is same as previous, don't create new obj. add profession to same obj
                    if (navBarLst.get(count - 1).getCareerCategoryId() == rs.getInt("career_category_id")) {
                        ArrayList<String> profession = new ArrayList<String>();
                        profession.add(navBarLst.get(count - 1).getProfessionName().toString().replace("[", "")
                                .replace("]", ""));
                        profession.add(rs.getString("profession_name"));
                        navBarLst.get(count - 1).setProfessionName(profession);
                    } else {
                        ArrayList<String> profession = new ArrayList<String>();
                        profession.add(rs.getString("profession_name"));
                        NavBar navBar = new NavBar(rs.getInt("career_category_id"), rs.getString("category_name"),
                                profession);
                        navBarLst.add(navBar);
                        count++;
                    }
                    // first row
                } else {
                    ArrayList<String> profession = new ArrayList<String>();
                    profession.add(rs.getString("profession_name"));
                    NavBar navBar = new NavBar(rs.getInt("career_category_id"), rs.getString("category_name"),
                            profession);
                    navBarLst.add(navBar);
                    count++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return navBarLst;
    }
}