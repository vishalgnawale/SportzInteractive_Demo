package com.example.sportzinteractivedemo.presentation.matches.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzinteractivedemo.R
import com.example.sportzinteractivedemo.data.model.PlayerInfo
import com.example.sportzinteractivedemo.databinding.PlayersItemListBinding

class PlayerDataAdapter(
    private val clickListener:(PlayerInfo)->Unit
):RecyclerView.Adapter<PlayerViewHolder> () {

    private val playerList=ArrayList<PlayerInfo>()
    fun setList(players:List<PlayerInfo>){
        playerList.clear()
        playerList.addAll(players)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding : PlayersItemListBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.players_item_list,
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playerList[position], clickListener)
    }

    override fun getItemCount(): Int {
       return playerList.size
    }

}
class PlayerViewHolder(private val binding: PlayersItemListBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(
        playerInfo: PlayerInfo,
        clickListener:(PlayerInfo)->Unit
    ){
        binding.txtPlayerName.text=playerInfo.nameFull
        if(playerInfo.isCaptain){
            binding.txtResponsibility.visibility=View.VISIBLE
            binding.txtResponsibility.text="Captain"
        }
        if(playerInfo.isKeeper){
            binding.txtResponsibility.visibility=View.VISIBLE
            binding.txtResponsibility.text="WK"
        }
        binding.listItemLayout.setOnClickListener {
            clickListener(playerInfo)
        }
    }
}