package edu.project3.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.Socket;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Client extends Thread {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    protected Consumer<Serializable> callback;

    protected Socket socket;

    protected ObjectInputStream in;

    protected ObjectOutputStream out;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Client(Consumer<Serializable> callback) {
        try {
            // Assign the callback
            this.callback = callback;

            // Create the socket
            this.socket = new Socket("127.0.0.1", 5555);
            this.socket.setTcpNoDelay(true);

            // Create an output stream and flush it
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.out.flush();

            // Create an input stream
            this.in = new ObjectInputStream(this.socket.getInputStream());
        } catch (ConnectException e) {
            handleConnectException(e);
        } catch (Exception e) {
            handleException(e);
        }
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    private static void handleConnectException(ConnectException e) {
        System.err.printf("Exception thrown with description \"%s\"\n", e.getMessage());
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Unable to connect to the server.", ButtonType.OK).showAndWait();
        Platform.exit();
    }

    private static void handleException(Exception e) {
        // Print a message
        System.err.printf("Exception thrown with description \"%s\"\n", e.getMessage());
        e.printStackTrace();
    }

    @Override
    public void run() {
        // While the socket is connected to the server...
        while(!this.socket.isClosed()) {
            try {
                String message = this.in.readObject().toString();
                this.callback.accept(message);
            } catch(Exception e) {
                handleException(e);
                break;
            }
        }
    }

    public void send(Object data) {
        try {
            this.out.writeObject(data);
            this.out.flush();
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void close() {
        try {
            this.socket.close();
            this.in.close();
            this.out.close();
        } catch (Exception e) {
            handleException(e);
        }
    }
}
