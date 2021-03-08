package com.amazon.aws.sdk.s3.putobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PutObjectInS3Bucket {

    private String bucketName;
    private String objectKey;
    private String objectPath;

    public PutObjectInS3Bucket(String bucketName, String objectKey, String objectPath) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.objectPath = objectPath;
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
