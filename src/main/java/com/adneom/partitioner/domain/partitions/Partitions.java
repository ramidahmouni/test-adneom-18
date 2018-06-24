package com.adneom.partitioner.domain.partitions;

import java.util.ArrayList;
import java.util.List;

import com.adneom.partitioner.domain.partitions.partition.Partition;

/**
 * @author rami.dahmouni This domain class is a list of Partition Object who
 *         offer A constructor , Getter , Initializer , List adder (to add list
 *         in existing list Partition) , Updater (to update the list of object
 *         by cleaning and adding the list parameter) , and An add method who
 *         permute to add only one Partition Object
 * 
 *
 */
public class Partitions {

	/** list of partition object attribute **/
	List<Partition> partitionList = new ArrayList<Partition>();

	/**
	 * Default constructor
	 * 
	 * 
	 */
	public Partitions() {
		super();
	}

	/**
	 * getter return list of partition object
	 * 
	 * @return a list of Partition object List<Partition>
	 */
	public List<Partition> getPartitionList() {
		return partitionList;
	}

	/**
	 * setter to set the updater method
	 * 
	 * @param partitionList
	 *            list of Partition Object
	 */
	private void setPartitionList(List<Partition> partitionList) {
		this.partitionList.addAll(partitionList);
	}

	/**
	 * cleaner to clear the list of partition Object partitionList
	 * 
	 * @param partitionList
	 *            a list of Partition object List<Partition>
	 */
	public void InitializePartitionList(List<Partition> partitionList) {
		this.partitionList.clear();
	}

	/**
	 * updater to clean than implement new partition object list
	 * 
	 * @param partitionList
	 *            a list of Partition object List<Partition>
	 */
	public void updatePartitionList(List<Partition> partitionList) {
		this.partitionList.clear();
		setPartitionList(partitionList);
	}

	/**
	 * adder to implement new partition object list
	 * 
	 * @param partitionList
	 *            a list of Partition object List<Partition>
	 */
	public void addPartitionList(List<Partition> partitionList) {
		setPartitionList(partitionList);
	}

	/**
	 * adder to add on partition list objects
	 * 
	 * @param partitions
	 *            Partition
	 */
	public void addPartition(Partition partitions) {
		partitionList.add(partitions);
	}
}
