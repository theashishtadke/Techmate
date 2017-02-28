package firstproject.com.techmate;

/**
 * Created by user on 03-09-2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.AttendanceModel;
import Model.Entries;
public class Attendance extends Fragment
{
    public Attendance() {
        // Required empty public constructor
    }
  Firebase ref = new Firebase("https://csipublicity-af5de.firebaseio.com/entries/");
     ListView list1;
     String eventName="";
     EventListAdapter eventListAdapter;
    ArrayList<AttendanceModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list1= (ListView) getActivity().findViewById(R.id.listAttandance);
        list=new ArrayList<>();
        eventListAdapter =new EventListAdapter(getActivity(),list);
        getAttendance();
    }

    public  void getAttendance()
    {


        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    Entries entries=ds.getValue(Entries.class);
                    if(entries.getEventName().equals(eventName)){
                        list.add(new AttendanceModel(entries.getName(),entries.getStatus(),ds.getKey()));
                    }
                }

                list1.setAdapter(eventListAdapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
    public void setEvent(String eventname){

        eventName=eventname;
    }
}



