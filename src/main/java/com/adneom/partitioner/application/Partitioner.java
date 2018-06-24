package com.adneom.partitioner.application;

import java.util.List;
import java.util.Map;

import com.adneom.partitioner.domain.partitions.Partitions;


/**@author rami.dahmouni
 * 
 * This interface offer two method's calls depending of your need
 *
 * 
 * - Unit return Partitions Object's call method partitioning parametred
 * by unit list to partition 
 * and its parameter partition maximum size
 * 
 * - List return list of Partitions Object's call method partitioning parametred
 * by Map<Key:Integer partitionSize, Value:List<String> strList> 
 *
 */
public interface Partitioner {

	/**
	 * 
	 * Unit return method Partitions Object
	 * this method take in 
	 * parameter a list of strList List<String> to partition 
	 * and the partition maximum size to allow
	 * - return a Partitions Object 
	 * with List of Partition Object listed 
	 * with the maximum partition size parameter
	 * 
	 * @param numbersList
	 *            list of String 
	 * @param partitionSize
	 *            Integer the maximum partition size
	 *            
	 *         
	 * @return Partitions Object
	 */
	Partitions partition(final List<String> strList, final Integer partitionSize);
	
	/**
	 * List return method List<Partitions> Partitions Object's list
	 * this method take in 
	 * parameter a Map<Integer, List<String>>
	 *  strList List<String> as value
	 * and the partition maximum size to allowed as key
	 * - return a list of the Partitions Object 
	 * with List of Partitions Object listed and partitioned
	 * with the maximum partition size parameter of each of them
	 * 
	 * @param mapPartitionSizeListStr 
	 * 				HashMap of partitionSize as key and strList as Value
	 * 
	 * 
	 * @return list of Partitions Object
	 */
	List<Partitions> partition(final Map<Integer, List<String>> mapPartitionSizeListStr);
}
