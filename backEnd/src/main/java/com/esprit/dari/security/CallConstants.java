package com.esprit.dari.security;

import com.twilio.Twilio;

public class CallConstants {
    public final static String SID_ACCOUNT = "ACf66bc3a0d82b4d663553494773220c30";
    public final static String AUTH_ID = "e6914fdf4c71b107861333924837fdca";
    public final static String FROM_NUMBER="+16173792102";
    public final static String TO_NUMBER ="+21650713446";

    static {
        Twilio.init(SID_ACCOUNT, AUTH_ID);
    }

}
