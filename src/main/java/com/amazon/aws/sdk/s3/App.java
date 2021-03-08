package com.amazon.aws.sdk.s3;

import com.amazon.aws.sdk.s3.listofbucket.ListAllS3Bucket;
import com.amazon.aws.sdk.s3.putobject.PutObjectInS3Bucket;
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

        PutObjectInS3Bucket putObjectInS3Bucket = new
                PutObjectInS3Bucket("bucket-1615102333283", "files_input.txt", "c:/Users/rahin/aws_keys/first_up.txt");

        System.out.println(putObjectInS3Bucket.putS3Object());

    }

}
