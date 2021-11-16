package com.example.d15m11y21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * @author		Harel Leibovich <address @ example.com>
 * @version	1.0 (current version number of program)
 * @since		16/11/2021 (the date of the package the class was added)
 * first activity
 */

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {

    EditText jumps, firstnum;
    Button type;
    int mode = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        type = (Button) findViewById(R.id.button2);
        jumps = (EditText) findViewById(R.id.editTextNumberDecimal2);
        firstnum = (EditText) findViewById(R.id.editTextNumberDecimal);

        type.setOnCreateContextMenuListener(this);


    }

    /**
     * moves all the information and the user to the second activity
     * <p>
     *
     * @param	view Description: Button (in the bottom)
     *
     */
    public void move(View view) {
        double sirjumps = 0;
        if (jumps.getText().toString().trim().length() > 0) {
            String st = jumps.getText().toString();
            sirjumps = Double.parseDouble(st);
        }

        double firstNum = 0;

        if (firstnum.getText().toString().trim().length() > 0) {
            String st2 = firstnum.getText().toString();
            firstNum = Double.parseDouble(st2);
        }
        if (mode != -1){
            Intent si = new Intent(this, resultActivity.class);
            si.putExtra("mode", mode);
            si.putExtra("sirMove", sirjumps);
            si.putExtra("firstNum", firstNum);

            startActivity(si);

        }
            Toast.makeText(this,"chose an action!!!!!",Toast.LENGTH_LONG);



    }

    /**
     * create the context menu.
     * <p>
     *
     * @param	v Description	the button the open the menu.
     *
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("choose an option:");
        menu.add("Arithmetic progression");
        menu.add("geometric series");

    }

    /**
     * update in the code what the user selected. if 0:Arithmetic progression else (geometric series) 1
     * <p>
     *
     * @param	item Description	user selection.
     *
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String oper = item.getTitle().toString();
        if (oper.equals("Arithmetic progression")) {
            mode = 0;
            jumps.setHint("enter difference (default -0)");
            return true;
        } else if (oper.equals("geometric series")) {
            mode = 1;
            jumps.setHint("Enter the multiples (default -0)");
            return true;
        }

        return super.onContextItemSelected(item);
    }

    /**
     * create the menu.
     * <p>
     *
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * move to the credits activity.
     * <p>
     *
     */
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.cridits1){
            Intent si = new Intent(this, creditsActivity.class);
            startActivity(si);
        }
        return true;
    }
}
