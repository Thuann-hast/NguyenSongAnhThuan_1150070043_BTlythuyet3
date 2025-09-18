package com.example.btlt3nsat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // Thêm dữ liệu mẫu
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Lấy dữ liệu
        List<Contact> contacts = db.getAllContacts();
        List<String> contactNames = new ArrayList<>();
        for (Contact c : contacts) {
            contactNames.add(c.getName() + " - " + c.getPhoneNumber());
        }

        // Hiển thị trên ListView
        ListView listView = findViewById(R.id.listViewContacts);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactNames
        );
        listView.setAdapter(adapter);

        db.close();
    }
}
