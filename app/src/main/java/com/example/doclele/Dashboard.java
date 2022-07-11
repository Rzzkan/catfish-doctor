package com.example.doclele;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Dashboard extends AppCompatActivity {
    SessionManager sessionManager;
    TextView etName;
    String username, name;
    RecyclerView recyclerView;
    ArrayList<SetterGetter> datamenu;
    GridLayoutManager gridLayoutManager;
    DashboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Login for? (session)
        sessionManager = new SessionManager(Dashboard.this);

        if (!sessionManager.isLoggedIn() ){
            moveToLogin();
        }

        recyclerView    = findViewById(R.id.rvDashboard);
        etName          = findViewById(R.id.etnameDs);

        username   = sessionManager.getUserDetai().get(SessionManager.USERNAME);
        name       = sessionManager.getUserDetai().get(SessionManager.NAME);

        etName.setText(name);

        addData();
        gridLayoutManager   = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter             = new DashboardAdapter(this,datamenu);
        recyclerView.setAdapter(adapter);





    }
    //Session

    private void moveToLogin() {
        Intent intent = new Intent(Dashboard.this, SplashScreen.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();

    }
    //Logout

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionLogout:
                sessionManager.logoutSession();
                moveToLogin();
        }
        return super.onOptionsItemSelected(item);
    }
    //Menu Dashboard
    public void addData(){
        datamenu        = new ArrayList<>();
        datamenu.add(new SetterGetter("Tanya Pakar","logomenu1"));
        datamenu.add(new SetterGetter("Daftar Penyakit","logomenu5"));
        datamenu.add(new SetterGetter("Daftar Pakar","logomenu2"));
        datamenu.add(new SetterGetter("Cara Perawatan","logomenu3"));
        datamenu.add(new SetterGetter("Help","logomenu6"));
        datamenu.add(new SetterGetter("About","logomenu4"));


    }
}