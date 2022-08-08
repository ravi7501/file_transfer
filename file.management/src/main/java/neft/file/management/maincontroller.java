package neft.file.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalTime;


import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.web.client.RestTemplate;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import neft.file.management.entity.data_table;
import neft.file.management.sshcon;

import com.jcraft.jsch.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;




@Controller
public class maincontroller  {
	@Autowired
	service Service;
    
	
	
	  
	 DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss"); //To set the time format
	 SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");//To set the time format
	 
	 LocalDateTime now = LocalDateTime.now(); // To read System time only

	 String systimes=dtf1.format(now);  // Convert system time in simple date format

	 
	 
	 
	 
	 public String GetTimeDiff(String time) {  // This Function will take (Last Modified Time) and Will return Pending time as P_time.
		   
		   String thistime=time;
		   
		   String p_time,h,m,s;
		                                        // From here we are breaking string of last modfide time to read as time.
		   String mn=thistime.substring(2,4);
		 
		   String hr =thistime.substring(0,2);
		  
		   String sec=thistime.substring(4,6);
		   
		   String filet=hr+":"+mn+":"+sec;
		   
		   try {
		   Date d01 = sdf1.parse(systimes);
		  

	       Date d02 = sdf1.parse(filet);
	      
		   
	       long dif_in_time = Math.abs(d01.getTime() - d02.getTime());  // Geting difference between system time and lastmodified time
		
		   
		   int seconds = (int) (dif_in_time / 1000) % 60 ;        // Changing difference that is in milisec to hr
		   s=String.valueOf(seconds);
		   int minutes = (int) ((dif_in_time / (1000*60)) % 60);        // Changing difference that is in milisec to min
		   int hours   = (int) ((dif_in_time / (1000*60*60)) % 24);       // Changing difference that is in milisec to sec
		  
		   
		   // making in format of HH:MM:SS
		   if(hours<10) {
			   h =String.valueOf(hours);
			   h="0"+h;
		   }
		   else {
			    h=String.valueOf(hours);
		   }
		   
		   
		   if(minutes<10) {
			   m=String.valueOf(minutes);
			   m="0"+m;
		   }
		   else {
			   m=String.valueOf(minutes);
		   }
		   
		   
		   
		   
		   if(s.length()<2) {
			   s="0"+s;
		   }
		   
		   p_time =h +":"+m+":"+s;
		
		   return p_time; // returning pending time 

		   }
		   catch (ParseException e) {
			   e.printStackTrace();
		   }
      return null;
	 }
	 
	 
	
	
	
	 
	 
	 // Geting all data were pending time is less than user provided pending time, return as new varibale of data table
	 private List<data_table> data_before_time(List<data_table>  data, String beforeT, String status){   // beforeT is user provided time
		 LocalTime start,stop;
		 List <data_table> str = new ArrayList<data_table>();
		
		 start = LocalTime.parse( beforeT );
		 System.out.println(start);
		 
		 
		 for (int i=0;i<data.size();i++) {
			 //System.err.println(data.get(i).getPENDING_TIME());
			 stop = LocalTime.parse( data.get(i).getPENDING_TIME());
			   int duration = stop.compareTo(start);  // comparing user provided time to pending time
			  // System.out.println(duration);
			   
			   
			   String st =data.get(i).getSTATUS();    //GETING STATUS OF EVERY USER
			
			  // System.out.println(st);
			   if (duration<=0  && st.equals(status) ) {       //COMPARING STATUS OF EVRY USER
				 str.add(data.get(i));
			   }
			   else if(duration<=0  && status.equals("ALL")) {
					 str.add(data.get(i));

			   }
		 }
		 
		 return str;
	 }
	 
	 //geting seasion
	  
	 
	 
	 
	 
	 
	 
	 
	 
	
	@GetMapping("/")
	public String showHomePage() {
		return "HomePage";
	}

	
    @GetMapping("/index")
    public String getAlldata(HttpServletRequest request,Model model)
    {
    	 
    	 List <data_table> utr = new ArrayList<data_table>();
    	 List <data_table> str = new ArrayList<data_table>();

    	 utr=Service.getAlldata();
			System.out.println(systimes);

    	 for (int i=0;i<utr.size();i++) {
 			String Time =utr.get(i).getLAST_MOD_TIME();
 			String p_time =	GetTimeDiff(Time);
 			utr.get(i).setPENDING_TIME(p_time);
 			utr.get(i).setSelect("false");
 		//System.out.println(utr.get(i));
 		}
    	 
    	   String Time = request.getParameter("usertime"); // GETING TIME FROM THE USER
    	   String status =request.getParameter("status");  // GETING STATUS FROM THE USER
    	   str=data_before_time(utr,Time,status);
    	      
    	 model.addAttribute("str",str);
    	
    	        
    	     
    	     
    	 return "index";
    }
    
    
    @PostMapping("/file")
    public String getFiledetail(@RequestParam(value="myArray[]") String[] myArray) {
    	
    
    	List Utrno=Arrays.asList(myArray);
    	List<String> utno = (List<String>) Utrno.stream().distinct().collect(Collectors.toList());
    	

    	for(int i=0;i<utno.size();i++) {
    		System.out.println(utno.get(i));
    	}
    	for(int i=0;i<utno.size();i++) {
    	try {
            sshcon sshco = new sshcon();
            
            sshcon sshco2 = new sshcon();
          
            
            
          String command1="cd /NEFT/dist3_night/spool/upload-ftp-sent/20220428/apex-ApexBank-apex/neft_n02_inward; grep -l "+ utno.get(i) +" * ";
           String file_name =  sshco.getSession(command1);
          
          System.out.println(file_name.trim());
          
       
          String command2="cd /NEFT/dist3_night/spool/upload-ftp-sent/20220428/apex-ApexBank-apex/neft_n02_inward; curl -T "
          		+ file_name.trim()
          		+ " -u fnsonlo2:fnsonlo2 ftp://10.0.6.12/";
          String file=  sshco2.getSession(command2);
          System.out.println(file);            
        } catch (Exception e) {
        }
    	}
    	
    	
    	
    	return "file";
    }

}