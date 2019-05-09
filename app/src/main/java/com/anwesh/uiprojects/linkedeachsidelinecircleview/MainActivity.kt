package com.anwesh.uiprojects.linkedeachsidelinecircleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.eachsidelinecircleview.EachSideLineCircleView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EachSideLineCircleView.create(this)
    }
}
