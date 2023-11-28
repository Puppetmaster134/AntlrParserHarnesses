import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.awt.Event;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

import org.antlr.v4.gui.*;

public class Runner {
	public static void main(String[] args) {
		if (args.length == 0)
		{
			System.out.println("No file argument provided");
			System.exit(1);
		}
		
		/*
		 * Load in the Program
		 */
		String programPath = args[0];
		CharStream program = null;
		try {
		    program = fromFileName(programPath);  //load the file
		}catch(Exception e) {System.err.println(e.getMessage()); return;};

		Timer timer = new Timer();
		/*
		 * Prepare the Runner Thread
		 */
		RunnerThread runner = new RunnerThread(program, timer);
		
		
		/*
		 * Start the timer and thread
		 */
		TimerThread resourceRecorder = new TimerThread(runner.getId());
		timer.scheduleAtFixedRate(resourceRecorder, 0, 10);
		runner.start();
		try {
			runner.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * Things become synchronous here again so it's safe to do stuff (i think)
		 */
		
		
		String outputBase = args.length == 2 ? args[1] : "tmp";
		
		try {
			FileWriter writer = new FileWriter(outputBase + ".mem");
			BufferedWriter buffer = new BufferedWriter(writer);
			
			//Memory Stuff
			resourceRecorder.memory.forEach((eventMap) -> {
				Entry<Long, Long> event = eventMap.entrySet().iterator().next();
				try {
					buffer.write(event.getKey() + "," + event.getValue());
					buffer.newLine();
				} catch (IOException e) { e.printStackTrace(); }
			});
			
			buffer.close();
		} 
		catch (IOException e) { e.printStackTrace(); }
		
		
		
		try {
			FileWriter writer = new FileWriter(outputBase + ".cpu");
			BufferedWriter buffer = new BufferedWriter(writer);
			
			//Memory Stuff
			resourceRecorder.cpu.forEach((eventMap) -> {
				Entry<Long, Long> event = eventMap.entrySet().iterator().next();
				try {
					buffer.write(event.getKey() + "," + event.getValue());
					buffer.newLine();
				} catch (IOException e) { e.printStackTrace(); }
			});
			
			buffer.close();
		} 
		catch (IOException e) { e.printStackTrace(); }

		try {
			FileWriter writer = new FileWriter(outputBase + ".tree");
			BufferedWriter buffer = new BufferedWriter(writer);
			
			try {
				buffer.write(runner.treeString);
			} catch (IOException e) { e.printStackTrace(); }
			
			buffer.close();
		} 
		catch (IOException e) { e.printStackTrace(); }
        
        
        
	}
	


}
