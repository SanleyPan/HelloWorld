package com.thoughtworks.andoridtrain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    static final int PICK_CONTACT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openConstraintActivity();
        openContact();

    }

    private void openContact() {
        button = (Button) findViewById(R.id.pick_contact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(  new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"))
                                .addCategory(Intent.CATEGORY_DEFAULT)
                                .setType("vnd.android.cursor.dir/phone_v2"),
                        PICK_CONTACT_REQUEST);
            }
        });

    }

    private void openConstraintActivity() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, ConstraintActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST && resultCode == RESULT_OK) {
            Cursor cursor = getContentResolver().query(data.getData(), new String[]{"display_name", "data1"}, null, null, null);
            cursor.moveToNext();
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNum = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            cursor.close();
            Toast.makeText(this, contactName + " " + phoneNum, Toast.LENGTH_SHORT).show();
        }

    }
}