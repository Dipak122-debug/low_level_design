package org.example.LLDUseCase.parkinglot.Stragies;
import java.util.Map;
import org.example.LLDUseCase.parkinglot.enums.VehicleType;
import org.example.LLDUseCase.parkinglot.models.Ticket;

public class HourlyBasedFeeStrategy implements FeeStrategy {


        private static final Map<VehicleType, Double> HOURLY_RATES = Map.of(
                VehicleType.MOTORCYCLE, 10.0,
                VehicleType.CAR, 20.0,
                VehicleType.TRUCK, 30.0
        );

        @Override
        public double calculateFee(Ticket ticket) {
            long duration = ticket.getExitTime() - ticket.getEntrytime();
            long hours = (duration / (1000 * 60 * 60)) + 1;
            return hours * HOURLY_RATES.get(ticket.getVehicle().getVehicleType());
        }

}
