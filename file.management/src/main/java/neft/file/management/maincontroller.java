package neft.file.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import neft.file.management.entity.data_table;
import neft.file.management.entity.rtgsTable;

import com.jcraft.jsch.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;




@Controller
public class maincontroller  {
	@Autowired
	service Service;
    

	
    @GetMapping("/index")
    public String getAlldata(HttpServletRequest request,Model model)
    {
    	 List <data_table> utr = new ArrayList<data_table>(); // this line will import neft_table 
    	 utr=Service.getAlldata();
    	 
    	 List<Map<String, Integer>> neftout= new ArrayList<>();// this line will take all status count of neft_out_going
 		 neftout=Service.neft_out_ward("RSCB0000%");
 		 
 		 List<Map<String, Integer>> neftIn= new ArrayList<>();// this line will take all status count of neft_Incoming
 		 neftIn=Service.neft_In_ward();
		 
 		
    	 List <rtgsTable>   rtgs = new ArrayList<rtgsTable>();// this line will import rtgs_table
    	 rtgs=Service.getrtgsTable();
    	 
 		
 		 List<Map<String, Integer>> rtgsout= new ArrayList<>();// this line will take all status count of rtgs_out_going
 		 rtgsout=Service.rtgs_out_ward();
 		 

 		 List<Map<String, Integer>> rtgsin= new ArrayList<>();// this line will take all status count of rtgs_Incoming
 		 rtgsin=Service.rtgs_In_ward();
 		 
 		 
    	 model.addAttribute("neftout",neftout);

 		 
 		 



    	 
    	 
    	 
    	 

    	 
    	 for(int i =0;i<neftout.size();i++) {
    		 System.out.println(neftout.get(i).entrySet());//to get status of all data
    	 }
    	 System.out.println("Line Change");

    	 for(int i =0;i<rtgsin.size();i++) {
    		 System.out.println(rtgsin.get(i).entrySet());//to get status of all data
    	 }

    	 System.out.println("Line Change");
    	 
    	 for(int i =0;i<neftIn.size();i++) {
    		 System.out.println(neftIn.get(i).entrySet());//to get status of all data
    	 }
    	
    	 System.out.println("Line Change");

    	 for(int i =0;i<rtgsout.size();i++) {
    		 System.out.println(rtgsout.get(i).entrySet());//to get status of all data
    	 }
    	     
    	 return "index";
    }
    
    
    
    @PostMapping("/index")
    public String PostData(@RequestParam(value="string") String b_code,Model model) {
    	System.out.println(b_code);
    	
    	List<Map<String, Integer>> neftout= new ArrayList<>();// this line will take all status count of neft_out_going
		 neftout=Service.neft_out_ward(b_code);
    	 model.addAttribute("neftout",neftout);

    	return "index";
    }
    
    
    
}