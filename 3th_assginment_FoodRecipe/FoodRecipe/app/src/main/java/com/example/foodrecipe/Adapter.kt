package com.example.foodrecipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_item.view.*


class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setItem(item: simpleFoodValue){
        itemView.foodTitle.text = item.title
        Glide.with(itemView).load(item.thumbnail).into(itemView.foodImg)
        itemView.setOnClickListener(item.onClickListener)
        //글라이드로 이미지 처리
    }
}

class ItemAdapter():RecyclerView.Adapter<Holder>(){
    var items = mutableListOf<simpleFoodValue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //Inflater는 특정 XML파일을 클래스로 변환할 수 있도록 해준다
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

}