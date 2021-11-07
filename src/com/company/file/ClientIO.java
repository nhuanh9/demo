package com.company.file;

import com.company.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientIO {


    public static void writeToFile(String pathFile, List<Client> list) {
        File file=new File(pathFile);
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write("Client ID,Client Name,Client Phone Number,Client Address,Client Username,Client Password\n");
            for (Client client:list) {
                bufferedWriter.write(client.getClientID()+","+
                        client.getClientName()+","+
                        client.getClientPhoneNumber()+","+
                        client.getClientAddress()+","+
                        client.getClientUsername()+","+
                        client.getClientPassword()+"\n"
                );
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static List<Client> readFromFile(String pathFile) {
        List<Client> clients=new ArrayList<>();
        File file=new File(pathFile);
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String lineCSV= bufferedReader.readLine();
            while ((lineCSV=bufferedReader.readLine())!=null){
                String[] lineContent=lineCSV.split(",");
                int clientId=Integer.parseInt(lineContent[0]);
                String clientName=lineContent[1];
                String clientPhoneNumber=lineContent[2];
                String clientAddress=lineContent[3];
                String clientUsername=lineContent[4];
                String clientPassword=lineContent[5];
                clients.add(new Client(clientId,clientName,clientPhoneNumber,clientAddress,clientUsername,clientPassword));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

}
