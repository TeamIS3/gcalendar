import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Operations like save and load file.
 * This is accessed by the calendar model.
 *
 * @author VictorPantazi
 * @version 1.0
 */
public class CalendarOperation {

	private CalendarModel events;

	public CalendarOperation(){
		this.events = new CalendarModel();
	}

	// load the events into the calendar from a given filename
	// boolean to be used by CalendarModel to check if a file 
	// is already loaded
	public boolean loadCalendar(String filename){						
		BufferedReader bis = null;	   
		try {
		     // open file
			 bis = new BufferedReader(new FileReader(filename));			 
		     String s=null;
		     s = bis.readLine();
		     //while we still have events to read
		     while (s != null) {
		    	 Event ev;
		    	 String name=null,loc=null,desc=null;
			     Date start=null,end=null;
			     //String categories=null;
			     //Time startTime=null,endTime=null;
			     //repetition,reminder
			     
			     name=bis.readLine();		    	 
		    	 loc = bis.readLine();
		    	 desc = bis.readLine();
		    	 //date has '/' as a delimiter
		    	 Scanner sc = 
		    			 new Scanner(bis.readLine())
		    	 				.useDelimiter("/");
		    	 start = new Date(sc.nextInt(),
		    			 sc.nextInt(),sc.nextInt());		    	 
		    	 sc = new Scanner(bis.readLine())
		    	 				.useDelimiter("/");		    	 
		    	 end = new Date(sc.nextInt(),
		    			 sc.nextInt(),sc.nextInt());
		    	 //push event
		    	 ev = new Event(name,loc,desc,start,end);
		    	 this.events.push(ev);
		    	 
		    	 //read delimiters
		    	 bis.readLine();
		    	 s=bis.readLine();
		      }
		      bis.close();		      
		      return true;		    
		    } catch (Exception e) {e.printStackTrace();}		 
		 return false;
	}

	// saves the calendar to the given file
	public boolean saveCalendar(String filename){		  
		 FileOutputStream out;
		 PrintStream p;		 
		 try{
			 out = new FileOutputStream(filename);
			 p = new PrintStream(out);			 
			 Event ev;
			 Iterator<Event> it = events.iterator();			 
			 while(it.hasNext())
			 {				 
				 ev = (Event) it.next();
				 p.println("^^^^^^^^^^");
				 p.println(ev.getName());
				 p.println(ev.getLocation());
				 p.println(ev.getDescription());		
				 p.println(ev.getStartDate());				
				 p.println(ev.getEndDate());
				 // more stuff to be added
				 p.println("vvvvvvvvvv");				
			 }
			 p.close();
			 out.close();
			 return true;
		 } catch (Exception e) { 
				System.err.println ("Error writing to file: "+
						e.getStackTrace()); 
				return false;
		 } 	
	 }
	
    //test method
	/*
	public static void main(String[] args){
		boolean loaded = false;
		System.out.println(loaded);
		CalendarOperation test = new CalendarOperation();
		loaded = test.loadCalendar("test.gcal");
		System.out.println(loaded);
		System.out.println(test.events.peek());
		test.saveCalendar("testing.gcal");
	}
	*/	 
}
