package com.example.grpc.client.grpcclient;

import com.example.grpc.server.grpcserver.HelloRequest;
import com.example.grpc.server.grpcserver.HelloResponse;
import com.example.grpc.server.grpcserver.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientApplication {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
				.usePlaintext()
				.build();

		HelloServiceGrpc.HelloServiceBlockingStub stub
				= HelloServiceGrpc.newBlockingStub(channel);


			HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
					.setTitle("SACAViX")
					.setDescription("Blog y canal de Youtube")
					.setUrl("https://sacavix.com")
					.build());

		System.out.println("La respuesta es: " + helloResponse);

		channel.shutdown();
	}

}
