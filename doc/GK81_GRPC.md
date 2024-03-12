**@author:** Sebastian Sailer
**@version:** 2024-02-27


### Introduction

This exercise is intended to demonstrate the functionality and implementation of Remote Procedure Call (RPC) technology using the Open Source High Performance gRPC Framework **gRPC Frameworks** ([https://grpc.io](https://grpc.io/)). It shows that this framework can be used to develop a middleware system for connecting several services developed with different programming languages.

Document all individual implementation steps and any problems that arise in a log (Markdown).  
Create a GITHUB repository for this project and add the link to it in the comments.

### Questions

**1# What is gRPC and why does it work accross languages and platforms?**
gRPC is a high-performance, open-source Remote Procedure Call (RPC) framework initially developed by Google. It enables client and server applications to communicate transparently, allowing developers to build distributed systems as if they were making local function calls.
- **Protocol Buffers:** gRPC uses Protocol Buffers (Protobuf) as its interface definition language (IDL) and as its underlying message interchange format
- **Code Generation:** gRPC provides tools that automatically generate client and server code from `.proto` files for various programming languages. This generated code handles the complexities of data serialization and network communication, allowing developers to focus on implementing the actual business logic.

**2# Describe the RPC life cycle starting with the RPC client?**
1. **Client Initialization:** The RPC client creates a stub object representing the remote service
2. **Method Invocation:** The client invokes a method on the stub object, passing relevant data as arguments. This data is translated from the client's native format to Protobuf format by the generated code.
3. **Serialization and Sending:** The serialized data is sent to the server.
4. **Server-Side Processing:** The server receives the message, deserializes it using the generated code and calls the corresponding implementation of the invoked method.
5. **Response Processing:** The server generates a response and sends it back to the client after serialization.
6. **Client-Side Deserialization and Data Use:** The client receives the response, deserializes it, and uses the data.

**3# Describe the workflow of Protocol Buffers?**
1. **Define Data Structure:** First, you define the structure of your data using Protobuf's interface definition language (IDL)
2. **Generate Source Code:** Once you have defined your data structure in a `.proto` file, you use the Protobuf compiler (`protoc`) to generate source code in your desired programming language
3. **Use Generated Code in Your Application:** In your application, you use the generated classes to construct data structures
4. **Deserialize Data:** On the receiving end the binary data is deserialized back into the structured data format defined by the `.proto` file

The workflow of Protocol Buffers emphasizes efficiency, both in terms of development time (through automatic code generation) and runtime performance (due to the compact binary serialization format)
<br>

**4# What are the benefits of using protocol buffers?**

**Efficiency**: Protobuf is designed to serialize data to a compact binary format, which significantly reduces the size of the data that needs to be transmitted
**Strongly Typed**: Protobuf enforces type safety through its schema definition by defining your data structure in a `.proto` file.
**Language and Platform Agnostic**: Protobuf supports code generation in multiple programming languages
<br>
**5# When is the use of protocol not recommended?**

- **Simple Data Structures**
- **Frequent Schema Changes:** If your data schema changes frequently, managing versioning and compatibility might become bothering

**6# List 3 different data types that can be used with protocol buffers?**
1. **Scalar Types:** Basic data types like integers, floats, strings, booleans, bytes
2. **Complex Types:** Defines a structured data type, similar to a class in object-oriented languages
3. **Composite Types:** Messages that group other data types together to represent complex structures.

### GK-Ü
#### hello.prot File erstellen
```java
syntax = "proto3";  
  
service HelloWorldService {  
  rpc hello(HelloRequest) returns (HelloResponse) {}  
}  
  
message HelloRequest {  
  string firstname = 1;  
  string lastname = 2;  
  
}  
  
message HelloResponse {  
  string text = 1;  
}
```
(src/main/hello.pronto)

- We have a `HelloWorldService` Service
- We can send `HelloRequests` objects to the Server 
- The Server responds with a `HelloResponse` object

#### Code aus dem hello.pronto File generieren

Watch out, the  `gradle.build` File from the tutorial got some errors

```java
plugins {  
	id 'application'  
	id 'com.google.protobuf' version '0.9.4'  
	id 'idea'  
}  
  
repositories {  
	maven { 
			url "https://maven-central.storage-
			download.googleapis.com/maven2/" 
	}  
	mavenCentral()  
	mavenLocal()  
}  
  
java {  
	sourceCompatibility = JavaVersion.VERSION_1_8  
	targetCompatibility = JavaVersion.VERSION_1_8  
}  
  

def grpcVersion = '1.61.1'  
def protobufVersion = '3.25.1'  
def protocVersion = protobufVersion  
  
dependencies {  
	implementation "io.grpc:grpc-protobuf:${grpcVersion}"  
	implementation "io.grpc:grpc-services:${grpcVersion}"  
	implementation "io.grpc:grpc-stub:${grpcVersion}"  
	compileOnly "org.apache.tomcat:annotations-api:6.0.53"  
	  
	implementation "com.google.protobuf:protobuf-java-
	util:${protobufVersion}"  
  
	runtimeOnly "io.grpc:grpc-netty-shaded:${grpcVersion}"  
	  
	testImplementation "io.grpc:grpc-testing:${grpcVersion}"  
	testImplementation "io.grpc:grpc-inprocess:${grpcVersion}"  
	testImplementation "junit:junit:4.13.2"  
	testImplementation "org.mockito:mockito-core:4.4.0"  
}  
  
protobuf {  
	protoc { 
		artifact = 
		"com.google.protobuf:protoc:${protocVersion}" }  
	plugins {  
		grpc { 
			artifact = "io.grpc:protoc-gen-grpc-
			java:${grpcVersion}" }  
		}  
	 generateProtoTasks {  
	all()*.plugins { grpc {} }  
	}  
}  
  
sourceSets {  
	src {  
		main {  
			java {  
				srcDirs 
				'build/generated/source/proto/main/grpc'  
				srcDirs 
				'build/generated/source/proto/main/java'  
			}  
		}  
	}  
}
```

Next execute the `gradle.build`

#### Starting the service

- First start the `HelloWorldServer`
- Then `HelloWorldClient`

Expected Output / Server response:

![[4bhit/8.Semester/syt/Micheler/GK81/doc/img/1.png]]

### GK-V

We implement the DataWarehouse with a previouse example structure:

```json
{
    "warehouseID": "469d7240-b974-441d-9562-2c56a7b28767",
    "warehouseName": "Linz Bahnhof",
    "warehouseAddress": "WhoKnows Straße 12",
    "warehousePostalCode": 4000,
    "warehouseCity": "Linz",
    "warehouseCountry": "Austria",
    "timestamp": "2023-09-19 16:36:56.933",
    "productData": [
        {
            "productID": "e940f2af-182d-4b49-940b-723908f53a77",
            "productName": "Brot",
            "productCategory": "Brot und Backwaren",
            "productQuantity": 105,
            "productUnit": "500ML/Packung"
        },
        {
            "productID": "df2a7d5e-97f9-4545-91d5-6229ba0acb05",
            "productName": "Milch",
            "productCategory": "Milchprodukte",
            "productQuantity": 167,
            "productUnit": "1L/Packung"
        },
        {
            "productID": "42c9feae-ee65-4e4b-ac45-c1bc5ac7355b",
            "productName": "Kartoffeln",
            "productCategory": "Gemüse",
            "productQuantity": 123,
            "productUnit": "3KG/Packung"
        },
        {
            "productID": "4c54e706-95bf-4602-b4a1-c152cd73eda4",
            "productName": "Reis",
            "productCategory": "Getreide und Reis",
            "productQuantity": 92,
            "productUnit": "500ML/Packung"
        }
    ]
}
```

After inspecting the data structure for a while, I (AI ) came up with the following proto file:
```java
syntax = "proto3";  
  
package warehouse;  
  
service WarehouseService  {  
	  rpc getWarehouseData(WarehouseRequest) returns 
	  (WarehouseResponse) {}  
}  
  
message WarehouseRequest  {  
  string uuid = 1;  
}  
  
message WarehouseResponse {  
  string warehouse_id = 1;  
  string warehouse_name = 2;  
  string warehouse_address = 3;  
  int32 warehouse_postal_code = 4;  
  string warehouse_city = 5;  
  string warehouse_country = 6;  
  string timestamp = 7;  

  repeated Product product_data = 8;  
}  
  
message Product {  
  string product_id = 1;  
  string product_name = 2;  
  string product_category = 3;  
  int32 product_quantity = 4;  
  string product_unit = 5;  
}
```

Subsequently, you execute the `gradle.build` File and the new Generated Files should have been generated.

#### Implementing the Service 
We need to create a `WarehouseServiceImpl.java` file which will include the actual implementation of our Service.

**Required components:**
- Overwritten `getWarehouseData` method with the correct parameters (see `warehouse.proto`)
- Get the warehouse uuid from the request
- create dummy products
- build warehouse response
- send response to client

`WarehouseServiceImpl.java`
```java
import com.google.common.collect.ImmutableList;  
import io.grpc.stub.StreamObserver;  
import warehouse.*;  
  
import java.time.LocalDateTime;  
  
  
public class WarehouseServiceImpl extends WarehouseServiceGrpc.WarehouseServiceImplBase {  
@Override  
public void getWarehouseData(Warehouse.WarehouseRequest 
request, StreamObserver<Warehouse.WarehouseResponse> responseObserver) {  
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

//response Object
Warehouse.WarehouseResponse response = Warehouse.WarehouseResponse.newBuilder()  
	.setWarehouseId(warehouseUUID)  
	.setWarehouseName("Linz Bahnhof")  
	.setWarehouseAddress("WhoKnows Straße 12")  
	.setWarehousePostalCode(4000)  
	.setWarehouseCity("Linz")  
	.setWarehouseCountry("AUSTRIA")  
	.setTimestamp(LocalDateTime.now().toString())  
	.addAllProductData(ImmutableList.of(product1, product2, 
	product3))  
	.build();  
  
	// send the response to the client  
	responseObserver.onNext(response);  
	responseObserver.onCompleted();  
	}  
}
```

---
`WarehouseServer.java`

```java
import io.grpc.*;  
  
import java.io.IOException;  
  
public class WarehouseServer {  
	private static final int PORT = 50022;  
	  
	private Server server;  
	  
	public void start() throws IOException {  
		server = ServerBuilder.forPort(PORT)  
		.addService(new WarehouseServiceImpl())  
		.build()  
		.start();  
	}  
	  
	public void blockUntilShutdown() throws InterruptedException {  
		if (server == null) { return; }  
		server.awaitTermination();  
	}  
	  
	public static void main(String[] args) throws InterruptedException, IOException {  
		WarehouseServer server = new WarehouseServer();  
		System.out.println("Warehouse Service is running!");  
		server.start();  
		server.blockUntilShutdown();  
	}  
}
```
---
`WarehouseClient.java`

```java
import io.grpc.*;  
import warehouse.*;  
  
  
public class WarehouseClient {  
	public static void main(String[] args) {  
		ManagedChannel channel = 
		ManagedChannelBuilder.forAddress("localhost", 50022)  
		.usePlaintext()  
		.build();  
		  
		WarehouseServiceGrpc.WarehouseServiceBlockingStub stub 
		= WarehouseServiceGrpc.newBlockingStub(channel);  
		  
		Warehouse.WarehouseResponse warehouseResponse = 
stub.getWarehouseData(Warehouse.WarehouseRequest.newBuilder()  
		.setUuid("adbe69b5-932b-45d2-9c13-fa408e100cda")  
		.build());  
		  
		System.out.println(warehouseResponse.toString());  
		  
		channel.shutdown();  
	}  
}
```

Expected output: 
![[4bhit/8.Semester/syt/Micheler/gRPC/doc/img/2.png]]