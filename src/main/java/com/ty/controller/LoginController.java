package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class LoginController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		UserDAO ud = new UserDAO();
		User u = ud.getUserByEmailAndPassword(email, password);
		if(u!=null)
		{
			System.out.println("welcome"+u.getFirstName());
		}
		else
		{
			System.out.println("invalid username / password");
		}
	}
}