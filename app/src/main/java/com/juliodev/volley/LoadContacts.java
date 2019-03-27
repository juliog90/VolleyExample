package com.juliodev.volley;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LoadContacts extends AsyncTask<String, Void, ArrayList<Contact>> {

    private static final String API_URL = "http://pratikbutani.x10.mx/json_data.json";
    private static final String KEY_CONTACTS = "contacts";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_IMAGE = "profile_pic";

    private static final String TAG = MainActivity.class.getSimpleName();

    private Activity activity;
    private ProgressDialog progress;

    public LoadContacts(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected void onPreExecute() {
        progress = new ProgressDialog(this.activity);
        progress.setMessage("Loading...");
        progress.setIndeterminate(false);
        progress.setCancelable(false);
        progress.show();
    }

    ArrayList<Contact> contacts;

    @Override
    protected ArrayList<Contact> doInBackground(String... strings) {

        // lista de contactos vacia
        contacts = new ArrayList<>();

        // Peticion de tipo json usando volley
        JsonObjectRequest getContacts = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray(KEY_CONTACTS);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject json = jsonArray.getJSONObject(i);
                        Contact contact = new Contact();
                        contact.setName(json.getString(KEY_NAME));
                        contact.setGender(json.getString(KEY_GENDER));
                        contact.setImage(json.getString(KEY_IMAGE));
                        contact.setEmail(json.getString(KEY_EMAIL));

                        contacts.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error en peticion", error.getMessage());
            }
        });
        // creamos cola de peticiones de volley
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        // agregamos la peticion que saca la informacion de los contactos
        // a la cola antes mencionada
        requestQueue.add(getContacts);

        // regresamos los contactos
        return contacts;
    }

    @Override
    protected void onPostExecute(ArrayList<Contact> contacts) {
        ListView ListContacts = this.activity.findViewById(R.id.listViewContacts);
        ContactAdapter adapter = new ContactAdapter(this.activity, contacts);
        ListContacts.setAdapter(adapter);
        progress.dismiss();
    }
}
