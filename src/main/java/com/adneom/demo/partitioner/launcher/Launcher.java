package com.adneom.demo.partitioner.launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.adneom.demo.partitioner.impl.Partitioner;
import com.adneom.demo.partitioner.launcher.utils.LauncherUtils;
import com.adneom.demo.partitioner.utils.impl.PartitionsUtils;
import com.adneom.partitioner.domain.partitions.Partitions;
import com.adneom.partitioner.domain.partitions.partition.Partition;


/**
 * Launcher Class demo application 
 * using eclipse console or command line console
 * 
 * this class  
 * 				demonstrate the implementation return
 * 
 * @author rami.dahmouni
 *
 */
public class Launcher {


	/**
	 * demonstration Application partitioner launcher
	 * 
	 * @param br
	 *            BufferReader
	 * @throws IOException
	 */
	public static void partitioning(BufferedReader br) throws IOException  {
			
		// reading buffer in
		br = new BufferedReader(new InputStreamReader(System.in));

		// initializing checkers
		Boolean formatChecker = Boolean.FALSE;
		Boolean logicChecker = Boolean.FALSE;

		// inputs
		Integer partitionSize = null;
		List<String> strList = null;
		String input = null;
		
		// welcome message
		welcomeMessage();
			
			
			// while input not validated, input requested
			while (!formatChecker || !logicChecker) {
			
				input = br.readLine();

				// once user want to quit the application demonstration
				if ("q".equals(input)) {
					
					//exit buffer
					exit();
				}
				
				// checking the format of input
				formatChecker = LauncherUtils.checkPartitionFormat(input);
				
				if (formatChecker) {
					
					//Transacting input launcher into map <partitionSize, strList> with one key and value
					Map<Integer, List<String>> mapPartitionSizeListStr = LauncherUtils.strInputToPartitionSizeAndStrList(input);
					
					//Entry Map
					Map.Entry<Integer, List<String>> entry = mapPartitionSizeListStr.entrySet().iterator().next();
		
					partitionSize = entry.getKey();
					strList = entry.getValue();
				
					// checking the partition's size
					logicChecker = PartitionsUtils.checkPartitionsSize(strList, partitionSize);
					
					if(logicChecker) {
						
							// partitioning the input
							Partitions partitionedList = Partitioner.partition(strList, partitionSize);

							// out putting the result
							System.out.print("\nYour result : ");
							System.out.print("[");
							
							//partitioned list position
							Integer mapCounter = 0;
							//loop partitioned list
							for(Partition partition : partitionedList.getPartitionList()) {
								
								if(mapCounter != 0 && mapCounter != partitionedList.getPartitionList().size()) {
									System.out.print(",");
								}
								
								// out putting the result
								System.out.print(partition.getPartitionedList().toString());
								mapCounter++;
							}
							System.out.print("]");

					} else {
						//error message output
						System.err.print("\nThe partition size has to be greater than zero and couldn't be bigger than the length list's number\n");
						// out putting Retry : 
						System.out.print("Retry : ");
					}
					
				} else {
					//error message output
					System.err.print("\nincorrect format\n");
					// out putting Retry : 
					System.out.print("Retry : ");
				}
				
			}
	}
	
	/**
	 * 
	 * welcome message demo
	 */
	public static void welcomeMessage() {
		// welcome message
					System.out
							.print("----------------------------------------------------------------------"
									+ "------------------------------------------------------------------------"
									+ "\n---Welcome to the demo partitioner application, you can take in exemple "
									+ "'[1,12,123,1234,12345],2' to partition a list of number for exemple---"
									+ "\n---------------------------------------------------------------------"
									+ "-------------------------------------------------------------------------"
									+ "\n\nenter q for exit.\n\n"
		 							+ "\n\nPlease enter your text : ");
	}
	
	/**
	 * 
	 * Exit buffer function
	 */
		public static void exit() {
			System.out.println("\nExit succed");
			System.exit(0);
		}
}
