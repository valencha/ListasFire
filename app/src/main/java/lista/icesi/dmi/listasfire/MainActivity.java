package lista.icesi.dmi.listasfire;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();

        DatabaseReference reference = db.getReference().child("usuarios").child("-LPX409-36EoLPYA-eCe");

       // Usuario valencha = new Usuario("ADAD","valencha","valencha10@gmail.com", "holi");

        //reference.push().setValue(valencha);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                   // Usuario s =data.getValue(Usuario.class);


                    Usuario s= dataSnapshot.getValue(Usuario.class);
                    Log.e("NOMBRE","Nombre: "+s.nombre);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
