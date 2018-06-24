package com.adneom.partitioner.application.utils;

import java.util.List;


/**@author rami.dahmouni
 * Interface PartitionsUtils
 * 
 * , This interface offer a method who will allows you to 
 * check if your String list and the maximum size requested by partition is coherent
 * 
 *
 */
public interface PartitionsUtils {
	
	/**
	 * Checking if the partition size is bigger 
	 * than strList length 
	 * And the partition size is inferior or equal to 0
	 * 
	 * 
	 * @param strList
	 *            list of Numbers into String list
	 * @param partitionSize
	 *            Integer maximum partition's size
	 * @return boolean
	 */
	Boolean checkPartitionsSize(List<String> strList, Integer partitionSize);
}
