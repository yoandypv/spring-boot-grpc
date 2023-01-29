package com.example.grpc.server.grpcserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class GrpcServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
				.forPort(8080)
				.addService(new HelloServiceImpl()).build();
		server.start();
		//server.awaitTermination();
		SpringApplication.run(GrpcServerApplication.class, args);


	}

}
