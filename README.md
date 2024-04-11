
# Quarkus gRPC Map Service

## Overview
This project demonstrates a simple gRPC service using Quarkus, enabling clients to update and retrieve user positions on a map. It's designed as a backend service for applications that require real-time location tracking.

## Setup

### Requirements
- Java JDK 11 or later
- Maven 3.6.2 or later

### Getting Started

1. **Clone the repository**
   ```
   git clone [repository-url]
   cd map-service-demo
   ```

2. **Compile the project**
   This step generates the gRPC service stubs from your `.proto` files.
   ```
   ./mvnw compile
   ```

3. **Run the application**
   ```
   ./mvnw quarkus:dev
   ```
   The service will start on `localhost` with the default gRPC server port (9000).

## Usage

### Updating User Position
Clients can update their position by calling the `UpdatePosition` RPC method. Example using grpcurl:
```
grpcurl -plaintext -proto src/main/proto/map_service.proto -d '{"userId": "user1", "latitude": 50.1109, "longitude": 8.6821}' localhost:9000 mapservicedemo.MapService/UpdatePosition
```

### Retrieving Positions
Clients can retrieve the positions of all users by calling the `GetPositions` RPC method.
```
grpcurl -plaintext -proto src/main/proto/map_service.proto -d '{}' localhost:9000 mapservicedemo.MapService/GetPositions
```

## Project Structure

- `src/main/proto/map_service.proto`: Contains the Protobuf definitions for the service and messages.
- `src/main/java/mapservicedemo/MapServiceImpl.java`: The implementation of the gRPC service defined in the `.proto` file.
- `pom.xml`: Maven project file with dependencies and plugin configurations needed to compile and run the service.


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/map-service-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.


## Contributing
Contributions to the project are welcome. Please follow the standard fork and pull request workflow.

## License
[Apache License 2.0](LICENSE)
