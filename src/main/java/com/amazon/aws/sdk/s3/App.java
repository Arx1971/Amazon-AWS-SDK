package com.amazon.aws.sdk.s3;

import com.amazon.aws.sdk.s3.createbucket.InstantiateS3Bucket;

public class App {

    public static void main(String[] args) {

        InstantiateS3Bucket instantiateS3Bucket = new InstantiateS3Bucket(
                "bucket-" + System.currentTimeMillis());

    }

}
