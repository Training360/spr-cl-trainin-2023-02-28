package ratingservice.grpcgateway;

import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class RatingServiceGatewayTest {

    @LocalServerPort
    int port;

    @Test
    void testCreateRating() {
        log.info("Port: {}", port);
        var channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 9090)
                .usePlaintext()
                .build();
        var stub = RatingServiceGrpc.newBlockingStub(channel);
        var request = RateRequest.newBuilder()
                .setEmployeeId(1).setCourseId(1).setStars(5).build();
        var response = stub.createRating(request);
        assertEquals(5, response.getStars());
    }
}
