package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enu.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		System.out.println("Enter Worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
		System.out.print("How many contracts to this workers? ");
		int quantityContract = sc.nextInt();
		for(int i = 1; i <= quantityContract; i++) {		    
			System.out.println("Enter contract #" + i + " data:" );
			System.out.print("Date (dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration: ");
			Integer hours = sc.nextInt();			
			worker.addContract(new HourContract(date, valuePerHour, hours));			
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String date1 = sc.next();		
		Integer month = Integer.parseInt(date1.substring(0,2));
		Integer year = Integer.parseInt(date1.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + date1 + ": " + String.format("%.2f%n", worker.income(year, month)) );
		
		
		
		
		
		sc.close();
	}

}
