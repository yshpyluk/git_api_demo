package com.example.tools;

import org.flywaydb.core.Flyway;

/**
 * Created by yshpyluk on 5/23/17.
 */
public class Migration {

	public static void main(String[] args) {
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:mysql://192.168.99.100:32770/test", "root", "password1");
		flyway.migrate();
	}
}
