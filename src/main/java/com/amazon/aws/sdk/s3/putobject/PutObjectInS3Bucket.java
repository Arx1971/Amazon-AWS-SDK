package com.amazon.aws.sdk.s3.putobject;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PutObjectInS3Bucket {

    private String bucketName;
    private String objectKey;
    private String objectPath;
    private S3Client s3Client;
    private Region region;

    public PutObjectInS3Bucket(String bucketName, String objectKey, String objectPath) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.objectPath = objectPath;
        this.region = Region.US_EAST_2;
        this.s3Client = S3Client.builder().region(region).build();
    }

    public String putS3Object() {

        try {

            Map<String, String> metadata = new HashMap<>();

            metadata.put("myVal", "test");

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(this.bucketName)
                    .key(this.objectKey)
                    .metadata(metadata)
                    .build();

            PutObjectResponse response = s3Client.putObject(request,
                    RequestBody.fromBytes(getObjectFile()));

            s3Client.close();

            return response.eTag();

        } catch (S3Exception s3Exception) {
            System.err.println(s3Exception.getMessage());
            System.exit(1);
        }

        return "";
    }

    private byte[] getObjectFile() {
        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(this.objectPath);
            bytesArray = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bytesArray;
    }

}
