package com.music.app.inter;

/**
 * Created by Badri on 03/05/16.
 */
public interface ResponseListener<RESULT> {

    void onSuccess(RESULT response);

    void onFailure(Throwable throwable, String errorResponse);

}
