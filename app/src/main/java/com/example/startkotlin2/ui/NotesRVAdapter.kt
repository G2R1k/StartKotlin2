package com.example.startkotlin2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.startkotlin2.R
import com.example.startkotlin2.data.Note
import kotlinx.android.synthetic.main.item.view.*

class NotesRVAdapter(val onClickListener: ((Note) -> Unit)? = null) : RecyclerView.Adapter<NotesRVAdapter.MyViewHolder>() {



    var notes: List<Note> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(notes[position])

    override fun getItemCount() = notes.size

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(note: Note) = with(itemView){
            tv_title.text = note.title
            tv_text.text = note.text

            val color: Int = when(note.color){
                Note.Color.WHITE -> R.color.white
                Note.Color.YELLOW -> R.color.yellow
                Note.Color.GREEN -> R.color.green
                Note.Color.BLUE -> R.color.blue
                Note.Color.RED -> R.color.red
                Note.Color.VIOLET -> R.color.violet
            }
            (itemView as CardView).setCardBackgroundColor(ResourcesCompat
                .getColor(resources, color, null))

            itemView.setOnClickListener {
                onClickListener?.invoke(note)
            }
        }
    }
}