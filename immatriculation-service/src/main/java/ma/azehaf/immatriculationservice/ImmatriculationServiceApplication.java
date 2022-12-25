package ma.azehaf.immatriculationservice;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.Registration;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryMessage;
import org.axonframework.queryhandling.SubscriptionQueryBackpressure;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.reactivestreams.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@SpringBootApplication
public class ImmatriculationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImmatriculationServiceApplication.class, args);
	}

	@Bean
	public CommandGateway commandGateway() {
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
	public QueryGateway gueryqateway(){
		return new QueryGateway() {
			@Override
			public <R, Q> CompletableFuture<R> query(String s, Q q, ResponseType<R> responseType) {
				return null;
			}

			@Override
			public <R, Q> Publisher<R> streamingQuery(String s, Q q, Class<R> aClass) {
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
}
