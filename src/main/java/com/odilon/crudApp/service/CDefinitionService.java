package com.odilon.crudApp.service;

import com.odilon.crudApp.Repository.CDefinitionRepository;
import com.odilon.crudApp.model.CDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CDefinitionService {

    @Autowired
    private CDefinitionRepository cDefinitionRepository;

    public List<CDefinition> getAllCDefinitions() {
        return cDefinitionRepository.findAll();
    }

    public Optional<CDefinition> getCDefinitionById(String id) {
        return cDefinitionRepository.findById(id);
    }

    public CDefinition createOrUpdateCDefinition(CDefinition cDefinition) {
        return cDefinitionRepository.save(cDefinition);
    }

    public void deleteCDefinition(String id) {
        cDefinitionRepository.deleteById(id);
    }
}
