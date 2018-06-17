package com.example.pbo.jagasehat;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by M FaizinAhsan on 6/10/2018.
 */
//Data FormDemografi
public class User {
    public String key;
    public String nama;
    public String usia;
    public String jk;
    public String pendidikan;
    public String pekerjaan;
    public String email;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String key,String username,String usia,String jk,String pendidikan,String
            pekerjaan, String
            email) {
        this.key = key;
        this.nama = username;
        this.usia = usia;
        this.jk = jk;
        this.pendidikan = pendidikan;
        this.pekerjaan = pekerjaan;
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public String getNama() {
        return nama;
    }

    public String getUsia() {
        return usia;
    }

    public String getJk() {
        return jk;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getEmail() {
        return email;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        result.put("usia", usia);
        result.put("jk", jk);
        result.put("pendidikan", pendidikan);
        result.put("pekerjaan", pekerjaan);
        result.put("email", email);

        return result;
    }


}
