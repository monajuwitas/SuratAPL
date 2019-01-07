package com.example.monajuwitas.suratapl.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "mobilebanking";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_SAVE_USER_ID = "IsSaveUserID";
    private static final String SAVE_USER_ID = "saveUserID";
    private static final String SAVE_AUTH_ID = "saveAuthID";

    private static final String IS_LOGIN = "isLogin";
    private static final String STATUS_LOGIN = "statusLogin";


//    deklarasikan key
    private static final String NIP = "nip";
    private static final String NAMA = "nama";
    private static final String ROLE = "role";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean isLogin(){
        return  pref.getBoolean(IS_LOGIN, false);
    }

    public void setLogin(boolean statusLogin){
        editor.putBoolean(IS_LOGIN, statusLogin);
        editor.commit();

    }

    public void saveLoginData(String nip, String nama, String role){
        editor.putString(NIP, nip);
        editor.putString(NAMA, nama);
        editor.putString(ROLE, role);
        editor.commit();
    }



    public String getNIP() {
        return pref.getString(NIP, "");
    }

    public String getNAMA() {
        return pref.getString(NAMA, "");
    }

    public String getROLE() {
        return pref.getString(ROLE, "");
    }






}