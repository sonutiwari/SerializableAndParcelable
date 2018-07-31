package in.co.chicmic.serializableandparcelable.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import in.co.chicmic.serializableandparcelable.R;
import in.co.chicmic.serializableandparcelable.utilities.AppConstants;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_second);
        TextView parcelableTextView = findViewById(R.id.txt_parcelable);
        TextView serializableTextView = findViewById(R.id.txt_serializable);
        TextView parcelableTextViewArray = findViewById(R.id.txt_parcelable_array);
        Bundle data = getIntent().getExtras();
        if (data != null){
            parcelableTextView
                    .setText(data.getParcelable(AppConstants.PARCELABLE_OBJECT).toString());
            serializableTextView
                    .setText(data.getSerializable(AppConstants.SERIALIZABLE_OBJECT).toString());
            Parcelable[] temp
                    = data.getParcelableArray(AppConstants.PARCELABLE_ARRAY_OBJECT);
            assert temp != null;
            for (Parcelable employee : temp){
                parcelableTextViewArray
                        .setText(employee.toString() + "\n\n" + parcelableTextViewArray.getText());
            }

        }
    }
}
