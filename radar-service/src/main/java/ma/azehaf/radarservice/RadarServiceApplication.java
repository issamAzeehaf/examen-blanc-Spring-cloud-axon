package ma.azehaf.radarservice;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.Registration;
import org.axonframework.common.stream.BlockingStream;
import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.TrackedEventMessage;
import org.axonframework.eventhandling.TrackingToken;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryMessage;
import org.axonframework.queryhandling.SubscriptionQueryBackpressure;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

@SpringBootApplication
public class RadarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadarServiceApplication.class, args);
	}
	@Bean
	public CommandGateway commandGateway(){
		return new CommandGateway() {
			@Override
			public <C, R> void send(C c, CommandCallback<? super C, ? super R> commandCallback) {

			}

			@Override
			public <R> R sendAndWait(Object o) {
				return null;
			}

			@Override
			public <R> R sendAndWait(Object o, long l, TimeUnit timeUnit) {
				return null;
			}

			@Override
			public <R> CompletableFuture<R> send(Object o) {
				return null;
			}

			@Override
			public Registration registerDispatchInterceptor(MessageDispatchInterceptor<? super CommandMessage<?>> messageDispatchInterceptor) {
				return null;
			}
		};
	}
	@Bean
	public QueryGateway queryGateway(){
		return new QueryGateway() {
			@Override
			public <R, Q> CompletableFuture<R> query(String s, Q q, ResponseType<R> responseType) {
				return null;
			}

			@Override
			public <R, Q> Stream<R> scatterGather(String s, Q q, ResponseType<R> responseType, long l, TimeUnit timeUnit) {
				return null;
			}

			@Override
			public <Q, I, U> SubscriptionQueryResult<I, U> subscriptionQuery(String s, Q q, ResponseType<I> responseType, ResponseType<U> responseType1, SubscriptionQueryBackpressure subscriptionQueryBackpressure, int i) {
				return null;
			}

			@Override
			public <Q, I, U> SubscriptionQueryResult<I, U> subscriptionQuery(String s, Q q, ResponseType<I> responseType, ResponseType<U> responseType1, int i) {
				return null;
			}

			@Override
			public Registration registerDispatchInterceptor(MessageDispatchInterceptor<? super QueryMessage<?, ?>> messageDispatchInterceptor) {
				return null;
			}
		};
	}

	@Bean
	public EventStore eventStore(){
		return new EventStore() {
			@Override
			public DomainEventStream readEvents(String s) {
				return null;
			}

			@Override
			public void storeSnapshot(DomainEventMessage<?> domainEventMessage) {

			}

			@Override
			public void publish(List<? extends EventMessage<?>> list) {

			}

			@Override
			public Registration registerDispatchInterceptor(MessageDispatchInterceptor<? super EventMessage<?>> messageDispatchInterceptor) {
				return null;
			}

			@Override
			public BlockingStream<TrackedEventMessage<?>> openStream(TrackingToken trackingToken) {
				return null;
			}

			@Override
			public Registration subscribe(Consumer<List<? extends EventMessage<?>>> consumer) {
				return null;
			}
		};
	}

}
