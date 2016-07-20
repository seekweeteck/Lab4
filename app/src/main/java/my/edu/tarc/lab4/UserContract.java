package my.edu.tarc.lab4;

import android.provider.BaseColumns;

/**
 * Created by Student on 7/20/2016.
 */
public final class UserContract {
    public UserContract(){}

    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME ="user";
        public static final String COLUMN_NAME ="name";
        public static final String COLUMN_EMAIL ="email";
    }
}
