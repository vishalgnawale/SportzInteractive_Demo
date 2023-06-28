package com.example.sportzinteractivedemo.presentation.matches.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportzinteractivedemo.R
import com.example.sportzinteractivedemo.data.model.*
import com.example.sportzinteractivedemo.databinding.FragmentTeamABinding
import com.example.sportzinteractivedemo.presentation.matches.adapter.PlayerDataAdapter
import com.example.sportzinteractivedemo.presentation.matches.util.Utility
import com.example.sportzinteractivedemo.presentation.matches.viewmodel.SeriesViewModel

class TeamAFragment : Fragment() {

    private lateinit var binding:FragmentTeamABinding
    private lateinit var playerDataAdapter: PlayerDataAdapter
    private lateinit var seriesViewModel: SeriesViewModel
    private lateinit var playersList:ArrayList<PlayerInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTeamABinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seriesViewModel = activity?.run {
            ViewModelProvider(this).get(SeriesViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        initAdapter()
        getNZIndData()
    }
    private fun initAdapter(){
        binding.fragmentAProgressBar.visibility=View.VISIBLE
        binding.playerListRecyclerview.layoutManager= LinearLayoutManager(activity)
        playerDataAdapter=PlayerDataAdapter({selectedItem: PlayerInfo ->listItemClicked(selectedItem)})
        binding.playerListRecyclerview.adapter=playerDataAdapter
    }
    private fun getNZIndData(){
        val nzIndResponseData=seriesViewModel.getNzIndMatchData()
        nzIndResponseData.observe(viewLifecycleOwner, Observer {
            it?.let { it1 -> createPlayerList(it1) }
        })
    }

    private fun createPlayerList(matchDetails: MatchDetails){
        playersList= Utility.returnPlayerListA(matchDetails.teams.x4.playerTeamA) as ArrayList<PlayerInfo>
        playerDataAdapter.setList(playersList)
        playerDataAdapter.notifyDataSetChanged()
        binding.fragmentAProgressBar.visibility=View.GONE
    }

    @SuppressLint("SetTextI18n")
    private fun listItemClicked(playerInfo: PlayerInfo){
        val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window, null)

        val wid = LinearLayout.LayoutParams.WRAP_CONTENT
        val high = LinearLayout.LayoutParams.WRAP_CONTENT
        val focus= true
        val popupWindow = PopupWindow(popupView, wid, high, focus)
        val txt_player=popupView.findViewById<TextView>(R.id.popup_txt_player)
        val txt_player_batting=popupView.findViewById<TextView>(R.id.popup_player_batting_style)
        val txt_player_bowling=popupView.findViewById<TextView>(R.id.popup_player_bowling_style)
        val close_btn=popupView.findViewById<Button>(R.id.popup_close_button)
        close_btn.setOnClickListener {
            popupWindow.dismiss()
        }

        txt_player.text= "Name -${playerInfo.nameFull}"
        if(!TextUtils.isEmpty(playerInfo.batting.style)) {
            txt_player_batting.text = "Batting style -${playerInfo.batting.style}"
        }else{
            txt_player_batting.text="Batting style -NA"
        }
        if(!TextUtils.isEmpty(playerInfo.bowling.style)) {
            txt_player_bowling.text = "Bowling style -${playerInfo.bowling.style}"
        }else{
            txt_player_bowling.text="Bowling style -NA"
        }

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)



    }


}