package com.channelit.empManager.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/*
 * This class is responsible for initiating required Config settings to obtain SSH Connection
 * */
@Configuration
@PropertySource (value = {"classpath:application.properties"})
public class SSHConfiguration 
{

	private static final Logger logger = Logger.getLogger(SSHConfiguration.class);
	
	@Autowired
	private Environment environment;

	
	private String SFTPHOST ;
	private int SFTPPORT ;
	private String SFTPUSER;
	private String SFTPPASS ;
	private String SFTPWORKINGDIR;
	
//	String SFTPHOST = "192.168.1.39";
//    int SFTPPORT = 22;
//    String SFTPUSER = "root";
//    String SFTPPASS = "root";
//    String SFTPWORKINGDIR = "/home/";
    
	private Session session = null;
    private Channel channel = null;
    private ChannelSftp channelSftp = null;
    private JSch jsch ;
    
    
    private void readSShConfigProperties()
	{
    	SFTPHOST = environment.getRequiredProperty("jsch.host");
    	SFTPPORT = Integer.valueOf(environment.getRequiredProperty("jsch.port"));
    	SFTPUSER = environment.getRequiredProperty("jsch.sftpUser");
    	SFTPPASS = environment.getRequiredProperty("jsch.sftpPass");
    	SFTPWORKINGDIR = environment.getRequiredProperty("jsch.sftpWorkingDir");
	}
    
    @Bean
	public ChannelSftp sSHChannelSFTP()
	{
    	readSShConfigProperties();
		 
         try {
        	 if(jsch != null && session != null && session.isConnected()
        			 && channelSftp != null && channelSftp.isConnected())
        		 return channelSftp;
        	 else
        	 {
	        	 jsch = new JSch();
	        	 session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
	        	 session.setPassword(SFTPPASS);
		         java.util.Properties config = new java.util.Properties();
		         config.put("StrictHostKeyChecking", "no");
		         session.setConfig(config);
		         session.connect();
		         channel = session.openChannel("sftp");
		         channel.connect();
		         System.out.println("Session and Channel Connected " + channel.isConnected());
		         channelSftp = (ChannelSftp) channel;
		         channelSftp.cd(SFTPWORKINGDIR);
        	 }
	         
		}catch(SftpException e)
         {
			e.printStackTrace();
			logger.error(e);
         } 
         catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
         return channelSftp;
	}
    
    public static void main (String [] args)
    {
    	SSHConfiguration config = new SSHConfiguration();
    	System.out.println("Connection is "+ config.sSHChannelSFTP().isConnected());
    }
}
