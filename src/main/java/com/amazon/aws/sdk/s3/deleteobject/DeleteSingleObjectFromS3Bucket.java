package com.amazon.aws.sdk.s3.deleteobject;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteSingleObjectFromS3Bucket {

    private final String bucketName;
    private final AmazonS3 amazonS3;
    private final String objectName;
    private final Regions regions;

    public DeleteSingleObjectFromS3Bucket(String bucketName, String objectName) {
        this.objectName = objectName;
        this.bucketName = bucketName;
        this.regions = Regions.US_EAST_1;
        this.amazonS3 = AmazonS3ClientBuilder.standard().withRegion(regions).build();
        deleteObjectFromBucket();
    }

    public void deleteObjectFromBucket() {
        try {
            this.amazonS3.deleteObject(this.bucketName, this.objectName);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }


}
