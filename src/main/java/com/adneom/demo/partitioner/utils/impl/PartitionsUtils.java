package com.adneom.demo.partitioner.utils.impl;

import java.util.List;

/**
 * Class PartitionsUtilsImpl implements PartitionsUtils
 * 
 * , This interface offer a method who will allows you to 
 * check if your String list and the maximum size requested by partition is coherent
 * 
 * @author rami.dahmouni
 *
 *
 */
public class PartitionsUtils {

	/*
	 * Checking if the partition size is bigger 
	 * than strList length 
	 * And the partition size is inferior or equal to 0
	 * 
	 * @see com.adneom.partitioner.application.utils.PartitionsUtils#checkPartitionsSize(java.util.List, java.lang.Integer)
	 */
	public static Boolean checkPartitionsSize(List<String> strList,
			Integer partitionSize) {
			// checking if the partition's size is bigger than the length list or zero
			if (partitionSize <= 0 || strList.size() < partitionSize) {
				return Boolean.FALSE;
			}
			return Boolean.TRUE;
	}
}
