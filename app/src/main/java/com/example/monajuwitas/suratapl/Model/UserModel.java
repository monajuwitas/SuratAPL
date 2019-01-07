package com.example.monajuwitas.suratapl.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    String nip, nama, alamat, nohp, email, jabatan;


    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nip);
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeString(this.nohp);
        dest.writeString(this.email);
        dest.writeString(this.jabatan);
    }

    public UserModel() {
    }

    protected UserModel(Parcel in) {
        this.nip = in.readString();
        this.nama = in.readString();
        this.alamat = in.readString();
        this.nohp = in.readString();
        this.email = in.readString();
        this.jabatan = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
