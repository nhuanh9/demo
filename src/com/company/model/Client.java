package com.company.model;


public class Client {
    private int clientID;
    private String clientName;
    private String clientPhoneNumber;
    private String clientAddress;
    private String clientUsername;
    private String clientPassword;

    public Client() {
    }

    public Client(int clientID, String clientName, String clientPhoneNumber, String clientAddress, String clientUsername, String clientPassword) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientAddress = clientAddress;
        this.clientUsername = clientUsername;
        this.clientPassword = clientPassword;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }


    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return "Client Id: '" + clientID +
                ", name: " + clientName +
                ", Phone Number: " + clientPhoneNumber +
                ", Address: " + clientAddress +
                ", Username: " + clientUsername +
                ", Password: '" + clientPassword;
    }
}
