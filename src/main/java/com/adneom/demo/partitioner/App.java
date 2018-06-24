package com.adneom.demo.partitioner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.adneom.demo.partitioner.launcher.Launcher;


/**
 * AccessPoint demo application
 *
 * * @author rami.dahmouni
 * 
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {    	
    	// launcher
    			Launcher.partitioning(new BufferedReader(new InputStreamReader(System.in)));
    }
}
