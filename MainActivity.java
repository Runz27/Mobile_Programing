package com.example.materialerttoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    private String[] items={"Short","Long"};
    private Spinner spinner;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        spinner= (Spinner) findViewById(R.id.durasiSpinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        spinner.setAdapter(adapter);

        findViewById(R.id.alret1button).setOnClickListener(this);
        findViewById(R.id.alret2button).setOnClickListener(this);
        findViewById(R.id.alret3button).setOnClickListener(this);
        findViewById(R.id.toastbutton).setOnClickListener(this);
        findViewById(R.id.tutupbutton).setOnClickListener(this);


    }
    public void onClick(View v){
        //TODO Auto-generated method stub
        switch (v.getId()){
            case R.id.alret1button:
                dialog=new Dialog(this);
                dialog.setContentView(R.layout.custome_dialog);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));

                }
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                Button Okay = dialog.findViewById(R.id.btn_okay);
                Button Cancel = dialog.findViewById(R.id.btn_cancel);
                Okay.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(MainActivity.this, "Okay", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                Cancel.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.alret2button:
                AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
                alert2.setTitle("Konfirmasi");
                alert2.setMessage("Tampilkan Alert 2, Klik Tombol");
                alert2.setIcon(R.drawable.ic_baseline);
                alert2.setPositiveButton("Ya", new DialogInterface.OnClickListener(){
                   public void onClick(DialogInterface arg0, int arg1){
                       Toast.makeText(getApplicationContext(), "Tombol Ya DiKlik", Toast.LENGTH_SHORT).show();
                   }
                });
                alert2.setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(), "Tombol Tidak DiKlik", Toast.LENGTH_SHORT).show();
                        alert2.show();
                    }
                });

                        break;
                        case R.id.alret3button:
                        AlertDialog.Builder alert3 = new AlertDialog.Builder(this);
                        alert3.setTitle("Konfirmasi");
                        alert3.setMessage("Tampilkan Alert 3, Klik Tombol");
                        alert3.setIcon(R.drawable.ic_baseline);
                        alert3.setPositiveButton("ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(getApplicationContext(), "Tombol Ya DiKlik", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert3.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(getApplicationContext(), "Tombol Tidak DiKlik", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert3.setNeutralButton("Batal", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(getApplicationContext(), "Tombol Batal DiKlik", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert3.show();
                        break;
                        case R.id.toastbutton:
                        if (spinner.getSelectedItemPosition() == 0) {
                            Toast.makeText(this, "Toast Short", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Toast Long", Toast.LENGTH_LONG).show();
                        }
                        break;
                        case R.id.tutupbutton:
                            AlertDialog.Builder tutup=new AlertDialog.Builder(this);
                            tutup.setTitle("Alert!!");
                            tutup.setIcon(R.drawable.ic_sharp_warning);
                            tutup.setMessage("Apakah Kamu Yakin Ingin Menutup Aplikasi Ini?");
                            tutup.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    System.exit(0);
                                }
                            });
                                    tutup.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                        tutup.show();
                    }
                }
        }
