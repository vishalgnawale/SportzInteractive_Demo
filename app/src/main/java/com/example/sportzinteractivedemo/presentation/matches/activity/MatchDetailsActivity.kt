package com.example.sportzinteractivedemo.presentation.matches.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sportzinteractivedemo.R
import com.example.sportzinteractivedemo.data.model.Teams
import com.example.sportzinteractivedemo.databinding.ActivityMatchDetailsBinding
import com.example.sportzinteractivedemo.presentation.matches.fragments.TeamAFragment
import com.example.sportzinteractivedemo.presentation.matches.fragments.TeamBFragment
import com.example.sportzinteractivedemo.presentation.matches.viewmodel.SeriesViewModel
import com.example.sportzinteractivedemo.presentation.matches.viewmodel.SeriesViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MatchDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchDetailsBinding
    @Inject
    lateinit var seriesViewModelFactory: SeriesViewModelFactory
    private lateinit var seriesViewModel: SeriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_match_details)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.title="Player Information"

        seriesViewModel= ViewModelProvider(this,seriesViewModelFactory).get(SeriesViewModel::class.java)
        loadFragment(TeamAFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.team_a -> {
                    loadFragment(TeamAFragment())
                    true
                }
                R.id.team_b -> {
                    loadFragment(TeamBFragment())
                    true
                }
                else -> {
                    loadFragment(TeamAFragment())
                    true
                }
            }
        }
        observeData()
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    private fun observeData(){
        val nzIndResponseData=seriesViewModel.getNzIndMatchData()
        nzIndResponseData.observe(this, Observer {
            it?.let { it1 -> setTeamsName(it1.teams) }
        })
    }

    private fun setTeamsName(teams: Teams){
        val menu:Menu=binding.bottomNav.menu
        menu.getItem(0).title=teams.x4.nameShort
        menu.getItem(1).title=teams.x5.nameShort
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}