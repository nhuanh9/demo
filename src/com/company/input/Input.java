package com.company.input;


import com.company.model.Client;
import com.company.model.Validation;
import com.company.service.ClientService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static Client inputClient() {
        System.out.println("Enter client information");
        String clientUsername = inputClientUsername();
        String clientPassword = inputClientPassword();
        int clientId = inputClientId();
        SCANNER.nextLine();
        System.out.print("Enter client name: ");
        String clientName = SCANNER.nextLine();
        String clientPhoneNumber = inputPhoneNumber();
        System.out.print("Enter client address: ");
        String clientAddress = SCANNER.nextLine();
        return new Client(clientId, clientName, clientPhoneNumber, clientAddress, clientUsername, clientPassword);
    }

    private static int inputClientId() {
        boolean existId;
        int clientId;
        do {
            System.out.print("Enter client Id: ");
            clientId = SCANNER.nextInt();
            existId = ClientService.getInstance().findById(clientId) != null;
            if (existId) System.out.println("Id already existed!");
        } while (existId);
        return clientId;
    }

    private static String inputPhoneNumber() {
        String clientPhoneNumber;
        boolean invalidPhoneNUmber;
        do {
            System.out.print("Enter client phone number: ");
            clientPhoneNumber = SCANNER.nextLine();
            invalidPhoneNUmber = !Validation.isValid(clientPhoneNumber, Validation.PHONE_NUMBER_REGEX);
            if (invalidPhoneNUmber) System.out.println("Wrong format of phone number");
        } while (invalidPhoneNUmber);
        return clientPhoneNumber;
    }

    public static String inputClientUsername() {
        String clientUsername;
        boolean existUsername;
        boolean invalidUsername;
        do {
            System.out.print("Enter client username: ");
            clientUsername = SCANNER.nextLine();
            existUsername = ClientService.getInstance().findByUsername(clientUsername) != null;
            invalidUsername = !Validation.isValid(clientUsername, Validation.USER_NAME_REGEX);
            if (invalidUsername) System.out.println("Wrong format of username! ");
            else if (existUsername) System.out.println("Username already existed! ");
        } while (invalidUsername || existUsername);
        return clientUsername;
    }

    public static String inputClientPassword() {
        String clientPassword;
        boolean invalidPassword;
        do {
            System.out.print("Enter client password: ");
            clientPassword = SCANNER.nextLine();
            invalidPassword = !Validation.isValid(clientPassword, Validation.PASSWORD_REGEX);
            if (invalidPassword) System.out.println("Wrong format of password");
        } while (invalidPassword);
        return clientPassword;
    }


}
