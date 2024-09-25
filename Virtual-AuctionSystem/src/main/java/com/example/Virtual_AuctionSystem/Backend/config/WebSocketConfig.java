import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configure message broker
        config.enableSimpleBroker("/topic");  // Prefix for topics clients can subscribe to
        config.setApplicationDestinationPrefixes("/app");  // Prefix for sending messages from client
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register WebSocket endpoint that clients will use to connect to your WebSocket server
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();  // Fallback to SockJS if WebSocket not available
    }
}
