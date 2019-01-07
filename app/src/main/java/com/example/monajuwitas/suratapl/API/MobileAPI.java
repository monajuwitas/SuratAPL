package com.example.monajuwitas.suratapl.API;

import com.example.monajuwitas.suratapl.Response.EofficeResponse;
import com.example.monajuwitas.suratapl.Response.HomeAsistenResponse;
import com.example.monajuwitas.suratapl.Response.HomeEselonResponse;
import com.example.monajuwitas.suratapl.Response.HomeGubernurResponse;
import com.example.monajuwitas.suratapl.Response.HomeSekdaResponse;
import com.example.monajuwitas.suratapl.Response.LoginResponse;
import com.example.monajuwitas.suratapl.Response.NDResponse;
import com.example.monajuwitas.suratapl.Response.SPTResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MobileAPI {
    @Headers({
            "Content-Type:application/x-www-form-urlencoded"
    })

//login
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse>  login (@Field("nip") String nip,
                                @Field("password") String password);
//home
    @GET("homeeselon.php")
    Call<HomeEselonResponse> datahomeeselon();

    @GET("homeasisten.php")
    Call<HomeAsistenResponse> datahomeasisten();

    @GET("homesekda.php")
    Call<HomeSekdaResponse> datahomesekda();

    @GET("homegubernur.php")
    Call<HomeGubernurResponse> datahomegub();

//list eoffice
    @GET("listeofficeeselon.php")
    Call<EofficeResponse> listeoffice(@Query("flag") Integer flag);

    @GET("listeofficeeselonacc.php")
    Call<EofficeResponse> listeofficeacc();

    @GET("listeofficeeselondenied.php")
    Call<EofficeResponse> listeofficedenied();

//list nota dinas
    //eseon
    @GET("listndeselon.php")
    Call<NDResponse> listnotadinas();

    @GET("listndeselonacc.php")
    Call<NDResponse> listnotadinasacc();

    @GET("listndeselondenied.php")
    Call<NDResponse> listnotadinasdenied();
    //asisten
    @GET("listndasisten.php")
    Call<NDResponse> listndasistenall();

    @GET("listndasistenriwayat.php")
    Call<NDResponse> listndasistenriwayat();
//list spt
    @GET("listspteselon.php")
    Call<SPTResponse> listspt();

    @GET("listspteselonacc.php")
    Call<SPTResponse> listsptacc();

    @GET("listspteselondenied.php")
    Call<SPTResponse> listsptdenied();
}
