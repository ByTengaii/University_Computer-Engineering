// Name:Gürkan
// Surname:AĞIR


import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

class Earthquake {
	private String location;
	private String date; // DD.MM.YYYY
	private String time; // HH:MM:SS

	private double magnitude;
	private double depth;
	public Earthquake next;
	public Earthquake prev;

	//add all necessary set and get methods, and other methods you need
	public Earthquake(String newLocation, String newDate, String newTime, double newMagnitude, double newDepth) {
		this.location = newLocation;
		this.date = newDate;
		this.time = newTime;
		this.magnitude = newMagnitude;
		this.depth = newDepth;
		next = null;
		prev = null;
	}

	public String getLocation(){
		return location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getTime(){
		return time;
	}

	public void setTime(String time){
		this.time = time;
	}

	public double getMagnitude(){
		return magnitude;
	}

	public void setMagnitude(){
		this.magnitude = magnitude;
	}

	public double getDepth(){
		return depth;
	}

	public void setDepth(double depth){
		this.depth = depth;
	}

	public void displayData(FileWriter writer) throws IOException{
		writer.write(this.getLocation()+" "+this.getDate()+" "+this.getTime()+" Magnitude: "+this.getMagnitude()+" Depth: "+this.getDepth()+" km\n");
	}
}
////////////////////////////////////////////////////////////////
class EarthquakeLinkedList {

	private Earthquake head;
	private Earthquake tail;

	public EarthquakeLinkedList() {
		head = null;
		tail = null;
	}

	//Adding earthquake end of the list
	public void add(Earthquake earthquake){
		if(head==null){
			head = earthquake;
			tail = earthquake;
		}else{
			tail.next = earthquake;
			earthquake.prev = tail;
			tail = earthquake;
		}
	}

	//Delete the information that matches with the parameters which user given.
	public void delete(String location, String date, String time){
		Earthquake current = head;
		while (current != null){
			if(current.getLocation().equals(location) && current.getDate().equals(date) && current.getTime().equals(time)){
				if(current.prev == null){
					head = current.next;
				}else if(current.next == null){
					tail = current.prev;
				}else{
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				return; // if we delete the information. We don't need continue to searching
			}
			current = current.next;
		}
	}

	public void findString(String option, FileWriter writer) throws IOException{
		Earthquake current = head;
		while (current != null){
			if(current.getLocation().equals(option) || current.getDate().equals(option)){
				current.displayData(writer);
			}
			current = current.next;
		}
	}

	public void findDepthNumber(String symbol, Double value, FileWriter writer) throws IOException{
		Earthquake current = head; 
		switch(symbol){
			case "=":
				while(current != null){
					if(current.getDepth() == value){
						current.displayData(writer);
					}
					current = current.next;
				}
				break;
			case ">":
				while(current != null){
					if(current.getDepth() > value){
						current.displayData(writer);
					}
					current = current.next;
				};
				break;
			case "<":
				while(current != null){
					if(current.getDepth() < value){
						current.displayData(writer);
					}
					current = current.next;
				}
				break;
			default:
				System.out.println("Undeclared symbol for depth query");
				break;

		}

	}

	public void findMagnitudeNumber(String symbol, Double value, FileWriter writer) throws IOException{
		Earthquake current = head; 
		switch(symbol){
			case "=":
				while(current != null){
					if(current.getMagnitude() == value){
						current.displayData(writer);
					}
					current = current.next;
				}
				break;
			case ">":
				while(current != null){
					if(current.getMagnitude() > value){
						current.displayData(writer);
					}
					current = current.next;
				}
				break;
			case "<":
				while(current != null){
					if(current.getMagnitude() < value){
						current.displayData(writer);
					}
					current = current.next;
				}
				break;
			default:
				System.out.println("Undeclared symbol for depth query");
				break;
		}
	}


	public void query(String q,FileWriter writer) throws IOException {
		String[] query = q.split(" ");

		switch(query[0]){
			case "Add":
				String location1 = query[1];
				String date1 = query[2];
				String time1 = query[3];
				double magnitude = Double.parseDouble(query[5]);
				double depth = Double.parseDouble(query[7]);
				Earthquake earthquake = new Earthquake(location1, date1, time1, magnitude, depth);
				add(earthquake);
				displayList(writer);
				writer.write("-\n");
				break;
			case "Delete":
				String location2 = query[1];
				String date2 = query[2];
				String time2 = query[3];
				delete(location2,date2,time2);
				displayList(writer);
				writer.write("-\n");
				break;
			case "Query":
				String option = query[1];
				if(option.equals("all")){
					displayList(writer);
					break;
				}
				String symbol = query[2];
				switch(option){
					case "depth":
						double value1 = Double.parseDouble(query[3]);
						findDepthNumber(symbol,value1,writer);
						writer.write("-\n");
						break;
					case "magnitude":
						double value2 = Double.parseDouble(query[3]);
						findMagnitudeNumber(symbol,value2,writer);
						writer.write("-\n");
						break;
					case "location":
						if( !symbol.equals("=")){
							System.out.println("You can just use '=' operator for location option");
							break;
						}
						String locationData = query[3];
						findString(locationData,writer);
						writer.write("-\n");
						break;
					case "date":
						String date3 = query[3];
						findString(date3,writer);
						writer.write("-\n");
						break;
					default:
						System.out.println("Invalid query option");
						break;
				}
				break;
		}
	}
	
	// This function displays the LinkList content
	public void displayList(FileWriter writer) throws IOException {
		Earthquake current = head;
		while(current!=null){
			current.displayData(writer);
			current = current.next;
		}
	}
}

////////////////////////////////////////////////////////////////
public class Test {
	public static EarthquakeLinkedList eList = new EarthquakeLinkedList();
	
	public static void readInput(String fileName) {
		try{
			File file  = new File(fileName);
			Scanner scanner = new Scanner(file);

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] tokens = line.split(" ");

				String location = tokens[0];
				String date = tokens[1];
				String[] timeTokens = tokens[2].split(":");
				String time = timeTokens[0]+":"+timeTokens[1]+":"+timeTokens[2];
				double magnitude = Double.parseDouble(tokens[4]);
				double depth = Double.parseDouble(tokens[6]);
				Earthquake newEarthquake = new Earthquake(location, date, time, magnitude, depth);
				eList.add(newEarthquake);
			}
			scanner.close();

		} catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}
		public static void readQueries(String fileName, FileWriter writer) throws IOException{
			try{
				File file  = new File(fileName);
				Scanner scanner = new Scanner(file);

				while(scanner.hasNextLine()){
					String query = scanner.nextLine();
					eList.query(query,writer);
				}
				scanner.close();
			} catch(IOException e){
				e.printStackTrace();
			}

		}
	
	public static void main(String[] args) {
		try{
			File outputFile = new File("output.txt");
			FileWriter writer = new FileWriter(outputFile);

			readInput("input.txt");
			eList.displayList(writer);
			writer.write("-\n");
			readQueries("request.txt", writer);
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	
	}
}


