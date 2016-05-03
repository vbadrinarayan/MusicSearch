package com.music.app.utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import retrofit.mime.TypedInput;

/**
 * CustomizedTypedInput.
 */
public class CustomizedTypedInput implements TypedInput {
    private final byte[] mStringBytes;

    CustomizedTypedInput(byte[] stringBytes) {
        this.mStringBytes = stringBytes;
    }


    @Override
    public String mimeType() {
        return "application/json; charset=UTF-8";
    }



    @Override
    public long length() {
        return mStringBytes.length;
    }

    @Override
    public InputStream in() throws IOException {
        return new ByteArrayInputStream(mStringBytes);
    }
}
