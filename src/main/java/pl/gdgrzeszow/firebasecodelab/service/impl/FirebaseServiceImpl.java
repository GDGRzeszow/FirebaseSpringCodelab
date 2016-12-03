package pl.gdgrzeszow.firebasecodelab.service.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.gdgrzeszow.firebasecodelab.service.CensorService;
import pl.gdgrzeszow.firebasecodelab.service.FirebaseService;

@Service
public class FirebaseServiceImpl implements FirebaseService {

    @Autowired
    @Qualifier("main")
    DatabaseReference mainDatabaseReference;

    @Autowired
    CensorService censorService;

    @Value("${firebase.path}")
    private String chatPath;

    @Override
    public void startFirebaseListener() {
        mainDatabaseReference.child(chatPath).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 /*
                 TODO: Here put your code
                 */
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("Cos nie pyklo :< ");
            }
        });
    }
}

