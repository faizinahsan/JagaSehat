package com.example.pbo.jagasehat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class HomePage extends Fragment {
    Button bacaBuku,isiCerita,isiHarapan,isiKelebihan,isiAku,bagiSosmed;
    private Context mContext;
    private Activity mActivity;

    private FrameLayout mFrameLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;
    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        isiCerita = (Button) view.findViewById(R.id.isiCerita);
        isiCerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),AkuDanCeritaku.class));
            }
        });
        bacaBuku = (Button) view.findViewById(R.id.bacaBuku);
        bacaBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),CobaBaca.class));
            }
        });
        isiHarapan = (Button) view.findViewById(R.id.isiHarapan);
        isiHarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),HarapanDanCita.class));
            }
        });
        isiKelebihan = (Button) view.findViewById(R.id.isiKelebihan);
        isiKelebihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Kelebihan.class));
            }
        });
        isiAku = (Button) view.findViewById(R.id.isiAku);
        isiAku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Aku.class));
            }
        });
        bagiSosmed = (Button) view.findViewById(R.id.bagiSosmed);
        bagiSosmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEntry = "Hai Saya Memakai Aplikasi Jaga Sehat";

                Intent textShareIntent = new Intent(Intent.ACTION_SEND);
                textShareIntent.putExtra(Intent.EXTRA_TEXT, userEntry);
                textShareIntent.setType("text/plain");
                startActivity(Intent.createChooser(textShareIntent, "Bagikan Aplikasi Ke..."));
            }
        });
        // Get the application context
        mContext = getContext();

        // Get the activity
        mActivity = getActivity();

        // Get the widgets reference from XML layout
        mFrameLayout = (FrameLayout) view.findViewById(R.id.homepage);
        mButton = (Button) view.findViewById(R.id.mengenalDeveloper);
        // Set a click listener for the text view
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.developer_layout,null);

                /*
                    public PopupWindow (View contentView, int width, int height)
                        Create a new non focusable popup window which can display the contentView.
                        The dimension of the window must be passed to this constructor.

                        The popup does not provide any background. This should be handled by
                        the content view.

                    Parameters
                        contentView : the popup's content
                        width : the popup's width
                        height : the popup's height
                */
                // Initialize a new instance of popup window
                mPopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                // Get a reference for the custom view close button
                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);

                // Set a click listener for the popup window close button
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                /*
                    public void showAtLocation (View parent, int gravity, int x, int y)
                        Display the content view in a popup window at the specified location. If the
                        popup window cannot fit on screen, it will be clipped.
                        Learn WindowManager.LayoutParams for more information on how gravity and the x
                        and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
                        to specifying Gravity.LEFT | Gravity.TOP.

                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
                // Finally, show the popup window at the center location of root relative layout
                mPopupWindow.showAtLocation(mFrameLayout, Gravity.CENTER,0,0);
            }
        });

        return view;
    }

}
