package ru.five_dots.kotlin_boilerplate.util;

/**
 * Created by aleksejskrobot on 08.09.16.
 */

public final class Constants {

    public static final String PREF_FILE_NAME = "preferences";
    public static final String EMPTY = "empty";
    public static final String USER = "user";
    public static final String EMPTY_STRING = "";
    public static final String EMPTY_ARRAY = "[]";
    public static final String SUCCESS = "success";
    public static final String APPLICATION_JSON = "application/json";
    public static final String SUBSCRIPTION = "subscription";

    public static final class COOKIES {
        public static final String CSRF_TOKEN = "csrftoken";
        public static final String SESSION_ID = "sessionid";
        public static final String DS_USER = "ds_user";
        public static final String MID = "mid";
        public static final String DS_USER_ID = "ds_user_id";
    }

    public static class HEADERS {
        public static final String TOKEN = "Auth-Token";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";
        public static final String USER_AGENT = "User-Agent";
        public static final String USER_AGENT_VALUE = "Instagram 8.5.1 Android (18/4.3; 320dpi; 720x1280; Xiaomi; HM 1SW; armani; qcom; en_US)";
    }

    public static class INSTAGRAM {
        public static final String SECRET_KEY = "b5d839444818714bdab3e288e6da9b515f85b000b6e6b452552bfd399cb56cf0";
        public static final int SECRET_KEY_VERSION = 4;
        public static final int LOGIN_ATTEMPT_COUNT = 0;
        public static final String CSRF_TOKEN = "missing";
        public static final String ALGORITHM = "HmacSHA256";

    }

    public static class API {
        public static final String URL = "http://www.anapioficeandfire.com/";
        public static final String TYPE = "url_type";
    }

    public class BUNDLE {

    }

    public static class ACCOUNT {
        public static final String SING_IN = "Sign In";
        public static final String CONNECTED = "Connected";
    }
    public static class ERRORS {
        public static final String INSTAGRAM_AUTH = "Username or password is incorrect. ";
    }
}
