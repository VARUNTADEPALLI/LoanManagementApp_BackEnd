package com.varun.dto;

public class OtpStorageDto {

	private static int otp;

	public static int getOtp() {
		return otp;
	}

	public static void setOtp(int otp) {
		OtpStorageDto.otp = otp;
	}
	
}
