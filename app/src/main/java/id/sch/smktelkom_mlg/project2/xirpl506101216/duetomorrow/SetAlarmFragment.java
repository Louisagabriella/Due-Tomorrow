package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetAlarmFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_alarm,
                container, false);
        Button button = (Button) rootView.findViewById(R.id.buttonAlarm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail121();
            }
        });
        return rootView;
    }

    public void updateDetail121() {
        Intent intent = new Intent(getActivity(), awal.class);
        startActivity(intent);
    }

}
