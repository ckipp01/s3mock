package io.kipp.s3mock.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.kipp.s3mock.S3Mock;

/**
 * Created by shutty on 8/12/16.
 */
public class JavaExample {
    public static void main(String[] args) {
        S3Mock api = S3Mock.create(8001, "/tmp/s3");
        api.start();

        AmazonS3 client = AmazonS3ClientBuilder
                .standard()
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8001", "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))
                .build();
        client.createBucket("testbucket");
        client.putObject("testbucket", "file/name", "contents");
    }
}
