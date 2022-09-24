package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class AddUserController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name");
		String fname = sc.next();
		System.out.println("Enter the Last Name");
		String lname = sc.next();
		sc.next();
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		System.out.println("Enter the Phone");
		long phone = sc.nextLong();
		System.out.println("Enter the DOB");
		String dob = sc.next();
		System.out.println("Enter the gender");
		String gender = sc.next();
		UserDAO ud = new UserDAO();
		User u = new User();
		u.setFirstName(fname);
		u.setLastName(lname);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		u.setDateOfBirth(dob);
		u.setGender(gender);
		User u1 = ud.saveDetails(u);
		System.out.println(u1);
	}
}
