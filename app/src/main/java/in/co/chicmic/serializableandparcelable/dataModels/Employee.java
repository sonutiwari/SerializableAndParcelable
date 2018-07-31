package in.co.chicmic.serializableandparcelable.dataModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Employee implements Serializable, Parcelable {

    private String mEmployeeName;
    private String mEmployeeId;
    private String mEmployeeEmailId;
    private String mEmployeePhoneNo;

    public Employee(String mEmployeeName, String mEmployeeId
            , String mEmployeeEmailId, String mEmployeePhoneNo) {
        this.mEmployeeName = mEmployeeName;
        this.mEmployeeId = mEmployeeId;
        this.mEmployeeEmailId = mEmployeeEmailId;
        this.mEmployeePhoneNo = mEmployeePhoneNo;
    }

    private Employee(Parcel in) {
        mEmployeeName = in.readString();
        mEmployeeId = in.readString();
        mEmployeeEmailId = in.readString();
        mEmployeePhoneNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mEmployeeName);
        dest.writeString(mEmployeeId);
        dest.writeString(mEmployeeEmailId);
        dest.writeString(mEmployeePhoneNo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    @Override
    public String toString() {
        return "Employee {\n" +
                "mEmployeeName='" + mEmployeeName + '\'' +
                ", mEmployeeId='" + mEmployeeId + '\'' +
                ", mEmployeeEmailId='" + mEmployeeEmailId + '\'' +
                ", mEmployeePhoneNo='" + mEmployeePhoneNo + "\n" +
                '}';
    }
}
