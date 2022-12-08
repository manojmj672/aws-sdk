package com.awssdk;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.ListUsersRequest;
import com.amazonaws.services.identitymanagement.model.ListUsersResult;
import com.amazonaws.services.identitymanagement.model.User;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

@SpringBootApplication
public class AwsSdkAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSdkAppApplication.class, args);
		
				//Creating amazon s3 client
//				final AmazonS3 s3 = AmazonS3ClientBuilder.standard() .build();
				//Listing all the buckets
//				List<Bucket> buckets = s3.listBuckets();

				//Iterating through the bucket
//				buckets.stream().forEach(bucket -> {
//				System.out.println("Bucket Name : " + bucket.getName() + ", "
//						+"\nBucket Owner : " +bucket.getOwner() .getDisplayName ()
//				+",\nBucket Creation Date : " + bucket.getCreationDate());
//
//				});
				
				
				
				final AmazonIdentityManagement iam =
	            AmazonIdentityManagementClientBuilder.defaultClient();

	        boolean done = false;
	        ListUsersRequest request = new ListUsersRequest();

	        while(!done) {
	            ListUsersResult response = iam.listUsers(request);

	            for(User user : response.getUsers()) {
	            	System.out.format("\n Retrieved user : %s", user.getUserName());
	                System.out.format("\n Password last changed : %s", user.getPasswordLastUsed());
	               
	            }

	            request.setMarker(response.getMarker());

	            if(!response.getIsTruncated()) {
	                done = true;
	            }
	        }
				
		
	}
}
