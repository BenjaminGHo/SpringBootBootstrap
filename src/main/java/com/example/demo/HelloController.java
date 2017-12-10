package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	
    @RequestMapping("/Katie")
    public String index() {
        return "Greetings from Spring Boot!!!!";
    }
    
    @RequestMapping("/NBA")
    public Game game() {
        
    	Game game = new Game();
    	game.name = "Celtics";
    	
		try {
			URL url = new URL("https://safe-tor-26723.herokuapp.com/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// By default it is GET request
			con.setRequestMethod("GET");

			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			
			int responseCode = con.getResponseCode();
			System.out.println("Sending get request : " + url);
			System.out.println("Response code : " + responseCode);

			// Reading response from input Stream
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String output;
			StringBuffer response = new StringBuffer();

			while ((output = in.readLine()) != null) {
				response.append(output);
			}
			in.close();

			// printing result from response
			game.name = response.toString();
			//System.out.println(response.toString());

			// return game;

			// return "Greetings from Spring Boot!!!!";
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return game;

    }
}