# Socket Client-Server Communication

This Java program demonstrates a simple client-server communication using sockets. The program consists of three files:

- **SocketClient.java**: Contains a class for the client that connects to a server, sends a message, and receives a reply.
- **SocketServer.java**: Contains a class for the server that listens for client connections, receives messages, and sends replies.
- **SocketManager.java**: Contains the main class that manages the client and server interactions.

## SocketClient.java

This class provides a method `connectForOneMessage` that allows a one-time socket call to a server. It sends a message to the server and returns the reply.

## SocketServer.java

This class implements a server that listens for incoming client connections. Upon receiving a message from a client, it calculates the sum of three numbers (sent as a comma-separated string) and sends the result back to the client.

## SocketManager.java

The main class `SocketManager` starts the server on a specified port and then continuously prompts the user to enter three numbers. It sends these numbers to the server and displays the server's reply.

## Usage

1. Compile the Java files using `javac SocketClient.java SocketServer.java SocketManager.java`.
2. Start the server by running `java SocketManager`. Enter the port number to listen on.
3. Enter the IP address and port number of the server in the client prompt.
4. Enter three numbers separated by commas in the client prompt to send to the server.

