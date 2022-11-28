package com.example.lab2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editID,editFullName;
    Button btnAdd;
    CheckBox checkboxIsManager;
    ListView lvEmployee;
    ArrayList<Employee>arrEmployee=new ArrayList<Employee>();
    EmployeeAdapter adapter=null;
    Employee employee=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editID=(EditText) findViewById(R.id.editID);
        editFullName=(EditText) findViewById(R.id.editFullName);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        checkboxIsManager=(CheckBox) findViewById(R.id.checkbox_IsManager);
        lvEmployee=(ListView) findViewById(R.id.lvEmployee);
        adapter=new EmployeeAdapter(this,
                R.layout.item_employee,
                arrEmployee);
        lvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                processNhap();
            }
        });
    }

    public void processNhap()
    {
        employee = new Employee();
        String id=editID.getText()+"";
        String name=editFullName.getText()+"";
        boolean position;

        if(checkboxIsManager.isChecked()){
            position=true;
        }
        else {
            position=false;
        }

        employee.setID(id);
        employee.setFullName(name);
        employee.setPosition(position);
        arrEmployee.add(employee);
        adapter.notifyDataSetChanged();

        editID.setText("");
        editFullName.setText("");
        editID.requestFocus();
    }
}