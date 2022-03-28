package com.sr.myappjan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity
{

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    TextView status, paired;
    ImageView imgBlue;
    Button on, off, discvr, btnpair;

    BluetoothAdapter mBlueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_activity);

        status = (TextView) findViewById(R.id.txtstatus);
        paired = (TextView) findViewById(R.id.txtPaired);
        imgBlue = (ImageView) findViewById(R.id.btImg);
        on = (Button) findViewById(R.id.btnOn);
        off = (Button) findViewById(R.id.btnOff);
        discvr = (Button) findViewById(R.id.btnDiscovery);
        btnpair = (Button) findViewById(R.id.btnVisible);

        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        //check BT available or not
        if(mBlueAdapter == null)
        {
            status.setText("Bluetooth is not available");
        }
        else
        {
            status.setText("Bluetooth is available");
        }

        //set Image
        if(mBlueAdapter.isEnabled())
        {
            imgBlue.setImageResource(R.drawable.bluetoothon);
        }
        else
        {
            imgBlue.setImageResource(R.drawable.bluetoothoff);
        }

        on.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!mBlueAdapter.isEnabled())
                {
                    showToast("Blutooth is Turning on..");

                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                    imgBlue.setImageResource(R.drawable.bluetoothon);
                }
                else
                {
                    showToast("Bluetooth is already on..");
                }
            }
        });

        discvr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!mBlueAdapter.isDiscovering())
                {
                    showToast("Making your device discoverable..");

                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVER_BT);
                    imgBlue.setImageResource(R.drawable.bluetoothon);
                }
            }
        });

        off.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mBlueAdapter.isEnabled())
                {
                    mBlueAdapter.disable();
                    showToast("Bluetooth is Turning off..");
                    imgBlue.setImageResource(R.drawable.bluetoothoff);
                }
                else
                {
                    showToast("Bluetooth is already off..");
                }
            }
        });

        btnpair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mBlueAdapter.isEnabled())
                {
                    paired.setText("Paired Devices");
                    Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                    for(BluetoothDevice device : devices)
                    {
                        paired.append("\nDevice: " +device.getName()+ "," +device);
                    }
                }
                else
                {
                    showToast("Turn On Bluetooth");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case REQUEST_ENABLE_BT:
                if(resultCode == RESULT_OK)
                {
                    imgBlue.setImageResource(R.drawable.bluetoothon);
                    showToast("Bluetooth is ON");
                }
                else
                {
                    showToast("Couldn't ON Bluetooth");
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //Toast function
    private void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}