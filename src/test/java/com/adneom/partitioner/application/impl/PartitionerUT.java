package com.adneom.partitioner.application.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.adneom.partitioner.Application;
import com.adneom.partitioner.application.Partitioner;
import com.adneom.partitioner.domain.partitions.Partitions;

/**
 * @Autour rami.dahmouni
 * 
 *         Class PartitionerUT Unit test for PartitionsUtils interface
 *         implementation
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartitionerUT {

	@Autowired
	private Partitioner partitioner;

	/**
	* Unit Test using AssertJ for validation testing 2 cases
	* 
	* Case 1: the partition size is greater than maximum partition size Case 2:
	* the partition size is equal to the maximum partition size parameter
	*/
	@Test
	public void testUnitPartitioner() {

		/* GIVEN */

		/* case 1 */
		// implementing the String list
		// and put a partition maximum size lower than the partition size
		List<String> str1 = new ArrayList<String>();
		str1.add("1");
		str1.add("2");
		str1.add("3");
		str1.add("4");
		str1.add("5");
		Integer coherentePartitionSize = 2;

		/* case 2 */
		// implementing the String list
		// and put a partition maximum size greater than the partition size
		List<String> str2 = new ArrayList<String>();

		str2.add("a");
		str2.add("b");
		str2.add("c");
		str2.add("d");
		str2.add("e");

		Integer incoherentePartitionSize = 6;

		/* WHEN */
		// calling the method
		Partitions partitionnedList = partitioner.partition(str1, coherentePartitionSize);
		Partitions notPartitionnedList = partitioner.partition(str2, incoherentePartitionSize);

		/* THEN */
		// AssertJ test

		/* Case 1 */
		// the partitioned list result should be null or empty
		Assertions.assertThat(str1).isNotEmpty();
		Assertions.assertThat(partitionnedList).isNotNull();
		Assertions.assertThat(partitionnedList.getPartitionList()).isNotEmpty();
		// checking the coherence of the request
		Assertions.assertThat(str1.size() >= coherentePartitionSize).isTrue();
		Assertions.assertThat(partitionnedList.getPartitionList().stream().findFirst().get().getPartitionedList()
				.size() <= coherentePartitionSize).isTrue();

		/* Case 2 */
		// the partitioned list result should be null or empty
		Assertions.assertThat(str2).isNotEmpty();
		Assertions.assertThat(notPartitionnedList).isNotNull();
		Assertions.assertThat(notPartitionnedList.getPartitionList()).isNotEmpty();
		// checking the coherence of the request
		Assertions.assertThat(str2.size() >= incoherentePartitionSize).isFalse();
		Assertions.assertThat(notPartitionnedList.getPartitionList().stream().findFirst().get().getPartitionedList()
				.size() <= incoherentePartitionSize).isTrue();
	}

	/**
	* Unit Test using AssertJ for validate the adding Object Partitions into
	* List by the method partitioner<Map<Integer, List<String>>
	* 
	* testing the encapsulating implementation into map of key values returning
	* List of the Unit method return s *
	*/
	@Test
	public void testMapPartitioner() {

		/* GIVEN */
		/* case MultiAdding by HashMap */
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

		// Implement map with two couples
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		map.put(partitionSize1, str1);
		map.put(partitionSize2, str2);

		/* WHEN */
		// calling the method
		List<Partitions> partitionnedList = partitioner.partition(map);

		/* THEN */
		// AssertJ test
		Assertions.assertThat(str1).isNotEmpty();
		Assertions.assertThat(str2).isNotEmpty();
		Assertions.assertThat(partitionnedList).isNotNull();
		Assertions.assertThat(partitionnedList).isNotEmpty();
	}
}