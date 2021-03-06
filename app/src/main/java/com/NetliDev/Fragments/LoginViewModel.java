package com.NetliDev.Fragments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    final MutableLiveData<AuthenticationState> authenticationState = new MutableLiveData<>();
    String username;

    public LoginViewModel() {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
        username = "";
    }

    public enum AuthenticationState {
//        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }


    public void authenticate(String username, String password) {
        if (passwordIsValidForUsername(username, password)) {
            this.username = username;
            authenticationState.setValue(AuthenticationState.AUTHENTICATED);
        } else {
            authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
        }
    }

    public void refuseAuthentication() {
        authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
    }

    private boolean passwordIsValidForUsername(String username, String password) {
        return password != null && password.trim().length() > 5;
    }

}