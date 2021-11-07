package com.company.controller;

import com.company.input.Input;
import com.company.model.Client;
import com.company.service.ClientService;

import java.util.Scanner;

public class App {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_CLIENT = 1;
    private ClientService clientService;
    private Client client;

    public App() {
        clientService = ClientService.getInstance();
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public int login() {
        String username;
        Client clientLogin;
        int role = 0;
        do {
            System.out.print("Enter username: ");
            username = SCANNER.nextLine();
            clientLogin = clientService.findByUsername(username);
            if (clientLogin == null) System.out.println("Wrong username!");
        } while (clientLogin == null);

        String password;
        do {
            System.out.print("Enter password: ");
            password = SCANNER.nextLine();
            boolean isAdminAcount = username.equals("ProAdmin") && password.equals("ProAdmin123");
            if (isAdminAcount) {
                role = ROLE_ADMIN;
            }
            if (!isAdminAcount && clientLogin.getClientPassword().equals(password)) {
                this.client = clientLogin;
                System.out.println("Client login successfully!");
                role = ROLE_CLIENT;
            }
            if (!clientLogin.getClientPassword().equals(password)) {
                System.out.println("Wrong password!");
            }
        } while (!clientLogin.getClientPassword().equals(password));
        return role;
    }

    public void register() {
        Client client = Input.inputClient();
        clientService.create(client);
    }

    public void displayAllClient() {
        clientService.display();
    }
}
