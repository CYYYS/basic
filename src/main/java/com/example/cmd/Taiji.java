package com.example.cmd;


import java.net.InetAddress;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@ConfigurationProperties(prefix="taiji")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taiji {
	private String name;
	private String location;
	private InetAddress remote;
	private List list;
	@Override
	public String toString() {
		return "Taiji [name=" + name + ", location=" + location + ", remote=" + remote + ", list=" + list + "]";
	}
	
	
}
