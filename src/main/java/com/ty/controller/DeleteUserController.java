package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;

public class DeleteUserController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email of the user to be deleted");
		String email = sc.next();
		UserDAO ud = new UserDAO();
		String du =  ud.deleteDetails(email);
		System.out.println(du);
	}

}
