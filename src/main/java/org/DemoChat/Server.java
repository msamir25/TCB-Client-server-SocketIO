package org.DemoChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        //reserve port to server
        ServerSocket serverSocket = new ServerSocket(5678);

        //listen a connection to a socket
        Socket socket = serverSocket.accept();


        Scanner fromConsole = new Scanner(System.in);
        //recieve Data from Client
        Scanner fromClient = new Scanner(socket.getInputStream());

        //send data to Client
        PrintWriter fromServer = new PrintWriter(socket.getOutputStream());

        //forward data from client to server and vice verce

        String inputFromServer , inputFromConsole;
        while (true){

            inputFromServer = fromClient.nextLine();
            System.out.println(" Client:  " + inputFromServer);

            if (inputFromServer.equals("*exit*")){
                break;
            }

            System.out.println("Server: ");

            inputFromConsole = fromConsole.nextLine();
            fromServer.println(inputFromConsole);
            fromServer.flush();

            if (inputFromConsole.equals("*exit*")){
                break;
            }
        }
    socket.close();
    }

}
