package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class UpdateUserController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email which u wish to update");
		String email = sc.next();
		System.out.println("Enter the first name");
		String fname = sc.next();
		System.out.println("Enter the last name");
		String lname = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		System.out.println("Enter the phone");
		long phone = sc.nextLong();
		System.out.println("Enter the dob");
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
		User u1 = ud.updateDetails(u);
		System.out.println(u1);
	}
}
