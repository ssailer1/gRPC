import com.google.common.collect.ImmutableList;
import io.grpc.stub.StreamObserver;
import warehouse.*;

import java.time.LocalDateTime;


public class WarehouseServiceImpl extends WarehouseServiceGrpc.WarehouseServiceImplBase {
    @Override
    public void getWarehouseData(Warehouse.WarehouseRequest request, StreamObserver<Warehouse.WarehouseResponse> responseObserver) {
        System.out.println("Handling warehouse endpoint" + request.toString());

        String warehouseUUID = request.getUuid();

        System.out.println("Getting data of warehouse with uuid=" + warehouseUUID + "...");

        // create a few dummy product objects

        Warehouse.Product product1 = Warehouse.Product.newBuilder()
                .setProductId("766548e3-1c2d-449d-92e4-e898d76ead34")
                .setProductName("Brot")
                .setProductCategory("Brot und Backwaren")
                .setProductQuantity(105)
                .setProductUnit("500ML/Packung")
                .build();
        Warehouse.Product product2 = Warehouse.Product.newBuilder()
                .setProductId("78c92fa0-3e7d-4dcd-849d-437471c6f3e5")
                .setProductName("Milch")
                .setProductCategory("Milchprodukte")
                .setProductQuantity(167)
                .setProductUnit("1L/Packung")
                .build();
        Warehouse.Product product3 = Warehouse.Product.newBuilder()
                .setProductId("91652813-374c-4610-890c-714e5f60160a")
                .setProductName("Kartoffeln")
                .setProductCategory("Gemüse")
                .setProductQuantity(123)
                .setProductUnit("3KG/Packung")
                .build();


        // now create the warehouse response object
        Warehouse.WarehouseResponse response = Warehouse.WarehouseResponse.newBuilder()
                .setWarehouseId(warehouseUUID)
                .setWarehouseName("Linz Bahnhof")
                .setWarehouseAddress("WhoKnows Straße 12")
                .setWarehousePostalCode(4000)
                .setWarehouseCity("Linz")
                .setWarehouseCountry("AUSTRIA")
                .setTimestamp(LocalDateTime.now().toString())
                .addAllProductData(ImmutableList.of(product1, product2, product3))
                .build();

        // send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}