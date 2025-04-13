package com.socketservice.socketservice.Configuration;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class SocketConfig {

    private static final Logger logger = LoggerFactory.getLogger(SocketConfig.class);

    // @Value("${socket.host}")
    // private String host;

    @Value("${socket.port}")
    private int port;

    @Bean
    public SocketIOServer socketIOServer() {
        // logger.info("Initializing SocketIOServer with host: {} and port: {}", host, port);
        
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        // config.setHostname(host);
        config.setPort(port);
        config.setWorkerThreads(100); // Customize based on your needs
        config.setBossThreads(10);
        config.setPingTimeout(60000); // Customize based on your setup
        config.setPingInterval(25000);

        return new SocketIOServer(config);
    }
}