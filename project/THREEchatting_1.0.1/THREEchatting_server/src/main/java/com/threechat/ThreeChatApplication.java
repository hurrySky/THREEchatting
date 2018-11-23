package com.threechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot启动入口
 * @author Lixin
 *
 */
@SpringBootApplication
public class ThreeChatApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ThreeChatApplication.class, args);
		 System.out.println(
				 		 "      ___________.__                           _________ .__            __    __  .__                          			\n" +
						 "      \\__    ___/|  |_________   ____   ____   \\_   ___ \\|  |__ _____ _/  |__/  |_|__| ____    ____            		\n" +
						 "        |    |   |  |  \\_  __ \\_/ __ \\_/ __ \\  /    \\  \\/|  |  \\\\__  \\\\   __\\   __\\  |/    \\  / ___\\        \n" +
						 "        |    |   |   Y  \\  | \\/\\  ___/\\  ___/  \\     \\___|   Y  \\/ __ \\|  |  |  | |  |   |  \\/ /_/  >            \n" +
						 "        |____|   |___|  /__|    \\___  >\\___  >  \\______  /___|  (____  /__|  |__| |__|___|  /\\___  /                  \n" +
						 "                      \\/            \\/     \\/          \\/     \\/     \\/                   \\//_____/                ");
	}
}
