package eurica.mei.cheers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FirstFragment extends Fragment {
    FirebaseFirestore db;
    private RecyclerView rvStatusList;
    private StatusAdapter adapter;
    private ArrayList<Status> statusArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        //ambil database
        db = FirebaseFirestore.getInstance();
        statusArrayList = new ArrayList<>();
        //ambil data dari koleksi Carwash firestore
        db.collection("status").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String tempUser = document.getString("user");
                        String tempStatus = document.getString("status");
//                        Timestamp tempTime = document.getTimestamp("time");
                        Log.d("onComplete ", tempUser);
                        Log.d("onComplete ", tempStatus);
//                        Log.d("onComplete ", String.valueOf(tempTime));
//                        String sTime = String.valueOf(tempTime);
                        statusArrayList.add(new Status(tempUser, tempStatus, "5m"));
                    }
                }
                rvStatusList = getView().findViewById(R.id.rvStatus);

                adapter = new StatusAdapter(statusArrayList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                rvStatusList.setLayoutManager(layoutManager);

                rvStatusList.setAdapter(adapter);
            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }
}
