package com.threechat;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





import org.springframework.stereotype.Service;

import com.threechat.base.controller.ReponseControlService;
import com.threechat.base.mapper.UserMapper;

/**
 * springboot启动入口
 * @author Lixin
 *
 */
@SpringBootApplication
@MapperScan("com.threechat.base.mapper")
//@ComponentScan(basePackages = {"com.threechat.base"})
public class ThreeChatApplication implements CommandLineRunner {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ReponseControlService reponseControlService;
	
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

	@Override
	public void run(String... arg0) throws Exception {
		
		reponseControlService.serverStart(); // 服務啟動
		//System.out.println(this.userMapper.findUser("xiaoming"));
		//reponseControlService.printUser();
	}
}
