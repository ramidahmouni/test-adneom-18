package com.adneom.demo.partitioner.launcher.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LauncherUtils Class demo application utilities
 * 
 * @author rami.dahmouni
 *
 */
public class LauncherUtils {

	
	/**
	 * converting from strInput 
	 * to couple <Integer partitionSize, List<String> listToPartition>
	 * 
	 * @param str
	 *            String
	 * @return partitionSizeAndPartition Map<Integer, List<String>> <partitionSize, listToPartition>
	 */
	public static Map<Integer, List<String>> strInputToPartitionSizeAndStrList(String str) {

		Map<Integer, List<String>> partitionSizeAndPartition = new HashMap<Integer, List<String>>();
		
		// descoping number's list and the partition size
		Integer key = Integer.valueOf(str.split("],")[1]);
		List<String> valuesToPartitionList = Arrays.asList(((str.split("],")[0
		                                                          ]).replace("[", "")).split(","));
		
		// charging the list's number and the partition size values
		partitionSizeAndPartition.put(key, valuesToPartitionList);

		return partitionSizeAndPartition;
	}
	
	/**
	 * checking the format buffer input
	 * 
	 * @param str
	 *            String
	 * @return match TRUE \doesn't match FALSE boolean
	 */
	public static Boolean checkPartitionFormat(String str) {

		// regular expression for checking the input
		String match = "^(([\\[]?([0-9A-Za-z]+[,])*)[0-9A-Za-z]+?[\\]]??),[-]?([0-9]+)$";

		if (!str.matches(match)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
