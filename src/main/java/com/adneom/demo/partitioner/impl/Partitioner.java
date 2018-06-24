package com.adneom.demo.partitioner.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.adneom.partitioner.domain.partitions.Partitions;
import com.adneom.partitioner.domain.partitions.partition.Partition;

/**@author rami.dahmouni
 * This class implements Partitioner Interface
 * ComposedBy\
 *  - Unit return method Partitions Object
 * 1. the first method take in 
 * Parameter a list of strList List<String> to partition 
 * and the partition maximum size to allow
 * - return a Partitions Object 
 * with List of Partition Object listed 
 * with the maximum partition size parameter
 * 
 * And\ - List return method List<Partitions> Partitions Object list
 * 2. the second method take in 
 * Parameter a Map<Integer, List<String>>
 *  strList List<String> as value
 * and the partition maximum size to allowed as key
 * - return a list of the Partitions Object 
 * with List of Partitions Object listed and partitioned
 * with the maximum partition size parameter of each of them
 * 
 *
 */
public class Partitioner {

	
	/*
	 * This method allows your to partition 
	 * a List of String
	 * And Integer partitionMaxSize
	 * 
	 * and return List of Partitions Object partitioned 
	
	 * @see com.adneom.partitioner.application.Partitioner#partition(java.util.List, java.lang.Integer)
	 */
	public static Partitions partition(List<String> strList, Integer partitionSize) {

		// Initializing a list of sub lists 
		Partitions partitionedstrs = new Partitions();

		// transient String list for implementing the upper list of sub lists
		Partition partition = new Partition();

		// counter who we help to know where we are positioning
		Integer partitionCounter = 0;
		Integer numbersListCounter = strList.size() - 1;
		
		// null or empty list to partition or incoherence partition request
		if(strList != null && !strList.isEmpty() && partitionSize != null && partitionSize < strList.size()) {
		//Procuring the list of numbers to partition
		for(String number : strList) {
			
			/* adding value into sub list */
			partition.addStr(number);
			// incrementing partition position
			partitionCounter++;
			

			if (partitionCounter == partitionSize|| numbersListCounter == 0) {
				// implementing the transient list in the sub-list
				partitionedstrs.addPartition(partition);
				// initializing the transient list
				partition = new Partition();
				// initializing partition position once its been reached
				partitionCounter = 0;

			}
			
			// decrementing numbers list position
			numbersListCounter--;

		}
		//return a list of sub
		return partitionedstrs;
		
		}// in case of unit partition size is equal or greater than the list value size
		else if(partitionSize >= strList.size() || 
				(strList != null && !strList.isEmpty() && (partitionSize == null || partitionSize == 0))) {
			
			partition = new Partition(strList);
			partitionedstrs.addPartition(partition);
			return partitionedstrs;
		}
			else {
				//returning empty values
				return new Partitions();
		}
			
	}

	/*
	 * This method allow your to partition 
	 * a HashMap of Integer (partitionSize) as Key 
	 * and list of String as (strsListToPartition) as Value 
	 * 
	 * and get List of Partitions Object partitioned 
	
	 * @see com.adneom.partitioner.application.Partitioner#partition(java.util.Map)
	 */
	public static List<Partitions> partition(Map<Integer, List<String>> mapPartitionSizeListStr) {
		
		// Initializing a list of sub lists 
		List<Partitions> partitionedListstrs = new ArrayList<Partitions>();
				
		//transient values
		Partitions partitions = new Partitions();
		
		if(mapPartitionSizeListStr != null && !mapPartitionSizeListStr.isEmpty()) {
			
			//Entry Map
			for(Map.Entry<Integer, List<String>> entry : mapPartitionSizeListStr.entrySet()) {
		
			
					Integer partitionSize = entry.getKey();
					List<String> strList = entry.getValue();
				
					//calling unit method
					partitions = Partitioner.partition(strList, partitionSize);

					partitionedListstrs.add(partitions);
			}
		
			//return a list of partitioned Partition Object
			return partitionedListstrs;
		} else {
			return new ArrayList<Partitions>();
		}
	}
}
