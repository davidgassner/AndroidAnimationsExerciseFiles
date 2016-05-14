package com.example.david.transitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    int mCurrentScene = 1;
    private Scene mScene1, mScene2;
    private ViewGroup mSceneRoot;
    private TransitionManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, this);
        mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene2, this);
        mManager = TransitionInflater.from(this)
                .inflateTransitionManager(R.transition.manager, mSceneRoot);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_transition) {
            runTransition();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void runTransition() {
        if (mCurrentScene == 1) {
            TransitionManager.go(mScene2);
            mCurrentScene = 2;
        } else {
            mManager.transitionTo(mScene1);
            mCurrentScene = 1;
        }
    }

}
