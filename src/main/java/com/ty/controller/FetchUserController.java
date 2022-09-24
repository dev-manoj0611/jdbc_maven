package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class FetchUserController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email of the user to be fetched");
		String email = sc.next();
		UserDAO ud = new UserDAO();
		User u = ud.getDetails(email);
		System.out.println(u);
	}
}