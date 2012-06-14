package com.tightdb.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;

import com.tightdb.generated.*;

import com.tightdb.lib.AbstractColumn;
import com.tightdb.lib.Table;
import com.tightdb.lib.TightDB;

import com.tightdb.Group;
import com.tightdb.TableBase;

public class TightdbJni extends Activity
{
	@Table
	class employee {	
		String firstName;
		String lastName;
		int salary;
		boolean driver;
		byte[] photo;
		Date birthdate;
		Object extra;
		phone phones;
	}

	@Table
	class phone {
		String type;
		String number;
	}		

    public void onCreate(Bundle savedInstanceState)
    {
    	EmployeeTable employees = new EmployeeTable();
		Employee john = employees.add("John", "Doe", 10000, true, new byte[] { 1, 2, 3 }, new Date(), "extra");
		Employee Thomas = employees.add("Thomas", "Andersen", 20000, false, new byte[] { 1, 2, 7 }, new Date(), "extra");

		super.onCreate(savedInstanceState);

		System.out.println("first record: " + john);		
		for (Employee employee : employees) {
			System.out.println("iterating: " + employee);
		}

        TextView  tv1 = new TextView(this);
        tv1.setText( john.lastName.get() );
        setContentView(tv1);
    }
}
