package edu.project3.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private Consumer<Serializable> callback;

    protected Socket socket;

    protected ObjectInputStream in;

    protected ObjectOutputStream out;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Client(Consumer<Serializable> callback) {
        try {
            this.callback = callback;
            this.socket = new Socket("127.0.0.1", 5555);
            this.socket.setTcpNoDelay(true);
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            handleException(e);
        }
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    private static void handleException(Exception e) {
        System.err.printf("Exception thrown with description \"%s\"\n", e.getMessage());
        e.printStackTrace();
    }

    @Override
    public void run() {
        while(true) {
            try {
                String message = this.in.readObject().toString();
                this.callback.accept(message);
            } catch(Exception e) {
                handleException(e);
            }
        }
    }

    public void send(String data) {
        try {
            this.out.writeObject(data);
        } catch (Exception e) {
            handleException(e);
        }
    }
}
