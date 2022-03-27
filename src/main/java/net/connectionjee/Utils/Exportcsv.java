package net.connectionjee.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import net.connectionjee.User;

public class Exportcsv {
	
	public void exportList(List<User> listusers) {
		 String csvFilePath = "Reviews-export.csv";
		try {
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

	            // write header line containing column names       
	            fileWriter.write("ID,Email,CNE,CIN,Fillier");
	             
	            for (User result : listusers) {
//	                String courseName = result.getString("course_name");
//	                String studentName = result.getString("student_name");
//	                float rating = result.getFloat("rating");
//	                Timestamp timestamp = result.getTimestamp("timestamp");
//	                String comment = result.getString("comment");
//	                 
	                
	                 
	                String line = String.format("\"%s\",%s,%s,%s,%s",
	                		String.valueOf(result.getId()), result.getEmail(), result.getCNE(), result.getCIN(), result.getFiliere());
	                 
	                fileWriter.newLine();
	                fileWriter.write(line);            
	            }
	             
	            fileWriter.close();
		}catch (IOException e){
			
		}
			}

}
