package com.adneom.partitioner.application.impl;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adneom.demo.partitioner.impl.Partitioner;
import com.adneom.partitioner.domain.partitions.Partitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**@Autour rami.dahmouni
 * 
 * Class PartitionerUT
 * Unit test for PartitionsUtils interface implementation 
 * 
 */
@SpringBootTest
public class PartitionerUT 
{
	
	@Autowired
	private Partitioner partitioner;
	
	/**
	 * Unit Test using AssertJ for validation 
	 * testing 2 cases
	 * 
	 * Case 1: 
	 * 		the partition size is greater than maximum partition size
	 * Case 2: 
	 * 		the partition size is equal to the maximum partition size parameter
	 */
	@Test
	public void testUnitPartitioner() {

		/* case 1 */
		List<String> str1 = new ArrayList<String>();

		str1.add("1");
		str1.add("2");
		str1.add("3");
		str1.add("4");
		str1.add("5");

		Integer partitionSize1 = 2;

		/* case 2 */
		List<String> str2 = new ArrayList<String>();

		str2.add("a");
		str2.add("b");
		str2.add("c");
		str2.add("d");
		str2.add("e");

		Integer partitionSize2 = 5;
		
		// calling the method
		Partitions partitionned1 = Partitioner.partition(str1, partitionSize1);
		Partitions partitionned2 = Partitioner.partition(str2, partitionSize2);

		//AssertJ test
		Assertions.assertThat(str1).isNotEmpty();
		Assertions.assertThat(partitionned1).isNotNull();
		Assertions.assertThat(partitionned1.getPartitionList()).isNotEmpty();
		
		Assertions.assertThat(str2).isNotEmpty();
		Assertions.assertThat(partitionned2).isNotNull();
		Assertions.assertThat(partitionned2.getPartitionList()).isNotEmpty();
	}
	
	/**
	 * Unit Test using AssertJ for validate 
	 * 		the adding Object Partitions into List 
	 * 		by the method partitioner<Map<Integer, List<String>>  
	 * 
	 * testing the encapsulating implementation 
	 * 				into map of key values returning List of the Unit method return
s	 * 
	 */
	@Test
	public void testMapPartitioner() {

		/* case MultiAdding by HashMap*/
		List<String> str1 = new ArrayList<String>();

		str1.add("1");
		str1.add("2");
		str1.add("3");
		str1.add("4");
		str1.add("5");

		Integer partitionSize1 = 2;

		List<String> str2 = new ArrayList<String>();

		str2.add("a");
		str2.add("b");
		str2.add("c");
		str2.add("d");
		str2.add("e");

		Integer partitionSize2 = 5;
		
		//Implement map with two couples
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		map.put(partitionSize1, str1);
		map.put(partitionSize2, str2);
		
		// calling the method
		List<Partitions> partitionnedList = Partitioner.partition(map);

		//AssertJ test
		Assertions.assertThat(str1).isNotEmpty();
		Assertions.assertThat(str2).isNotEmpty();
		Assertions.assertThat(partitionnedList).isNotNull();
		Assertions.assertThat(partitionnedList).isNotEmpty();
	}
}
