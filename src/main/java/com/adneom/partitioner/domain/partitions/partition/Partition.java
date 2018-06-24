package com.adneom.partitioner.domain.partitions.partition;

import java.util.ArrayList;
import java.util.List;

/**@author rami.dahmouni
 * This domain class is a list of String Object who offer 
 * a constructor
 * , getter 
 * , initializePartition (to update the list of object by cleaning and adding the list parameter)
 * and 
 * an add method who permute to add only one Partition Object
 * 
 */
public class Partition {

	/** partition Strings list attribute **/
	List<String> partitionedList = new ArrayList<>();


	/**
	 * Default constructor
	 * 
	 */
	public Partition() {
		super();
	}

	/**
	 * constructor with parameters
	 * 
	 * @param partition
	 */
	public Partition(List<String> strList) {
		partitionedList.clear();
		partitionedList.addAll(strList);
	}
	
	/**
	 * getter list of String
	 * 
	 * @return partition list of String
	 */
	public List<String> getPartitionedList() {
		return partitionedList;
	}

	/**
	 * initializer partition function
	 * 
	 */
	public void initializePartition() {
		partitionedList.clear();
	}
	
	/**
	 * add String list to the existing list
	 * 
	 * @param strList list of String
	 */
	public void addStrsList(List<String> strList) {
		partitionedList.addAll(strList);
	}
	
	/**
	 * updater to clean than implement the StringList List<String>
	 * 
	 * @param strList list of String
	 */
	public void updateStrsList(List<String> strList) {
		partitionedList.clear();
		partitionedList.addAll(strList);
	}
	
	/**
	 * add String to the existing list
	 * 
	 * @param str String
	 */
	public void addStr(String str) {
		partitionedList.add(str);
	}
}
