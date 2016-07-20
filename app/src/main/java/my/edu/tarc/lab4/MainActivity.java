package my.edu.tarc.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    ListView listViewRecords;
    UserDataSource datasource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewRecords = (ListView)findViewById(R.id.listViewRecords);
        listViewRecords.setOnItemSelectedListener(this);
    }

    public void addRecord(View v){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        updateList();
        super.onResume();
    }

    private void updateList() {
        //Retrieve records from SQLite
        datasource = new UserDataSource(this);
        datasource.open();
        final List<UserRecord> values = datasource.getAllUsers();

        UserRecordAdapter adapter = new UserRecordAdapter(this, R.layout.user_record, values);

        //Link adapter to ListView
        listViewRecords.setAdapter(adapter);
    }

    protected void onPause(){
        datasource.close();
        super.onPause();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
