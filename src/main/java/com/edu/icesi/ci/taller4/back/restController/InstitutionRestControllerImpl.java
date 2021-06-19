package com.edu.icesi.ci.taller4.back.restController;

import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.repository.InstitutionRepository;
import com.edu.icesi.ci.taller4.back.restController.InstitutionRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-rest/institutions")
public class InstitutionRestControllerImpl implements InstitutionRestController {



    private InstitutionRepository institutionRepository;

    public InstitutionRestControllerImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
    @Override
    @GetMapping("/")
    public Iterable<Institution> getInstitution(){
        return institutionRepository.findAll();
    }
}
