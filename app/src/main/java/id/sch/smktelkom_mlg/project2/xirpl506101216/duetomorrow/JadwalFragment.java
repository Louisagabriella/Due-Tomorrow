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
public class JadwalFragment extends Fragment {

    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_jadwal, container, false);

        Button button = (Button) rootView.findViewById(R.id.buttonsnn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });

        Button button1 = (Button) rootView.findViewById(R.id.buttonsls);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail1();
            }
        });

        Button button2 = (Button) rootView.findViewById(R.id.buttonrb);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail2();
            }
        });

        Button button3 = (Button) rootView.findViewById(R.id.buttonkms);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail3();
            }
        });

        Button button4 = (Button) rootView.findViewById(R.id.buttonjmt);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail4();
            }
        });

        Button button5 = (Button) rootView.findViewById(R.id.buttonsbt);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail5();
            }
        });
        return rootView;
    }

    private void updateDetail5() {
        Intent intent = new Intent(getActivity(), Sabtu.class);
        startActivity(intent);
    }

    private void updateDetail4() {
        Intent intent = new Intent(getActivity(), Jumat.class);
        startActivity(intent);
    }

    private void updateDetail3() {
        Intent intent = new Intent(getActivity(), Kamis.class);
        startActivity(intent);
    }

    private void updateDetail2() {
        Intent intent = new Intent(getActivity(), Rabu.class);
        startActivity(intent);
    }

    private void updateDetail1() {
        Intent intent = new Intent(getActivity(), Selasa.class);
        startActivity(intent);
    }

    private void updateDetail() {
        Intent intent = new Intent(getActivity(), Senin.class);
        startActivity(intent);
    }

}
