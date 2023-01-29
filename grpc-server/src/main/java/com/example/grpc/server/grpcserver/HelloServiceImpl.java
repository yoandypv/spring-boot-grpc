package com.example.grpc.server.grpcserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String responseMsg = new StringBuilder()
                .append("Hello, ")
                .append(request.getTitle())
                .append(" ")
                .append(request.getDescription())
                .append(" with URL=")
                .append(request.getUrl())
                .toString();

        System.out.println("La respuesta sera: " + responseMsg);

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(responseMsg)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
