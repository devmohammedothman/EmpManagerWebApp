package com.channelit.empManager.service.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import com.channelit.empManager.configuration.SSHConfiguration;
import com.jcraft.jsch.ChannelSftp;


@Component
@EnableScheduling
public class LogScheduler {

	private static final Logger logger = Logger.getLogger(LogScheduler.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	@Autowired 
	private ChannelSftp sSHChannelSFTP;
	
	@Scheduled(fixedRate = 500000)
	public void reportCurrentTime()
	{
		logger.info("The Time is Now "+ dateFormat.format(new Date()) + "SFTP Connection Enabled"+sSHChannelSFTP.isConnected());
	}

}
