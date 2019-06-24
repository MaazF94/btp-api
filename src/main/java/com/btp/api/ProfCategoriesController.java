package com.btp.api;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.btp.models.NavBar;
import com.btp.service.ProfCategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProfCategoriesController {

    @Autowired
    private ProfCategoriesService profCategoriesService;

    private static final Logger LOG = LoggerFactory.getLogger(ProfCategoriesController.class);

    @GetMapping(value="/getProfession", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<NavBar> getProfession() {
        LOG.info("Grabbing career categories and professions");
        return profCategoriesService.getProfessions();
    }
}