package hello.example.com.youtube;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FirstScreen extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Intent intent = new Intent(getApplicationContext(),Play.class);
//        startActivity(intent);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                    if (getFromPref(getApplicationContext(), ALLOW_KEY)) {
//                        showSettingsAlert();
//                    } else if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                            Manifest.permission.CAMERA)
//
//                            != PackageManager.PERMISSION_GRANTED) {
//
//                        // Should we show an explanation?
//                        if (ActivityCompat.shouldShowRequestPermissionRationale(FirstScreen.this,
//                                Manifest.permission.CAMERA)) {
//                            showAlert();
//                        } else {
//                            // No explanation needed, we can request the permission.
//                            ActivityCompat.requestPermissions(FirstScreen.this,
//                                    new String[]{Manifest.permission.CAMERA},
//                                    MY_PERMISSIONS_REQUEST_CAMERA);
//                        }
//                    }
//                } else {
//                    openCamera();
//                }
//
//            }
//        });
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.mipmap.home,
                R.mipmap.fire,
                R.mipmap.youtube,
                R.mipmap.play,
                R.mipmap.manuser
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "ONE");
        adapter.addFrag(new FireFragment(), "TWO");
        adapter.addFrag(new ChatFragment(), "THREE");
        adapter.addFrag(new PlayFragment(), "TWO");
        adapter.addFrag(new PersonFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_CAMERA: {
//                for (int i = 0, len = permissions.length; i < len; i++) {
//                    String permission = permissions[i];
//
//                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
//                        boolean
//                                showRationale =
//                                ActivityCompat.shouldShowRequestPermissionRationale(
//                                        this, permission);
//
//                        if (showRationale) {
//                            //showAlert();
//                        } else if (!showRationale) {
//                            // user denied flagging NEVER ASK AGAIN
//                            // you can either enable some fall back,
//                            // disable features of your app
//                            // or open another dialog explaining
//                            // again the permission and directing to
//                            // the app setting
//                            saveToPreferences(FirstScreen.this, ALLOW_KEY, true);
//                        }
//                    }
//                }
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request
//        }
//    }
//
//    private void openCamera() {
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        startActivity(intent);
//    }
//
//    private void showSettingsAlert() {
//        AlertDialog alertDialog = new AlertDialog.Builder(FirstScreen.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage("App needs to access the Camera.");
//
//        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
//                new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        //finish();
//                    }
//                });
//
//        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
//                new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        //startInstalledAppDetailsActivity(FirstScreen.this);
//                    }
//                });
//
//        alertDialog.show();
//    }
//
//    private void showAlert() {
//        AlertDialog alertDialog = new AlertDialog.Builder(FirstScreen.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage("App needs to access the Camera.");
//
//        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        finish();
//                    }
//                });
//
//        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW",
//                new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        ActivityCompat.requestPermissions(FirstScreen.this,
//                                new String[]{Manifest.permission.CAMERA},
//                                MY_PERMISSIONS_REQUEST_CAMERA);
//                    }
//                });
//        alertDialog.show();
//    }
//
//    public static void saveToPreferences(Context context, String key, Boolean allowed) {
//        SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF,
//                Context.MODE_PRIVATE);
//        SharedPreferences.Editor prefsEditor = myPrefs.edit();
//        prefsEditor.putBoolean(key, allowed);
//        prefsEditor.commit();
//    }
//
//    public static Boolean getFromPref(Context context, String key) {
//        SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF,
//                Context.MODE_PRIVATE);
//        return (myPrefs.getBoolean(key, false));
//    }
}
