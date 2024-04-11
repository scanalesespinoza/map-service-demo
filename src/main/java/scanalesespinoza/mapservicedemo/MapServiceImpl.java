package scanalesespinoza.mapservicedemo;

import io.quarkus.grpc.GrpcService;
import mapservicedemo.MutinyMapServiceGrpc;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import mapservicedemo.MapServiceOuterClass.PositionUpdateRequest;
import mapservicedemo.MapServiceOuterClass.PositionUpdateReply;
import mapservicedemo.MapServiceOuterClass.GetPositionsRequest;
import mapservicedemo.MapServiceOuterClass.UserPosition;


@GrpcService
public class MapServiceImpl extends MutinyMapServiceGrpc.MapServiceImplBase {
    @Override
    public Uni<PositionUpdateReply> updatePosition(PositionUpdateRequest request) {
        // Logic to store/update user's position
        return Uni.createFrom().item(PositionUpdateReply.newBuilder()
                .addPositions(UserPosition.newBuilder()
                        .setUserId(request.getUserId())
                        .setLatitude(request.getLatitude())
                        .setLongitude(request.getLongitude())
                        .build())
                .build());
    }

    @Override
    public Multi<PositionUpdateReply> getPositions(GetPositionsRequest request) {
        // Logic to retrieve all connected users' positions
        // Assuming positions is a collection of UserPosition
        PositionUpdateReply.Builder replyBuilder = PositionUpdateReply.newBuilder();
        // Fill replyBuilder with positions
        return Multi.createFrom().item(replyBuilder.build());
    }
}
