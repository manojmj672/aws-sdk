package com.awssdk;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
//import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.SecurityGroup;

public class ListOfSecurityGroup {
	
	public void getAllSecurityGroup() {
//		final String USAGE =
//		        "To run this example, supply a group id\n" +
//		        "Ex: DescribeSecurityGroups <group-id>\n";

//		    if (args.length != 1) {
//		        System.out.println(USAGE);
//		        System.exit(1);
//		    }

//		    String group_id = args[0];

		    final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

//		    DescribeSecurityGroupsRequest requests =
//		        new DescribeSecurityGroupsRequest()
//		            .withGroupIds();

		    DescribeSecurityGroupsResult response =
		        ec2.describeSecurityGroups();

		    System.out.println("--------------------------------------------------------------------------------");
	    	System.out.printf("| %-25s| %-22s| %-26s |%n", "Group Id","VPC Id","Description");
	        System.out.println("--------------------------------------------------------------------------------");
	        
		    for(SecurityGroup group : response.getSecurityGroups()) {
		    	
		    	System.out.printf("| %-24s | %-10s | %-10s |%n",  group.getGroupId() ,group.getVpcId(), group.getDescription());
		        System.out.println("--------------------------------------------------------------------------------");

//		        System.out.printf(
//		            "\n Found security group with id %s, " +
//		            "\n vpc id %s " +
//		            "\n and description %s",
//		            group.getGroupId(),
//		            group.getVpcId(),
//		            group.getDescription());
		    }
	}

}
