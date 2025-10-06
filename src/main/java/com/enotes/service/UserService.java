package com.enotes.service;

import com.enotes.dto.PasswordChngRequest;
import com.enotes.dto.PswdResetRequest;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

	public void changePassword(PasswordChngRequest passwordRequest);

	public void sendEmailPasswordReset(String email, HttpServletRequest request) throws Exception;

	public void verifyPswdResetLink(Integer uid, String code) throws Exception;

	public void resetPassword(PswdResetRequest pswdResetRequest) throws Exception;

}
