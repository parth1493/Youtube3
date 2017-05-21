package hello.example.com.youtube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    String[] languages={"Android ","java","IOS","SQL","JDBC","Web services,HGG,hGD,Rt,HGu,HGJ"};
    AutoCompleteTextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ArrayList<String> arrayOfUsers = new ArrayList<String>();
       arrayOfUsers.add("java");
        arrayOfUsers.add("c++");
        arrayOfUsers.add("javaqds");
        arrayOfUsers.add("javaasdfas");

        text=(AutoCompleteTextView)findViewById(R.id.autoText);
        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);

        text.setAdapter(adapter);
        text.setThreshold(1);

    }
}
