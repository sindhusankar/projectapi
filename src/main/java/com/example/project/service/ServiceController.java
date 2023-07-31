package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/service")
public class ServiceController {
	private ConnectionService connectionService;

	@Autowired
    public ServiceController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping("/provision")
    public ResponseEntity<ServiceMod> provisionService(@RequestBody ServiceMod serviceMod) {
        ServiceMod createdService = connectionService.provisionService(serviceMod);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdService);
    }

    @PostMapping("/test-qos")
    public ResponseEntity<String> testQoS(@RequestBody ServiceMod serviceMod) {
    	connectionService.testQoS(serviceMod);
        return ResponseEntity.ok("QoS test completed successfully.");
    }

    @PutMapping("/disable/{connectionId}")
    public ResponseEntity<String> disableService(@PathVariable int connectionId) {
    	connectionService.disableService(connectionId);
        return ResponseEntity.ok("Service disabled successfully.");
    }

    @PutMapping("/hold/{connectionId}")
    public ResponseEntity<String> holdService(@PathVariable int connectionId) {
    	connectionService.holdService(connectionId);
        return ResponseEntity.ok("Service put on hold successfully.");
    }

    @PutMapping("/resume/{connectionId}")
    public ResponseEntity<String> resumeService(@PathVariable int connectionId) {
    	connectionService.resumeService(connectionId);
        return ResponseEntity.ok("Service resumed successfully.");
    }
}