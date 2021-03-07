package com.amazon.aws.sdk.s3.listofbucket;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class ListAllS3Bucket {

    private AmazonS3 s3;

    public ListAllS3Bucket() {
        this.s3 = s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
    }

    public List<Bucket> listAllTheBucket() {

        List<Bucket> buckets = s3.listBuckets();

        System.out.println("Your Amazon S3 buckets are:");

        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }

        return buckets;
    }

}
