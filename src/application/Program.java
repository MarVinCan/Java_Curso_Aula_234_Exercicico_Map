package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		Map<String, Integer> votes = new LinkedHashMap<>();
	
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Integer vote = 0;
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String candidate = fields[0];
				if (votes.get(candidate) != null) {
					vote = Integer.parseInt(fields[1]) + votes.get(candidate);
				} else {
					vote = Integer.parseInt(fields[1]);
				}
				votes.put(candidate, vote);
				line = br.readLine();
			}
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
