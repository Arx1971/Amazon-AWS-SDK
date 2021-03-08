package com.amazon.aws.sdk.s3.createbucket;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class InstantiateS3Bucket {

    private final S3Client s3Client;
    private final String bucketName;
    private final Region region;

    public InstantiateS3Bucket(String bucketName) {
        this.bucketName = bucketName;
        this.region = Region.US_EAST_2;
        this.s3Client = S3Client.builder().region(region).build();
        createS3Bucket();
    }

    public void createS3Bucket() {
        try {
            this.s3Client.createBucket(
                    CreateBucketRequest.builder()
                            .bucket(this.bucketName)
                            .createBucketConfiguration(
                                    CreateBucketConfiguration.builder()
                                            .locationConstraint(this.region.id()).build()).build());

            System.out.println("Creating Bucket: " + this.bucketName);

            this.s3Client.waiter().waitUntilBucketExists(HeadBucketRequest.builder().bucket(this.bucketName).build());

            System.out.println(this.bucketName + " is Ready.\n");

        } catch (S3Exception e) {

            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);

        }

    }

}
