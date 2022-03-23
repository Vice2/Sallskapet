package se.jessikagerhardsson.sallskapet



import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rowAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    lateinit var act : HittaparenActivity

    //var hej = mutableListOf<Int>(R.drawable.ic_heart, R.drawable.ic_plane, R.drawable.ic_lightning, R.drawable.hund)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vh = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_rowadapter, parent, false))
        return vh
    }
    override fun getItemCount(): Int {
        return act.cards.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Rita rad

        val currentCard = act.cards[position]

        if(currentCard.isFacedUp || currentCard.isMatched)
        {
            holder.myCardImage.setImageResource(currentCard.identifier)
        } else {
            holder.myCardImage.setImageResource(R.drawable.cardback)
        }

        holder.itemView.setOnClickListener {
            if(currentCard.isMatched == false)
            {
                act.clickCard(position)
            }

        }

    }
}
class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    //var hejsan = view.findViewById<TextView>(R.id.rowTV)
    var myCardImage = view.findViewById<ImageView>(R.id.memoryImageView)

}