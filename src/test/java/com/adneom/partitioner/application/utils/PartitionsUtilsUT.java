package com.adneom.partitioner.application.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @Autour rami.dahmouni
 * 
 *         Unit test for PartitionsUtils interface implementation
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartitionsUtilsUT {

	@Autowired
	private PartitionsUtils partitionsUtils;

	/**
	* Unit Test using AssertJ for validation testing 2 cases
	* 
	* Case 1: the partition size is lower than maximum partition size Case 2:
	* the partition size is greaters than maximum partition size
	*/
	@Test
	public void testPartitioner() {

		/* GIVEN */
		/* Case 1 */
		List<String> str1 = new ArrayList<String>();

		str1.add("1");
		str1.add("2");
		str1.add("3");
		str1.add("4");
		str1.add("5");

		Integer partitionSize1 = 2;

		/* Case 2 */
		List<String> str2 = new ArrayList<String>();

		str2.add("1");
		str2.add("2");
		str2.add("3");
		str2.add("4");
		str2.add("5");

		Integer partitionSize2 = 10;

		/* WHEN */
		// calling the methods
		Boolean checkPartitionSizeTrue = partitionsUtils.checkPartitionsSize(str1, partitionSize1);
		Boolean checkPartitionSizeFalse = partitionsUtils.checkPartitionsSize(str2, partitionSize2);

		/* THEN */
		// AssertJ tests
		Assertions.assertThat(checkPartitionSizeTrue).isTrue();
		Assertions.assertThat(checkPartitionSizeFalse).isFalse();
	}
}