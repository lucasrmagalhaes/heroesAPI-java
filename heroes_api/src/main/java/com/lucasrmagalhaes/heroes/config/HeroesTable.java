package com.lucasrmagalhaes.heroes.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.lucasrmagalhaes.heroes.constants.HeroConstant.REGION_DYNAMO;
import static com.lucasrmagalhaes.heroes.constants.HeroConstant.ENDPOINT_DYNAMO;

import java.util.Arrays;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {
    public static void main (String [] args) throws Exception {
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                    .build();

            DynamoDB dynamoDB = new DynamoDB(client);

            String tableName = "Heroes_Table";

            try {
                Table table = dynamoDB.createTable(tableName,
                        Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                        Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                        new ProvisionedThroughput(5L, 5l));

                    table.waitForActive();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}
