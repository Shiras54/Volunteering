import java.io.*;
import java.text.*;
import java.util.*;

public class Initiative {
	private String id,name,time,description,status;
	private int credit;
	private List<User> volunteers = new ArrayList<User>();
	private User initiator;
	private Date date;
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	static List<Initiative> initiatives;

	
	public Initiative() {}
	public Initiative(String name, String date, String time, String description, String status, int credit,
			List<User> volunteer, User initiator) {
		setName(name);
		setDate(date);
		setTime(time);
		setDescription(description);
		setStatus("pending");
		
	}
	
	public void saveToFile() {
		try {
			PrintWriter fout = new PrintWriter("initiatives.txt");
			String data = String.format("%s %s %s %s %s %d %s\n",id, name, time, status, description, credit, getDateAsString());
			fout.print(data);
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Initiative searchForInitiative(String id) {
		sortInitiatives();
		int low = 0;
		int high = initiatives.size()-1;
		
		while(low<=high) {
			int middle = (low + high) / 2;
			String idSearch = initiatives.get(middle).id;
			if(id.equals(idSearch)) {
				return initiatives.get(middle);
			} else if(id.compareTo(idSearch)<0) {
				high = middle-1;
			} else if(id.compareTo(idSearch)>0) {
				low = middle+1;
			}
		}
		return null;
	}

	public void checkTime() {
		
	}

	public static void sortInitiatives() {
		Initiative temp;
		for(int i = 0;i<initiatives.size();i++) {
			for(int j = 1;j<(initiatives.size()-i);j++){
				if(initiatives.get(j-1).id.compareTo(initiatives.get(j).id) > 0) {
					temp = initiatives.get(j-1);
					initiatives.set(j-1,initiatives.get(j));
					initiatives.set(j, temp);
				}
			}
		}
	}

	public String getStatus() {return status;}
	public int getCredit() {return credit;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Date getDate() {return date;}
	public String getDateAsString() {
		return format.format(date);
	}
	public void setDate(String date) {
		try {
			this.date = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<User> getVolunteers() {return volunteers;}
	public void setVolunteers(List<User> volunteers) {this.volunteers = volunteers;}
	public User getInitiator() {return initiator;}
	public void setInitiator(User initiator) {this.initiator = initiator;}
	public void setStatus(String status) {this.status = status;}
	public void setCredit(int credit) {this.credit = credit;}
	
}
