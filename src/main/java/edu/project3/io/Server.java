package edu.project3.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

public class Server {
    /* -----------------------------------------------Server Thread-------------------------------------------------- */
    public class ServerThread extends Thread {
        /* -------------------------------------------Client Thread-------------------------------------------------- */
        protected class ClientThread extends Thread {
            /* ------------------------------------------Fields------------------------------------------------------ */
            protected Socket socket;

            protected ObjectInputStream in;

            protected ObjectOutputStream out;

            protected int count;

            /* ---------------------------------------Constructors--------------------------------------------------- */
            protected ClientThread(Socket socket, int count) {
                try {
                    this.socket = socket;
                    this.in = new ObjectInputStream(socket.getInputStream());
                    this.out = new ObjectOutputStream(socket.getOutputStream());
                    this.count = count;
                } catch (Exception e) {
                    Server.handleException(e, "Streams not open");
                }
            }

            /* -----------------------------------------Methods------------------------------------------------------ */
            public void messageClients(String message) {
                for (ClientThread client : clients) {
                    try {
                        client.out.writeObject(message);
                    } catch (Exception e) {
                        Server.handleException(e);
                    }
                }
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        String data = this.in.readObject().toString();
                        callback.accept("Client: #" + this.count + " Data: " + data);
                        this.messageClients("Client #" + this.count + " sent: " + data);
                    } catch (Exception e) {
                        this.messageClients("Client #" + this.count + " left the server");
                        clients.remove(this);
                        break;
                    }
                }
            }
        }

        /* ----------------------------------------------Fields------------------------------------------------------ */
        private ServerSocket socket;

        /* -------------------------------------------Constructors--------------------------------------------------- */
        public ServerThread() {
            try {
               this.socket = new ServerSocket(5555);
            } catch (Exception e) {
                Server.handleException(e, "Server socket not open");
            }
        }

        /* ---------------------------------------------Methods------------------------------------------------------ */
        @Override
        public void run() {
            System.out.println("Server started");

            while (true) {
                try {
                    ClientThread client = new ClientThread(this.socket.accept(), clientCount);
                    callback.accept(String.format("Client #%d connected to the server", clientCount));
                    clients.add(client);
                    client.start();
                    ++clientCount;
                } catch (Exception e) {
                    Server.handleException(e);
                }
            }
        }
    }


    /* --------------------------------------------------Fields------------------------------------------------------ */
    private final Consumer<Serializable> callback;

    protected List<ServerThread.ClientThread> clients;

    protected int clientCount;

    protected ServerThread thread;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    protected Server(Consumer<Serializable> callback) {
        this.callback = callback;
        this.clients = new ArrayList<>();
        this.thread = new ServerThread();
        this.thread.start();
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    private static void handleException(Exception e) {
        System.err.printf("Exception thrown with description \"%s\"\n", e.getMessage());
        e.printStackTrace();
    }

    private static void handleException(Exception e, String message) {
        System.err.println(message);
        e.printStackTrace();
    }



}
