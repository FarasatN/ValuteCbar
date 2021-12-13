import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.farasatnovruzov.valutecbar.databinding.RecyclerRowBinding


class RecyclerViewAdapter(private val valuteRepos: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    class RowHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RowHolder(binding)

    }

    override fun getItemCount(): Int {
//        return repos.size
        return valuteRepos.size

    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RowHolder, position: Int) {
//        holder.binding.recyclerViewTextView.text = repos[position]
        val colors: Array<String> = arrayOf(
            "#13bd27",
            "#29c1e1",
            "#b129e1",
            "#d3df13",
            "#e71e28",
            "#f6bd0c",
            "#a1fb93",
            "#0d9de3",
            "#FA4D7F",
            "#c545ff",
            "#30FE36",
            "#008080",
            "#ff6666",
            "#4ca3dd",
            "#bada55",
            "#0F0CE7",
            "#D35400",
            "#F5B041",
            "#A9CCE3",
            "#ABEBC6"

        )
//        holder.binding.recyclerViewTextView.text = repos.get(position)
        holder.binding.recyclerViewTextView.text = valuteRepos.get(position)
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 19]))

    }
}


//
//class RecyclerViewAdapter(val repos : ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
//
//
//    private val colors: Array<String> = arrayOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")
//
//    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
//
////        fun bind(view: View,colors: Array<String>,position: Int) {
////
////            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
////        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
//        return RowHolder(view)
//    }
//
//
//    override fun onBindViewHolder(holder: RowHolder, position: Int) {
////        holder.bind(repos[position],colors,position)
//
//    }
//
//
//    override fun getItemCount(): Int {
//        return repos.count()
//    }