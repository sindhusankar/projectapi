package com.example.project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ConnectionService {
	private ServiceRepository serviceRepository;

    @Autowired
    public void ServiceRepository(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceMod provisionService(ServiceMod serviceMod) {
    
        serviceMod.setEnabled(true);
        serviceMod.setQosTested(false);
        serviceMod.setOnHold(false);
        serviceMod.setResume(false);

       
        return serviceRepository.save(serviceMod);
    }

    public void testQoS(ServiceMod serviceMod) {
        // Logic to test device QoS
        serviceMod.setQosTested(true);
        serviceRepository.save(serviceMod);
    }

    public void disableService(int connectionId) {
        // Find the serviceMod entity by connectionId and set enabled=false
        ServiceMod serviceMod = serviceRepository.findById(connectionId)
                .orElseThrow(() -> new NoSuchElementException("Service not found"));
        serviceMod.setEnabled(false);
        serviceRepository.save(serviceMod);
    }

    public void holdService(int connectionId) {
        // Find the serviceMod entity by connectionId and set onHold=true
        ServiceMod serviceMod = serviceRepository.findById(connectionId)
                .orElseThrow(() -> new NoSuchElementException("Service not found"));
        serviceMod.setOnHold(true);
        serviceRepository.save(serviceMod);
    }

    public void resumeService(int connectionId) {
        // Find the serviceMod entity by connectionId and set onHold=false
        ServiceMod serviceMod = serviceRepository.findById(connectionId)
                .orElseThrow(() -> new NoSuchElementException("Service not found"));
        serviceMod.setOnHold(false);
        serviceRepository.save(serviceMod);
    }
}