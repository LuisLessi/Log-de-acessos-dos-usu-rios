package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.User;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path:");
		String patch = sc.nextLine();
		Set<User> set = new HashSet<>();

		BufferedReader br = null;
		String linha = "";
		String csvDivisor = " ";
		try {

			br = new BufferedReader(new FileReader(patch));
			while ((linha = br.readLine()) != null) {

				String[] user = linha.split(csvDivisor);
				String username = user[0];
				
				Date moment = Date.from(Instant.parse(user[1]));
				
				set.add(new User(username, moment));
				
				linha = br.readLine();
				
			}
			System.out.println("Total users: " + set.size());


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		sc.close();
	}

}
