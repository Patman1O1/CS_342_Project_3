package edu.project3.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;


public abstract class Client extends Thread {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final String HOST = "127.0.0.1";

    private static final int PORT = 5555;

    protected Consumer<Serializable> callback;

    protected Socket socket;

    protected ObjectInputStream in;

    protected ObjectOutputStream out;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Client(Consumer<Serializable> callback) throws IOException {
        // Assign the callback
        this.callback = callback;

        // Create the socket
        this.socket = new Socket(HOST, PORT);
        this.socket.setTcpNoDelay(true);

        // Create an output stream and flush it
        this.out = new ObjectOutputStream(this.socket.getOutputStream());
        this.out.flush();

        // Create an input stream
        this.in = new ObjectInputStream(this.socket.getInputStream());
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public abstract void run();

    public void close() throws IOException {
        this.socket.close();
        this.in.close();
        this.out.close();
    }
}
