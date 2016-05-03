package com.music.app.servicemanager.volleyrequest;

import android.app.Application;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.music.app.inter.ResponseListener;
import com.music.app.main.application.MusicApplication;
import com.music.app.main.exception.AppException;
import com.music.app.model.ResponseMessage;
import com.music.app.model.UISearchResultList;
import com.music.app.utility.Constants;

import org.json.JSONObject;

/**
 * Manager.
 */
public class Manager {

    private static final String TAG = Manager.class.getSimpleName();

    public static void getSearchResults(final Application context, final String searchText
            , final ResponseListener<UISearchResultList> listener) {

        final String targetUrl = String.format(Constants.URL_MUSIC_SEARCH);
        Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                if (response != null && !"null".equalsIgnoreCase(response.toString().trim())) {
                    try {
                        Log.i(TAG, "Response:::" + response.toString());
                        UISearchResultList results = new Gson().fromJson(
                                response.toString(), UISearchResultList.class);

                    }catch(NullPointerException|com.google.gson.JsonSyntaxException exception){
                        // Exception handling
                    }
                } else{
                    ResponseMessage message = new ResponseMessage();
                    message.setMessage(targetUrl);
                    message.setStatus(Constants.ERROR_SERVER);
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = getMessage(error);
                AppException exception = new AppException(error);
                listener.onFailure(exception, message);

            }
        };

        JsonObjectRequest objectRequest = new JsonObjectRequest(targetUrl
                , null, successListener, errorListener);
        objectRequest.setRetryPolicy(new DefaultRetryPolicy
                (Constants.RETRY_POLICY, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MusicApplication app = (MusicApplication) context;
        app.addToRequestQueue(objectRequest, Constants.SEARCH_TAG);
    }

    /**
     * Determines whether the error is related to network
     *
     * @param error
     * @return
     */
    private static boolean isNetworkProblem(Object error) {
        return (error instanceof NetworkError);
    }

    /**
     * Determines whether the error is related to server
     *
     * @param error
     * @return
     */
    private static boolean isServerProblem(Object error) {
        return (error instanceof ServerError) || (error instanceof AuthFailureError)
                || (error instanceof NoConnectionError);
    }


    private static String getMessage(Object error) {
        if (error instanceof TimeoutError) {
            return Constants.ERROR_SERVER_DOWN;
        } else if (isServerProblem(error)) {
            return Constants.ERROR_SERVER;
        } else if (isNetworkProblem(error)) {
            return Constants.ERROR_INTERNET_UNAVAILABLE;
        }
        return Constants.ERROR_SERVICE_FAILED;
    }

}
