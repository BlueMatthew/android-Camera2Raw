package com.xypower.camera2raw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static int ExposureComp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int comp = -1000;
        switch (id) {
            case R.id.action_picture:
                takePicture();
                break;
            case R.id.action_focus:
                doFocus();
                break;
            case R.id.action_comp0:
                comp = 0;
                break;
            case R.id.action_comp1:
                comp = 1;
                break;
            case R.id.action_comp2:
                comp = 2;
                break;
            case R.id.action_comp3:
                comp = 3;
                break;
            case R.id.action_comp4:
                comp = 4;
                break;
            case R.id.action_comp_1:
                comp = -1;
                break;
            case R.id.action_comp_2:
                comp = -2;
                break;
            case R.id.action_comp_3:
                comp = -3;
                break;
            case R.id.action_comp_4:
                comp = -4;
                break;
            case R.id.action_info:
                new AlertDialog.Builder(this)
                        .setMessage(R.string.intro_message)
                        .setPositiveButton(android.R.string.ok, null)
                        .show();

                break;
            default:
                break;
        }

        if (comp> -1000) {
            ExposureComp = comp;
            restartFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    private void restartFragment() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, Camera2RawFragment.newInstance())
                .commit();
    }

    private void doFocus() {
        Camera2RawFragment fragment = (Camera2RawFragment)getSupportFragmentManager().findFragmentById(R.id.container);
        fragment.doFocus();
    }

    private void takePicture() {
        Camera2RawFragment fragment = (Camera2RawFragment)getSupportFragmentManager().findFragmentById(R.id.container);
        fragment.takePicture();
    }
}