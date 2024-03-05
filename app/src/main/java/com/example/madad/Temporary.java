package com.example.madad;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Temporary extends AppCompatActivity {


    private Button uploadBtn,showAllBtn;
    private ImageView imageView;
    private ProgressBar progressBar;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image");
    private StorageReference reference = FirebaseStorage.getInstance().getReference();
    private Uri imageUri;
    private String phonexyz,namexyz;

    private DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary);

        phonexyz= getIntent().getStringExtra("phonexyz");
        namexyz= getIntent().getStringExtra("namexyz");

        uploadBtn=findViewById(R.id.upload_btn);
        //showAllBtn=findViewById(R.id.showall_btn);
        progressBar=findViewById(R.id.progressBar);
        imageView=findViewById(R.id.imageView7);

        progressBar.setVisibility(View.INVISIBLE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,2);

            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (imageUri != null) {
                    uploadToFirebase(imageUri);
                } else {
                    Toast.makeText(Temporary.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {

            imageUri = data.getData();
            imageView.setImageURI(imageUri);


        }

    }

    private void uploadToFirebase(Uri uri){

        StorageReference fileRef = reference.child(System.currentTimeMillis() + "." + getFileExtension(uri));

        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        //Toast.makeText(Temporary.this,phonexyz , Toast.LENGTH_LONG).show();
                        HashMap<String,Object> map=new HashMap<>();
                        map.put("name",namexyz);
                        map.put("url",uri.toString());
                        //Model model = new Model(uri.toString());

                        String modelId = root.push().getKey();
                        root.child(modelId).setValue(map);
                        progressBar.setVisibility(View.INVISIBLE);

                        Toast.makeText(Temporary.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.uploaded_successful);
                        String key=databaseReference.push().getKey();
                        FirebaseDatabase.getInstance().getReference().child("Sign_Up").child(phonexyz).child("photosList").child(key).setValue(uri.toString());






                    }

                    //FirebaseDatabase.getInstance().getReference().child("Sign_Up").child(phonexyz).child("photosList").setValue(fileRef.getDownloadUrl());

                });



            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot snapshot) {

                progressBar.setVisibility(View.VISIBLE);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {

                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(Temporary.this, "Uploading Failed !!", Toast.LENGTH_SHORT).show();
            }
        });


    }


    private String getFileExtension(Uri mUri){

        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));

    }

}