package my.edu.tarc.lab4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Student on 7/20/2016.
 */
public class UserRecordAdapter extends ArrayAdapter<UserRecord> {
    //private final List<UserRecord> list;
    //private final Activity context;
    //private final int layout;

    public UserRecordAdapter(Activity context, int resource, List<UserRecord> list) {
        super(context, resource, list);
      //  this.list = list;
        //this.context = context;
        //this.layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserRecord userRecord = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_record, parent, false);
        }

        TextView textViewName, textViewEmail;

        textViewName = (TextView)convertView.findViewById(R.id.textViewName);
        textViewEmail = (TextView)convertView.findViewById(R.id.textViewEmail);


        textViewName.setText("Name:"+userRecord.getName());
        textViewEmail.setText("Email:" + userRecord.getEmail());

        return convertView;
    }
}
