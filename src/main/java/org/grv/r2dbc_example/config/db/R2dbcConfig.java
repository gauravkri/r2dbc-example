package org.grv.r2dbc_example.config.db;


import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.DatagramSocket;

@Configuration
public class R2dbcConfig {

    @Bean
    public ConnectionFactory replicaConnectionFactory() {
        return new DbConfigurations().replicaConnectionFactory();
    }

    @Bean
    public ConnectionFactory masterConnectionFactory() {
        return new DbConfigurations().masterConnectionFactory();
    }
}
