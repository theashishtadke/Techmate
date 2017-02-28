package firstproject.com.techmate;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;
import Model.Entries;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.client.Firebase;
import firstproject.com.techmate.Attendance;
import Model.EventModel;





/**
 * Created by user on 03-09-2016.
 */
public class EventFetch extends Fragment {
   ListView list;
    Firebase eventRef;


    public EventFetch() {
        // Required empty public constructor
        eventRef = new Firebase("https://csipublicity-af5de.firebaseio.com/events/");



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list= (ListView) getActivity().findViewById(R.id.listEvents);
        getEvents();
    }

    public void getEvents()
    {

        final FirebaseListAdapter<EventModel> adapter= new FirebaseListAdapter<EventModel>(
                getActivity(),
                EventModel.class,
                android.R.layout.simple_list_item_1,
                eventRef
        ) {
            @Override
            protected void populateView(View view, EventModel event, int i) {
                TextView textView= (TextView) view.findViewById(android.R.id.text1);
                list= (ListView) view.findViewById(android.R.id.list);
                textView.setText(event.getName());
            }
        };

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String eventName = ((TextView)view.findViewById(android.R.id.text1))
                        .getText().toString();
                android.support.v4.app.FragmentTransaction transaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                Attendance add = new Attendance();
                add.setEvent(eventName);
                transaction.replace(R.id.fragment_container, add);

                transaction.commit();
            }
        });
    }
    }




