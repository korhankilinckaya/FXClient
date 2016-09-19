package com.fx.client.FXClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  	  try {

  		URL url = new URL("http://localhost:8080/FXRestfulServer/data?type=spot&style");
  		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  		conn.setRequestMethod("GET");
  		conn.setRequestProperty("Accept", "application/json");

  		if (conn.getResponseCode() != 200) {
  			throw new RuntimeException("Failed : HTTP error code : "
  					+ conn.getResponseCode());
  		}

  		BufferedReader br = new BufferedReader(new InputStreamReader(
  			(conn.getInputStream())));

  		String output;
  		while ((output = br.readLine()) != null) {
  			System.out.println(output);
  		}

  		conn.disconnect();

  	  } catch (MalformedURLException e) {

  		e.printStackTrace();

  	  } catch (IOException e) {

  		e.printStackTrace();

  	  }
    }
}
