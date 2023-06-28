package com.example.sportzinteractivedemo.presentation.matches.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sportzinteractivedemo.R
import com.example.sportzinteractivedemo.data.model.*
import com.example.sportzinteractivedemo.databinding.ActivitySeriesBinding
import com.example.sportzinteractivedemo.presentation.matches.viewmodel.SeriesViewModel
import com.example.sportzinteractivedemo.presentation.matches.viewmodel.SeriesViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SeriesActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeriesBinding

    @Inject
    lateinit var seriesViewModelFactory: SeriesViewModelFactory
    private lateinit var seriesViewModel: SeriesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_series)
        seriesViewModel=ViewModelProvider(this,seriesViewModelFactory).get(SeriesViewModel::class.java)
        val actionbar = supportActionBar
        actionbar?.hide()
        binding.seriesViewmodel = seriesViewModel
        binding.lifecycleOwner = this
        getNZIndData()
        onClick()
    }

    private fun getNZIndData(){
        val nzIndResponseData=seriesViewModel.getNzIndMatchData()
        nzIndResponseData.observe(this, Observer {
            if(it!=null) {
                binding.btnNext.visibility=View.VISIBLE
                binding.txtVersus.visibility=View.VISIBLE
                binding.locationImg.visibility=View.VISIBLE
            }else{
                onError("Something went Wrong")
            }
        })
    }

    private fun onClick(){
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,MatchDetailsActivity::class.java))
        }
    }

    private fun onError(error:String){
        val rootView = findViewById<View>(android.R.id.content)
        val snackBar = Snackbar.make(
            rootView, "$error",
            Snackbar.LENGTH_INDEFINITE
        ).setAction("Action", null)
        snackBar.setActionTextColor(Color.WHITE)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.BLACK)
        val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackBar.show()
    }
}