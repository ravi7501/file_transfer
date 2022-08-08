package neft.file.management;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class sshcon {
	   JSch jsch = new JSch();
      

	    Session session;
	    Channel channel;
	    
	   
	    
	 //  public  String Host,Username,Pasword;
	  
	 public Session openSession() throws Exception {

	        if (null == session) {
	            session = jsch.getSession("neft", "10.0.6.11",
	                    22);

	            System.out.println("**************************************"
	                    + session.isConnected());

	           

	            session.setPassword("neft@123");
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.connect(1000 * 1000);

	        }
	        return session;
	    }

	    public Channel openChannel_exe(Session session) throws Exception {

	        if (null == channel) {
	            channel = session.openChannel("exec");
	        }

	        return channel;
	    }
	    
	    
	   
	    
	    

	    public String getSession(String command1) throws Exception {

	        try {

	            session = openSession();
	            channel = openChannel_exe(session);
	          

	       
	            ((ChannelExec) channel).setCommand(command1);
	            channel.setInputStream(null);
	            ((ChannelExec) channel).setErrStream(System.err);

	            InputStream in = channel.getInputStream();
	            
	            channel.connect();
	            byte[] tmp = new byte[1024*10];
	            String readText = "";
	            while (true) {
	                while (in.available() > 0) {
	                    int i = in.read(tmp, 0, 10*1024);
	                    if (i < 0)
	                        break;
	                    readText = new String(tmp, 0, i);
	                    
	                    

	                 
	                    return readText;
	                }
	                if (channel.isClosed()) {
	                    System.out.println("exit-status: "
	                            + channel.getExitStatus());
	                    break;
	                }
	                try {
	                    Thread.sleep(1000);
	                } catch (Exception ee) {
	                }
	            }
	            channel.disconnect();
	          
	            
	            // session.disconnect();
	            System.out.println("DONE");

	        } catch (Throwable t) {
	            System.out.println(t);
	        }
	        return null;

	    }
	 
	 
}
