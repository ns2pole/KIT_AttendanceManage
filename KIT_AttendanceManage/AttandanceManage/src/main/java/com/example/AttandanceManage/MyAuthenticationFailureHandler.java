package com.example.AttandanceManage;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        AuthenticationException authenticationException)
        throws IOException {
            String errorId = "";
            if(authenticationException instanceof BadCredentialsException){
            errorId = "おかしなエラー";
        }
        // ログイン画面にリダイレクトする
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/"
                + httpServletRequest.getParameter("identifier") + "/index?error=" + errorId);
    }
}