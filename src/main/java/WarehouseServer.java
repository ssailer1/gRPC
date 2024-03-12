import io.grpc.*;

import java.io.IOException;

public class WarehouseServer {
    private static final int PORT = 50022;

    private Server server;

    public void start() throws IOException {
        // start the server with the given Port & service implementation
        server = ServerBuilder.forPort(PORT)
                .addService(new WarehouseServiceImpl())
                .build()
                .start();
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server == null) {
            return;
        }
        server.awaitTermination();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        WarehouseServer server = new WarehouseServer();
        System.out.println("Warehouse Service is running!");
        server.start();
        server.blockUntilShutdown();
    }
}