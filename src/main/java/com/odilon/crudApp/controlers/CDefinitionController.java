package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.CDefinition;
import com.odilon.crudApp.service.CDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course-definitions")
public class CDefinitionController {

    @Autowired
    private CDefinitionService cDefinitionService;

    @GetMapping
    public List<CDefinition> getAllCDefinitions() {
        return cDefinitionService.getAllCDefinitions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CDefinition> getCDefinitionById(@PathVariable String id) {
        Optional<CDefinition> cDefinition = cDefinitionService.getCDefinitionById(id);
        return cDefinition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CDefinition> createCDefinition(@RequestBody CDefinition cDefinition) {
        CDefinition createdCDefinition = cDefinitionService.createOrUpdateCDefinition(cDefinition);
        return new ResponseEntity<>(createdCDefinition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CDefinition> updateCDefinition(@PathVariable String id, @RequestBody CDefinition cDefinitionDetails) {
        Optional<CDefinition> existingCDefinition = cDefinitionService.getCDefinitionById(id);
        if (existingCDefinition.isPresent()) {
            cDefinitionDetails.setId(id);
            CDefinition updatedCDefinition = cDefinitionService.createOrUpdateCDefinition(cDefinitionDetails);
            return ResponseEntity.ok(updatedCDefinition);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCDefinition(@PathVariable String id) {
        cDefinitionService.deleteCDefinition(id);
        return ResponseEntity.noContent().build();
    }
}

