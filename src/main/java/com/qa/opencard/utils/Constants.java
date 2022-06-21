package com.qa.opencard.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final int DEFAULT_TIME_OUT = 5;
	public static final String AccountPage_Title = "﻿​​My Account";
	public static final String ACCOUNT_PAGE_HEADERS = "";
	public static final int IMAC_IMAGE_COUNT = 3;
	public static final String REGISTER_SUCC_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "CreateUsers";
	
	
	
	public static List<String> getExpectedAccSecList() {
		List<String> acc=new ArrayList<>();
		acc.add("My Account");
		acc.add("My Orders");
		acc.add("My Affiliate Account");
		acc.add("Newsletter");
		return acc;
	}
	
}
