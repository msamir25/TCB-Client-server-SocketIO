package org.DemoChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost" , 5678);


            Scanner fromConsole = new Scanner(System.in);
            Scanner fromServer = new Scanner(socket.getInputStream());
            PrintWriter fromClient = new PrintWriter(socket.getOutputStream() ,true);


            String input , output;
            while (true){

                System.out.println("Client:  ");
                //send data from Console to Server
                input = fromConsole.nextLine();
                fromClient.println(input);

                if (input.equals("*exit*")){
                    break;
                }

                output = fromServer.nextLine();
                System.out.println(" Server :  " + output);
                if (output.equals("*exit*")){
                    break;
                }

            }
        socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
