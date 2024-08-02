package org.grv.r2dbc_example.config.db;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class DatabaseClientConfig {

    @Bean
    public DatabaseClient replicaDatabaseClient(@Qualifier("replicaConnectionFactory") ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }

    @Bean
    public DatabaseClient masterDatabaseClient(@Qualifier("masterConnectionFactory") ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }
}
