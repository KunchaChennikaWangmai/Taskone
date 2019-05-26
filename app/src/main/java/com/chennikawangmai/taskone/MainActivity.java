package com.chennikawangmai.taskone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText n1;
    private Button gue;
    private TextView te;
    public static final String EXTRA_NUM ="com.chennikawangmai.Task1.EXTRA_NUM";

    public boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        te = (TextView) findViewById(R.id.t);
        n1 = (EditText) findViewById(R.id.we);
        gue = (Button) findViewById(R.id.button);
        gue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2Activity();
            }
        });
    }
    public void openMain2Activity() {
        Intent intent=new Intent(this, Main2Activity.class);
        EditText n2=(EditText)findViewById(R.id.we);
        boolean b=isEmpty(n1);
        if(b) {
            int n3 = Integer.parseInt(n2.getText().toString());
            if (n3 > 0 && n3 < 101) {
                intent.putExtra(EXTRA_NUM, n3);
                n2.setText("");
                startActivity(intent);
            } else {
                te.setText("Enter a number  less than 100");
            }
        }
        else
        {te.setText("Enter a number");}

    }

}
