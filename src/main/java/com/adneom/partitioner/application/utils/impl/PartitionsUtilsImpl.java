package com.adneom.partitioner.application.utils.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adneom.partitioner.application.utils.PartitionsUtils;

/**
 * Class PartitionsUtilsImpl implements PartitionsUtils
 * 
 * , This class offer a method who will allows you to check if your String list
 * and the maximum size requested by partition is coherent
 * 
 * @author rami.dahmouni
 *
 *
 */
@Component
public class PartitionsUtilsImpl implements PartitionsUtils {

	/*
	 * Checking if the partition size is bigger than strList length And the
	 * partition size is inferior or equal to 0
	 * 
	 * @see com.adneom.partitioner.application.utils.PartitionsUtils#
	 * checkPartitionsSize(java.util.List, java.lang.Integer)
	 */
	@Override
	public Boolean checkPartitionsSize(List<String> strList, Integer partitionSize) {
		// checking if the partition's size is bigger than the length list or
		// zero
		if (partitionSize <= 0 || strList.size() < partitionSize) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
