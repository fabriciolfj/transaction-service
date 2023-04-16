package com.github.fabriciolfj.configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.net.URI;
import java.net.UnknownHostException;

@Slf4j
public class DynamodClientConfiguration {

    @ConfigProperty(name = "aws.region")
    private String region;

    @ConfigProperty(name = "aws.dynamodb")
    private String url;

    @ConfigProperty(name = "aws.local")
    private Boolean isLocal;

    @Produces
    @ApplicationScoped
    public DynamoDBMapper dynamoDBMapper() throws UnknownHostException {
        if (isLocal) {
            var config = DynamoDBMapperConfig
                    .builder()
                    .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.CLOBBER)
                    .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                    .withTableNameOverride(null)
                    .build();

            var client = AmazonDynamoDBClientBuilder
                    .standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(url, region))
                    .withCredentials(new com.amazonaws.auth.profile.ProfileCredentialsProvider("localstack"))
                    .build();

            return new DynamoDBMapper(client, config);
        }

        return new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build());
    }

    @Produces
    @ApplicationScoped
    public DynamoDbClient dynamoDbClient() {
        if (isLocal) {
            return DynamoDbClient.builder()
                    .credentialsProvider(StaticCredentialsProvider
                            .create(AwsBasicCredentials.create("1", "1")))
                    .region(Region.of(region))
                    .endpointOverride(URI.create(url))
                    .build();
        }

        log.info("Listing your Amazon DynamoDB tables");
        final ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();

        return DynamoDbClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.of(region))
                .build();
    }
}
