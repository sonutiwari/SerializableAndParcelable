package in.co.chicmic.serializableandparcelable.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

import in.co.chicmic.serializableandparcelable.R;
import in.co.chicmic.serializableandparcelable.dataModels.Employee;
import in.co.chicmic.serializableandparcelable.utilities.AppConstants;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Intent mParcelableAndSerializableIntent;

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);
        Employee newEmployee = new Employee("Sonu", "CHICMIC206"
                , "sonu.tiwari@gmail.com", "+919056360543");
        Employee secondEmployee = new Employee("Naushad", "CHICMIC179"
                ,"n.ali@gmail.com", "+917837817021");
        Parcelable[] employeeArray = new Employee[2];
        employeeArray[0] = newEmployee;
        employeeArray[1] = secondEmployee;

        mParcelableAndSerializableIntent = new Intent(this, SecondActivity.class);
        mParcelableAndSerializableIntent
                .putExtra(AppConstants.PARCELABLE_OBJECT, (Parcelable) newEmployee);
        mParcelableAndSerializableIntent
                .putExtra(AppConstants.SERIALIZABLE_OBJECT, (Serializable) newEmployee);
        mParcelableAndSerializableIntent
                .putExtra(AppConstants.PARCELABLE_ARRAY_OBJECT, employeeArray);
        findViewById(R.id.btn_next).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_next:
                startActivity(mParcelableAndSerializableIntent);
                break;
        }

    }
}
