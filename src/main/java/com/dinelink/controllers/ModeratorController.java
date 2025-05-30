package com.dinelink.controllers;

import com.dinelink.entities.ModeratorRequest;
import com.dinelink.entities.ModeratorResponse;
import com.dinelink.services.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ModeratorController {
    private ModeratorService moderatorService;

    @Autowired
    public ModeratorController(ModeratorService moderatorService) {
        this.moderatorService = moderatorService;
    }

    @PostMapping("/moderator")
    public ResponseEntity<?> saveModerator(@RequestBody ModeratorRequest moderatorRequest) {
        try {
            ModeratorResponse moderatorResponse = moderatorService.saveModerator(moderatorRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(moderatorResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
