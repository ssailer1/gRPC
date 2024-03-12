import io.grpc.*;
import warehouse.*;


public class WarehouseClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50022)
                .usePlaintext()
                .build();

        WarehouseServiceGrpc.WarehouseServiceBlockingStub stub = WarehouseServiceGrpc.newBlockingStub(channel);

        Warehouse.WarehouseResponse warehouseResponse = stub.getWarehouseData(Warehouse.WarehouseRequest.newBuilder()
                .setUuid("adbe69b5-932b-45d2-9c13-fa408e100cda")
                .build());

        System.out.println(warehouseResponse.toString());

        channel.shutdown();
    }
}