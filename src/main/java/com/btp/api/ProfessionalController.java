package com.btp.api;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.btp.models.Professional;
import com.btp.service.ProfessionalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessionalController {

    private static final Logger LOG = LoggerFactory.getLogger(ProfessionalController.class);

    @Autowired
    private ProfessionalService professionalService;

    @PostMapping(value="/createProfessional", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> registerUser(@RequestBody Professional professional) {
        LOG.info("professional: " + professional);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        int professionalId = 0;
        try {
            professionalId = professionalService.createProfessional(professional);
            returnMap.put("response", "");
            returnMap.put("professionalId", professionalId);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            returnMap.put("response", "Professional already exists");
            returnMap.put("professionalId", professionalId);
        }

        return returnMap;
    }

}