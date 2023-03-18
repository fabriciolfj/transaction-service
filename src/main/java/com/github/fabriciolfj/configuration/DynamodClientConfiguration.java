package com.github.fabriciolfj.configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.net.URI;

public class DynamodClientConfiguration {

    @ConfigProperty(name = "aws.region")
    private String region;

    @ConfigProperty(name = "aws.dynamodb")
    private String url;

    @ConfigProperty(name = "aws.local")
    private Boolean isLocal;

    @Produces
    @ApplicationScoped
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build());
    }

    @Produces
    @ApplicationScoped
    public DynamoDbClient dynamoDbClient() {
        System.out.println("Listing your Amazon DynamoDB tables:\n");
        final ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();

        if (isLocal) {
            return DynamoDbClient.builder()
                    .credentialsProvider(credentialsProvider)
                    .region(Region.of(region))
                    .endpointOverride(URI.create(url))
                    .build();
        }

        return DynamoDbClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.of(region))
                .build();
    }
}
