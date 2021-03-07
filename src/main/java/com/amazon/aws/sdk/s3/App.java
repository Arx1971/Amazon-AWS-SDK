package com.amazon.aws.sdk.s3;

import com.amazon.aws.sdk.s3.createbucket.InstantiateS3Bucket;
import com.amazon.aws.sdk.s3.listofbucket.ListAllS3Bucket;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class App {

    public static void main(String[] args) {

        /*InstantiateS3Bucket instantiateS3Bucket = new InstantiateS3Bucket(
                "bucket-" + System.currentTimeMillis());*/

        ListAllS3Bucket listAllS3Bucket = new ListAllS3Bucket();

        List<Bucket> bucketList = listAllS3Bucket.listAllTheBucket();

        bucketList.forEach(name -> {
            System.out.println(name.getName());
        });

    }

}
