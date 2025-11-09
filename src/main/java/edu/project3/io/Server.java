package edu.project3.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Server {
    /* -----------------------------------------------Server Thread-------------------------------------------------- */
    public class ServerThread extends Thread {
        /* ----------------------------------------------Fields------------------------------------------------------ */
        protected final ServerSocket serverSocket;

        /* --------------------------------------------Constructors-------------------------------------------------- */
        public ServerThread() throws IOException { this.serverSocket = new ServerSocket(PORT); }

        /* ----------------------------------------------Methods----------------------------------------------------- */
        @Override
        public void run() {
            while (!this.serverSocket.isClosed()) {
                acceptClient();
            }
        }
    }

    /* -----------------------------------------------Client Thread-------------------------------------------------- */
    protected class ClientThread extends Thread {
        /* ----------------------------------------------Fields------------------------------------------------------ */
        protected Socket socket;

        protected ObjectInputStream in;

        protected ObjectOutputStream out;

        /* -------------------------------------------Constructors--------------------------------------------------- */
        protected ClientThread(Socket socket) throws IOException {
            this.socket = socket;
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.out.flush();
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.socket.setTcpNoDelay(true);
            ++clientCount;
        }

        /* ---------------------------------------------Methods------------------------------------------------------ */
        @Override
        public void run() {
            while (!this.socket.isClosed()) {
                handleClient();
            }
        }

    }

    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final String HOST = "127.0.0.1";

    private static final int PORT = 5555;

    protected final Consumer<Serializable> callback;

    protected List<ClientThread> clients;

    protected int clientCount;

    protected ServerThread thread;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Server(Consumer<Serializable> callback) throws IOException {
        this.callback = callback;
        this.clients = new CopyOnWriteArrayList<>();
        this.thread = new ServerThread();
        this.thread.start();
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public abstract void acceptClient();

    public abstract void handleClient();

}
