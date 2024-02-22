package com.car.booking.saga;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.CommandResultMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.booking.event.CarBookedEvent;
import com.my.cqrs.core.command.CancelCarBookingCommand;
import com.my.cqrs.core.command.ReserveCarCoammd;

@Saga
public class CarBookingSaga {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarBookingSaga.class);

	@Autowired
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "carBookingId")
	public void handle(CarBookedEvent carBookedEvent) {

		ReserveCarCoammd reserveCarCoammd = new ReserveCarCoammd();
		BeanUtils.copyProperties(carBookedEvent, reserveCarCoammd);

		commandGateway.send(reserveCarCoammd, new CommandCallback<ReserveCarCoammd, Object>() {

			@Override
			public void onResult(CommandMessage<? extends ReserveCarCoammd> commandMessage,
					CommandResultMessage<? extends Object> commandResultMessage) {

				if (commandResultMessage.isExceptional()) {
					cancelCarBookingCommandHandle(reserveCarCoammd);
				}
				LOGGER.info("Created Order Event Handled for OrderId : " + "" + reserveCarCoammd.getCarBookingId()
						+ "  and productId : " + reserveCarCoammd.getCarModelId());
			}

		});
	}

	
	
	private void cancelCarBookingCommandHandle(ReserveCarCoammd reserveCarCoammd) {
		CancelCarBookingCommand cancelCarBookingCommand=new CancelCarBookingCommand();
		
		BeanUtils.copyProperties(reserveCarCoammd, cancelCarBookingCommand);
		commandGateway.sendAndWait(cancelCarBookingCommand);
	}
	
}
