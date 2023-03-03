package ratingservice.grpcgateway;

import com.google.protobuf.Int64Value;
import ratingservice.service.RatingService;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@AllArgsConstructor
public class RatingServiceGateway extends RatingServiceGrpc.RatingServiceImplBase {

    private RatingService ratingService;

    private GatewayMapper gatewayMapper;

    @Override
    public void createRating(RateRequest request, StreamObserver<RateResponse> responseObserver) {
        var response = ratingService.createRating(gatewayMapper.toDto(request));
        responseObserver.onNext(gatewayMapper.toGateway(response));
        responseObserver.onCompleted();
    }

    @Override
    public void findAverageByCourseId(Int64Value request, StreamObserver<RatingAverage> responseObserver) {
        var average = ratingService.findAverageByCourseId(request.getValue());
        responseObserver.onNext(gatewayMapper.toGateway(average));
        responseObserver.onCompleted();
    }
}
