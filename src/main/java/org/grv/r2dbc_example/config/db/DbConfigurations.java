package org.grv.r2dbc_example.config.db;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;



public class DbConfigurations {


    public ConnectionFactory replicaConnectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "172.16.3.17")
                .option(PORT, 5432)  // Default port for PostgreSQL
                .option(DATABASE, "wani")
                .option(USER, "wani")
                .option(PASSWORD, "")
                .build());
    }


    public ConnectionFactory masterConnectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "172.16.3.17")
                .option(PORT, 5432)
                .option(DATABASE, "wani_replica")
                .option(USER, "wani")
                .option(PASSWORD, "")
                .build());
    }
}
