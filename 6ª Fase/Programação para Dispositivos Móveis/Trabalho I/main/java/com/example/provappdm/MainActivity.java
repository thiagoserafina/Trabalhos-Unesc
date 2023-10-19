package com.example.provappdm;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> listRemove = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor edit = pref.edit();

        EditText tableNumber = findViewById(R.id.numberTables);

        //LINEAR  MESA
        LinearLayout tableBG1 =findViewById(R.id.tableBG1);
        LinearLayout tableBG2 =findViewById(R.id.tableBG2);
        LinearLayout tableBG3 =findViewById(R.id.tableBG3);
        LinearLayout tableBG4 =findViewById(R.id.tableBG4);
        LinearLayout tableBG5 =findViewById(R.id.tableBG5);
        LinearLayout tableBG6 =findViewById(R.id.tableBG6);
        LinearLayout tableBG7 =findViewById(R.id.tableBG7);
        LinearLayout tableBG8 =findViewById(R.id.tableBG8);
        LinearLayout tableBG9 =findViewById(R.id.tableBG9);

        //BTN MESA
        Button btnTable1 =findViewById(R.id.tableID_1);
        Button btnTable2 =findViewById(R.id.tableID_2);
        Button btnTable3 =findViewById(R.id.tableID_3);
        Button btnTable4 =findViewById(R.id.tableID_4);
        Button btnTable5 =findViewById(R.id.tableID_5);
        Button btnTable6 =findViewById(R.id.tableID_6);
        Button btnTable7 =findViewById(R.id.tableID_7);
        Button btnTable8 =findViewById(R.id.tableID_8);
        Button btnTable9 =findViewById(R.id.tableID_9);

        //BTN ACOES
        Button btnLibertyTable = findViewById(R.id.libertTable);
        Button btnReserveAll = findViewById(R.id.reserveAll);
        Button btnConfig = findViewById(R.id.settings);
        Button btnSaveOperation = findViewById(R.id.SaveOperation);
        Button btnLogOut = findViewById(R.id.btnLogOut);

        if(pref.getInt("key_table1", -1) != -1) {
            list.add(pref.getInt("key_table1", -1));
            tableBG1.setBackgroundResource(R.color.red);
            btnTable1.setEnabled(false);
        }

        if(pref.getInt("key_table2", -1) != -1) {
            list.add(pref.getInt("key_table2", -1));
            tableBG2.setBackgroundResource(R.color.red);
            btnTable2.setEnabled(false);
        }

        if(pref.getInt("key_table3", -1) != -1) {
            list.add(pref.getInt("key_table3", -1));
            tableBG3.setBackgroundResource(R.color.red);
            btnTable3.setEnabled(false);
        }

        if(pref.getInt("key_table4", -1) != -1) {
            list.add(pref.getInt("key_table4", -1));
            tableBG4.setBackgroundResource(R.color.red);
            btnTable4.setEnabled(false);
        }

        if(pref.getInt("key_table5", -1) != -1) {
            list.add(pref.getInt("key_table5", -1));
            tableBG5.setBackgroundResource(R.color.red);
            btnTable5.setEnabled(false);
        }

        if(pref.getInt("key_table6", -1) != -1) {
            list.add(pref.getInt("key_table6", -1));
            tableBG6.setBackgroundResource(R.color.red);
            btnTable6.setEnabled(false);
        }

        if(pref.getInt("key_table7", -1) != -1) {
            list.add(pref.getInt("key_table7", -1));
            tableBG7.setBackgroundResource(R.color.red);
            btnTable7.setEnabled(false);
        }

        if(pref.getInt("key_table8", -1) != -1) {
            list.add(pref.getInt("key_table8", -1));
            tableBG8.setBackgroundResource(R.color.red);
            btnTable8.setEnabled(false);
        }

        if(pref.getInt("key_table9", -1) != -1) {
            list.add(pref.getInt("key_table9", -1));
            tableBG9.setBackgroundResource(R.color.red);
            btnTable9.setEnabled(false);
        }

        btnTable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG1.setBackgroundResource(R.color.red);
                btnTable1.setEnabled(false);
                list.add(1);
            }
        });

        btnTable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG2.setBackgroundResource(R.color.red);
                btnTable2.setEnabled(false);
                list.add(2);
            }
        });

        btnTable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG3.setBackgroundResource(R.color.red);
                btnTable3.setEnabled(false);
                list.add(3);
            }
        });

        btnTable4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG4.setBackgroundResource(R.color.red);
                btnTable4.setEnabled(false);
                list.add(4);
            }
        });

        btnTable5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG5.setBackgroundResource(R.color.red);
                btnTable5.setEnabled(false);
                list.add(5);
            }
        });

        btnTable6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG6.setBackgroundResource(R.color.red);
                btnTable6.setEnabled(false);
                list.add(6);
            }
        });

        btnTable7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG7.setBackgroundResource(R.color.red);
                btnTable7.setEnabled(false);
                list.add(7);
            }
        });

        btnTable8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG8.setBackgroundResource(R.color.red);
                btnTable8.setEnabled(false);
                list.add(8);
            }
        });

        btnTable9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableBG9.setBackgroundResource(R.color.red);
                btnTable9.setEnabled(false);
                list.add(9);
            }
        });

        btnSaveOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i < list.size(); i++) {
                    edit.putInt("key_table" + list.get(i), list.get(i)).apply();
                }

                for(int i=0; i < listRemove.size(); i++) {
                    edit.remove("key_table"+ listRemove.get(i)).apply();
                }
            }
        });

        btnReserveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list.size()!=9) {
                    list.clear();

                    for(int i=1; i < 10; i++) {
                     list.add(i);
                    }

                    tableBG1.setBackgroundResource(R.color.red);
                    tableBG2.setBackgroundResource(R.color.red);
                    tableBG3.setBackgroundResource(R.color.red);
                    tableBG4.setBackgroundResource(R.color.red);
                    tableBG5.setBackgroundResource(R.color.red);
                    tableBG6.setBackgroundResource(R.color.red);
                    tableBG7.setBackgroundResource(R.color.red);
                    tableBG8.setBackgroundResource(R.color.red);
                    tableBG9.setBackgroundResource(R.color.red);
                    btnTable1.setEnabled(false);
                    btnTable2.setEnabled(false);
                    btnTable3.setEnabled(false);
                    btnTable4.setEnabled(false);
                    btnTable5.setEnabled(false);
                    btnTable6.setEnabled(false);
                    btnTable7.setEnabled(false);
                    btnTable8.setEnabled(false);
                    btnTable9.setEnabled(false);
                    edit.putInt("key_table1", 1).apply();
                    edit.putInt("key_table2", 2).apply();
                    edit.putInt("key_table3", 3).apply();
                    edit.putInt("key_table4", 4).apply();
                    edit.putInt("key_table5", 5).apply();
                    edit.putInt("key_table6", 6).apply();
                    edit.putInt("key_table7", 7).apply();
                    edit.putInt("key_table8", 8).apply();
                    edit.putInt("key_table9", 9).apply();
                }
                else{
                    Toast.makeText(MainActivity.this, "Operação inválida. Todas as mesas já possuem\n" +
                            "reserva", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLibertyTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(tableNumber.getText().toString());
                list.remove(number);

                if(!list.contains(number) || listRemove.contains(number)){
                    Toast.makeText(MainActivity.this, "Mesa não reservada. A mesa "+number+" encontra-se habilitada para reserva", Toast.LENGTH_SHORT).show();
                } else {
                    edit.remove("key_table" + number).apply();
                    listRemove.add(number);

                    if(number==1){
                        tableBG1.setBackgroundResource(R.color.blue);
                        btnTable1.setEnabled(true);
                    } if(number==2){
                        tableBG2.setBackgroundResource(R.color.blue);
                        btnTable2.setEnabled(true);
                    } if(number==3) {
                        tableBG3.setBackgroundResource(R.color.blue);
                        btnTable3.setEnabled(true);
                    } if(number==4){
                        tableBG4.setBackgroundResource(R.color.blue);
                        btnTable4.setEnabled(true);
                    } if(number==5){
                        tableBG5.setBackgroundResource(R.color.blue);
                        btnTable5.setEnabled(true);
                    } if(number==6){
                        tableBG6.setBackgroundResource(R.color.blue);
                        btnTable6.setEnabled(true);
                    } if(number==7){
                        tableBG7.setBackgroundResource(R.color.blue);
                        btnTable7.setEnabled(true);
                    } if(number==8){
                        tableBG8.setBackgroundResource(R.color.blue);
                        btnTable8.setEnabled(true);
                    } if(number==9){
                        tableBG9.setBackgroundResource(R.color.blue);
                        btnTable9.setEnabled(true);
                    }
                }
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.remove("KEY_USER").apply();
                edit.remove("KEY_PASSWORD").apply();

                startActivity(new Intent(MainActivity.this, SessionActivity.class));
            }
        });
    }
}