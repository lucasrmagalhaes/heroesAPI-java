package com.lucasrmagalhaes.herosapi.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.lucasrmagalhaes.herosapi.constants.HeroConstant.REGION_DYNAMO;
import static com.lucasrmagalhaes.herosapi.constants.HeroConstant.ENDPOINT_DYNAMO;

public class HeroesData {
    public static void main (String [] args) throws Exception {
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                    .build();

            DynamoDB dynamoDB = new DynamoDB(client);

            Table table = dynamoDB.getTable("Heroes_Table");
            Item hero = new Item()
                    .withPrimaryKey("id", 1)
                    .withString("name", "Capitão América")
                    .withString("universe", "marvel")
                    .withNumber("films", 3);

            PutItemOutcome outcome = table.putItem(hero);
    }
}
