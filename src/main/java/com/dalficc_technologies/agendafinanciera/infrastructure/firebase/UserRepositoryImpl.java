package com.dalficc_technologies.agendafinanciera.infrastructure.firebase;

import com.dalficc_technologies.agendafinanciera.domain.model.User;
import com.dalficc_technologies.agendafinanciera.domain.repository.UserRepository;
import com.google.firebase.database.*;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getUserById(String userId) throws ExecutionException, InterruptedException {

        final User[] user = {new User()};

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("users")
                .child(userId)
                .child("profile");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user[0] = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return user[0];
    }
}
