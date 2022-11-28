package com.example.lab2_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
    EmployeeAdapter employeeAdapter=null;
    EditText editID,editFullName;
    Button btnAdd;
    CheckBox checkboxIsManager;
    Employee employee=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editID=(EditText) findViewById(R.id.editID);
        editFullName=(EditText) findViewById(R.id.editFullName);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        checkboxIsManager=(CheckBox) findViewById(R.id.checkbox_IsManager);

        recyclerView  = (RecyclerView) findViewById(R.id.rv_Employee);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        employeeAdapter = new EmployeeAdapter(getApplicationContext(), arrEmployee);
        recyclerView.setAdapter(employeeAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                processNhap();
            }
        });
    }

    public void processNhap()
    {
        employee = new Employee("", "", false);
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
        employeeAdapter.notifyDataSetChanged();

        editID.setText("");
        editFullName.setText("");
        editID.requestFocus();
    }

}