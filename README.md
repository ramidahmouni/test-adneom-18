Partitioner interface caller


Architecture

	  com.adneom.partitioner
	  |
	  |
	/* application implementation layer */
	  |
      |
	  |___application.partitioner Partitioner Interface to autowired
		  |
	      |___application.partitioner.impl PartitionImpl Class implements Partitioner
		  |
	      |___application.partitioner.utils PartiionsUtils Interface to autowired
		     |
		     |___application.partitioner.utils.impl PartitionsUtilsImpl implements PartitionsUtils
	/* domain Object layer */
	  |
	  |___domain.partitions Partitions Object contain a list Partition Object
	      |
	      |___domain.partitions.partition Partition Object contain a list of partitioned list
		  
	/* demo application */
	/* the .gitignore hasn't been added to permete the upload of the partitioner-demo-v.1.0.jar for testing the implementation */
	  |___demo implementation 'App Class' (Java Application deployment AccessPoint) by partitioning method from the Launcher Class
		  |___demo.partitioner Launcher Class and some utilities for input buffer
		
		
Deployment 

This is spring boot application deployment mode.

	- The Class com.adneom.partitioner.demo.App 
	allows you to deploy a demonstration application to test the implementation work as a Java Application 
	from the eclipse console or by calling the partitioner-demo-1.0.jar.
	by the windows command line "java -jar partition-demo-1.0.jar"
	
	- The Class com.adneom.partitioner.Application allows you to deploy the interface implementations into spring boot environment 
	and permet to @autowired the interface implementation from your project.


Documentation

The Partitioner interface
	
	This Interface offers two methods call

	com.adneom.partitioner.application.Partitioner.partition(List<String> strList, Integer partitionMaxSize);
	The first one will partition a list of String Object and return it, attributing maximum value per partition as parameters.
	It will return a partitioned list of the strList parameter 
	
	com.adneom.partitioner.application.Partitioner.partition(Map<Integer partitionMaxSize, List<String> strList>);
	The second one will partition a map of list Partition Object always depending of 
	the maximum value per partition as a key and the String list to partition
 	in the map parameters
	It will return a list of Partitions Object of partitioned strList Map

The PartitionsUtils interface

	This Interface offers a method checker
	
	com.adneom.partitioner.application.utils.PartitionsUtils.checkPartitionsSize(List<String> strList, Integer partitionSize);
	This method takes a String list and a Integer as parameters and checks if the partitioning requested is coherent
	It will return FALSE if it's not coherent and TRUE if it is.
	
	
Build install

	Update your dependencies (Maven -> Update Project)
	
	Maven clean install
		
	Maven build install

	Run Junit tests

	
Code

    
    To get started you will need Maven Project 

    Install dependencies needed

    Adding the partitioner-SNAPSHOT-V.1.0.0.jar generated after building the project as an External Jar in the Referencies Library

    Using Partitions Object as Object response of the method Unit partitioning

    Using a list of Partitions Objects in case you need to partition a Map of String values and its partition maximum size

    Use @Autowired springbootframework to surcharge the interfaces 

    Call the implementation using interface surcharged into your implementations

    Delopying spring boot framework	


References: 

	https://spring.io/projects/spring-boot
	https://mvnrepository.com/
	
	
rami.dahmouni@unknowns.domain