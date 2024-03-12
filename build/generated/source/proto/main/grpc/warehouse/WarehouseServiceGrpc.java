package warehouse;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: warehouse.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WarehouseServiceGrpc {

  private WarehouseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "warehouse.WarehouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<warehouse.Warehouse.WarehouseRequest,
      warehouse.Warehouse.WarehouseResponse> getGetWarehouseDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getWarehouseData",
      requestType = warehouse.Warehouse.WarehouseRequest.class,
      responseType = warehouse.Warehouse.WarehouseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<warehouse.Warehouse.WarehouseRequest,
      warehouse.Warehouse.WarehouseResponse> getGetWarehouseDataMethod() {
    io.grpc.MethodDescriptor<warehouse.Warehouse.WarehouseRequest, warehouse.Warehouse.WarehouseResponse> getGetWarehouseDataMethod;
    if ((getGetWarehouseDataMethod = WarehouseServiceGrpc.getGetWarehouseDataMethod) == null) {
      synchronized (WarehouseServiceGrpc.class) {
        if ((getGetWarehouseDataMethod = WarehouseServiceGrpc.getGetWarehouseDataMethod) == null) {
          WarehouseServiceGrpc.getGetWarehouseDataMethod = getGetWarehouseDataMethod =
              io.grpc.MethodDescriptor.<warehouse.Warehouse.WarehouseRequest, warehouse.Warehouse.WarehouseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getWarehouseData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  warehouse.Warehouse.WarehouseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  warehouse.Warehouse.WarehouseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WarehouseServiceMethodDescriptorSupplier("getWarehouseData"))
              .build();
        }
      }
    }
    return getGetWarehouseDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WarehouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WarehouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WarehouseServiceStub>() {
        @java.lang.Override
        public WarehouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WarehouseServiceStub(channel, callOptions);
        }
      };
    return WarehouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WarehouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WarehouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WarehouseServiceBlockingStub>() {
        @java.lang.Override
        public WarehouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WarehouseServiceBlockingStub(channel, callOptions);
        }
      };
    return WarehouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WarehouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WarehouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WarehouseServiceFutureStub>() {
        @java.lang.Override
        public WarehouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WarehouseServiceFutureStub(channel, callOptions);
        }
      };
    return WarehouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getWarehouseData(warehouse.Warehouse.WarehouseRequest request,
        io.grpc.stub.StreamObserver<warehouse.Warehouse.WarehouseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWarehouseDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WarehouseService.
   */
  public static abstract class WarehouseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WarehouseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WarehouseService.
   */
  public static final class WarehouseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WarehouseServiceStub> {
    private WarehouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WarehouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WarehouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getWarehouseData(warehouse.Warehouse.WarehouseRequest request,
        io.grpc.stub.StreamObserver<warehouse.Warehouse.WarehouseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWarehouseDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WarehouseService.
   */
  public static final class WarehouseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WarehouseServiceBlockingStub> {
    private WarehouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WarehouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WarehouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public warehouse.Warehouse.WarehouseResponse getWarehouseData(warehouse.Warehouse.WarehouseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWarehouseDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WarehouseService.
   */
  public static final class WarehouseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WarehouseServiceFutureStub> {
    private WarehouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WarehouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WarehouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<warehouse.Warehouse.WarehouseResponse> getWarehouseData(
        warehouse.Warehouse.WarehouseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWarehouseDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WAREHOUSE_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_WAREHOUSE_DATA:
          serviceImpl.getWarehouseData((warehouse.Warehouse.WarehouseRequest) request,
              (io.grpc.stub.StreamObserver<warehouse.Warehouse.WarehouseResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetWarehouseDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              warehouse.Warehouse.WarehouseRequest,
              warehouse.Warehouse.WarehouseResponse>(
                service, METHODID_GET_WAREHOUSE_DATA)))
        .build();
  }

  private static abstract class WarehouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WarehouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return warehouse.Warehouse.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WarehouseService");
    }
  }

  private static final class WarehouseServiceFileDescriptorSupplier
      extends WarehouseServiceBaseDescriptorSupplier {
    WarehouseServiceFileDescriptorSupplier() {}
  }

  private static final class WarehouseServiceMethodDescriptorSupplier
      extends WarehouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WarehouseServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WarehouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WarehouseServiceFileDescriptorSupplier())
              .addMethod(getGetWarehouseDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
