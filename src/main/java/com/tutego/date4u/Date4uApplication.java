package com.tutego.date4u;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.service.FileSystem;

@SpringBootApplication
public class Date4uApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(Date4uApplication.class);


	public static void main(String[] args) {

		logger.info( "Log mit Argumenten {}, {}, {}", 1, "2", 3.0 );

		ApplicationContext ctx =
			SpringApplication.run(Date4uApplication.class, args);
		FileSystem fs = ctx.getBean( FileSystem.class );
		System.out.println(
			DataSize.ofBytes( fs.getFreeDiskSpace() ).toGigabytes() + " GB"
		);
	}
}