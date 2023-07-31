package com.example.project.service;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServiceMod {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int connectionId;
	    private String deviceName;
	    private boolean enabled;
	    private boolean qosTested;
	    private boolean onHold;
		private boolean onResume;

	    // Constructors (default and parameterized)
	    public ServiceMod() {
	    }	   

	    // Getters and setters
	    public int getConnectionId() {
	        return connectionId;
	    }

	    public void setConnectionId(int connectionId) {
	        this.connectionId = connectionId;
	    }

	    public String getDeviceName() {
	        return deviceName;
	    }

	    public void setDeviceName(String deviceName) {
	        this.deviceName = deviceName;
	    }

	    public boolean isEnabled() {
	        return enabled;
	    }

	    public void setEnabled(boolean enabled) {
	        this.enabled = enabled;
	    }

	    public boolean isQosTested() {
	        return qosTested;
	    }

	    public void setQosTested(boolean qosTested) {
	        this.qosTested = qosTested;
	    }

	    public boolean isOnHold() {
	        return onHold;
	    }

	    public void setOnHold(boolean onHold) {
	        this.onHold = onHold;
	    }
	    public boolean isOnResume() {
	        return onResume;
	    }

	    public void setResume(boolean onResume) {
	        this.onResume = onResume;
	    }
//	    @Override
//	    public String toString() {
//	        return "ServiceProvision{" +
//	                "connectionId='" + connectionId + '\'' +
//	                ", deviceName='" + deviceName + '\'' +
//	                ", enabled=" + enabled +
//	                ", qosTested=" + qosTested +
//	                ", onHold=" + onHold +
//	                '}';
//	    }
	}
	




