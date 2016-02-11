package rms.makowaredev.com.rms.API;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Objects;

import rms.makowaredev.com.rms.R;

public class API {
    private static final String BASE_URL  = "http://rms.makowaredev.com:8080";
    private static final String TAG = "API";
    private static API ourInstance = new API();
    private RequestQueue requestQueue;
    private static Context ctx;

    public static API getInstance() {return ourInstance;}

    private API() {
    }

    public static JsonObjectRequest getUsers() {
        String url = BASE_URL + "/users";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, (String) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v(TAG, error.getLocalizedMessage());
                        Log.v(TAG, error.getMessage());
                    }
                });

        return  jsObjRequest;
    }

    public RequestQueue getRequestQueue(Context ctx) {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }
}
