package com.example.madad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;


public class MainActivity3 extends AppCompatActivity implements View.OnFocusChangeListener {
    Button GoToNewActivity;
    Button Forget;
    Button Home;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private LoginButton loginButton;
    private AccessTokenTracker accessTokenTracker;
    private static final String TAG = "FacebookAuthentication";
    public static String fullname;
    public  static String phonenumber;



   GoogleSignInClient mGoogleSignInClient;
   private static int RC_SIGN_IN=100;


    EditText button9;

    EditText editTextTextPersonName7;
    EditText editTextTextPassword3;
    Button bb;



    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        GoToNewActivity = (Button)findViewById(R.id.button10);

        GoToNewActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (MainActivity3.this, MainActivity2.class);
                startActivity(i);

            }
        });

        bb = (Button)findViewById(R.id.button11);
        bb.setFocusable(true);
        bb.setFocusableInTouchMode(true);
        bb.requestFocus();
        editTextTextPersonName7=(EditText)findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName7.setOnFocusChangeListener( this);
        editTextTextPassword3=(EditText)findViewById(R.id.editTextTextPassword3);
        editTextTextPassword3.setOnFocusChangeListener((View.OnFocusChangeListener) this);




        Home = (Button)findViewById(R.id.button11);

        Home.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent i = new Intent (MainActivity3.this, Home.class);
                //startActivity(i);
                login();
            }
        });



        Forget = (Button)findViewById(R.id.button9);

        Forget.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (MainActivity3.this, Forgotpass.class);
                startActivity(i);
            }
        });





        mFirebaseAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());
        loginButton=findViewById(R.id.login_button);
        //loginButton.setReadPermissions("email","name");

        mCallbackManager=CallbackManager.Factory.create();
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError" + error);
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null) {
                    updateUI(user);
                }
                else {
                    updateUI(null);
                }
            }
        };
        accessTokenTracker=new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if (currentAccessToken==null) {
                    mFirebaseAuth.signOut();
                }

            }
        };





        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);




        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);


        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


    }



    @Override
    public void onFocusChange(View v, boolean gainFocus)
    {
        if(v.getId()==R.id.editTextTextPersonName7 && gainFocus)
            editTextTextPersonName7.setText(" ");
            //Toast.makeText(getApplicationContext(),"Name cleared!",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextTextPassword3 && gainFocus)
            editTextTextPassword3.setText("");

    }



    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();


                Toast.makeText(this,"User email : "+personEmail,Toast.LENGTH_SHORT).show();
            }
            Intent i = new Intent (MainActivity3.this, Home.class);
            startActivity(i);
            // Signed in successfully, show authenticated UI.


        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("Message",e.toString());

        }
    }


















    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mCallbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);




        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new  OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity3.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });



        }
    private void updateUI(FirebaseUser user) {
        if(user != null){
            Toast.makeText(getApplicationContext(),"Login SuccessFull !",Toast.LENGTH_SHORT).show();
            Intent i = new Intent (MainActivity3.this, Home.class);
            startActivity(i);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener((authStateListener));
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null) {
            mFirebaseAuth.removeAuthStateListener((authStateListener));
        }
    }

    public void login() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        String mob=editTextTextPersonName7.getText().toString().trim();


        mDatabase.child("Sign_Up").child(mob).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NotNull @org.jetbrains.annotations.NotNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()) {
                            //Toast.makeText(getApplicationContext(),mob,Toast.LENGTH_LONG).show();
                            dataholder contact = dataSnapshot.getValue(dataholder.class);
                            assert contact != null;
                            String password = contact.getPassword();
                            String usedpassword=editTextTextPassword3.getText().toString().trim();
                            if(password.equals(usedpassword)){
                                //Toast.makeText(getApplicationContext(),"login Successful"+" ",Toast.LENGTH_LONG).show();
                                fullname=contact.getFullname();
                                phonenumber=contact.getPhno();
                                Intent i = new Intent (MainActivity3.this, Home.class);
                                i.putExtra("phonexyz",phonenumber);
                                i.putExtra("namexyz",fullname);
                                startActivity(i);
                            }else{
                                Toast.makeText(getApplicationContext(),"login Failed"+" ",Toast.LENGTH_LONG).show();
                            }

                            /*try {
                                Thread.sleep(1000);
                                Intent i = new Intent (MainActivity3.this, Home.class);
                                startActivity(i);



                            } catch (Exception e) {

                                //e.printStackTrace();
                                Toast.makeText(getApplicationContext(), "Error"+e,Toast.LENGTH_LONG).show();
                            }  */


                        }else{
                            Toast.makeText(getApplicationContext()," User Not Exists",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NotNull @org.jetbrains.annotations.NotNull DatabaseError databaseError) {

                    }
                });


    }


}