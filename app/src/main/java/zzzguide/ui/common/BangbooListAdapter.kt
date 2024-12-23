package zzzguide.ui.common

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.color
import androidx.core.text.italic
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import zzzguide.R
import zzzguide.models.api.bangbooNew.BangbooNewResponseItem


class BangbooListAdapter(
    private val contextEcho: Context,
    private var fruitsList:List<BangbooNewResponseItem>,
    private val clickListener:(BangbooNewResponseItem)->Unit
) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.layout_bangboo_list,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(contextEcho, fruit, clickListener)
    }

    fun setFilteredList(mList: List<BangbooNewResponseItem>){
        this.fruitsList = mList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(contextEcho: Context, bangboo: BangbooNewResponseItem, clickListener:(BangbooNewResponseItem)->Unit) {
        val echoTextView = view.findViewById<TextView>(R.id.bangbooName)
        echoTextView.text = bangboo?.name

        val textBangbooDes = view.findViewById<TextView>(R.id.textBangbooDes)
        textBangbooDes.text = bangboo?.name

        val imageViewBangboo = view.findViewById<ImageView>(R.id.imageViewBangboo)
        Glide.with(view)
            .load("https://www.prydwen.gg${bangboo.cardImage.localFile.childImageSharp.gatsbyImageData.images.fallback.src}")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(imageViewBangboo)

        var bangbooSkill1 = SpannableStringBuilder()
        bangbooSkill1 = bangbooSkill1.append()
            .color(Color.WHITE, { append(if (bangboo.skills?.skill_a?.name == null) " " else bangboo.skills?.skill_a?.name) })
            .append(" : ")
            .bold{ append(if (bangboo.skills?.skill_a?.description == null) " " else bangboo.skills?.skill_a?.description)
                .append("\n")}
        if (bangboo?.skills?.skill_b != null) {
            bangbooSkill1 = bangbooSkill1.append()
            .color(Color.WHITE, { append(if (bangboo.skills?.skill_b?.name == null) " " else bangboo.skills?.skill_b?.name) })
            .append(" : ")
            .bold{ append((if (bangboo.skills?.skill_b?.description?.first()?.desc == null) " " else bangboo.skills?.skill_b?.description?.first()?.desc))
                .append("\n")}
        }
        if (bangboo?.skills?.skill_c != null) {
            bangbooSkill1 = bangbooSkill1.append()
                .color(Color.WHITE, { append(if (bangboo.skills?.skill_c?.name == null) " " else bangboo.skills?.skill_c?.name) })
                .append(" : ")
                .bold{ append(if (bangboo.skills?.skill_c?.description == null) " " else bangboo.skills?.skill_c?.description)
                    .append("\n")}
        }
        val textViewBangbooSkill1 = view.findViewById<TextView>(R.id.textViewBangbooSkill1)
        textViewBangbooSkill1.text = bangbooSkill1

        var bangbooStats = "Stats- HP: ${bangboo.statsNew.hp}  ATK: ${bangboo.statsNew.atk}  DEF: ${bangboo.statsNew.def}  Impact: ${bangboo.statsNew.impact}  Anomaly: ${bangboo.statsNew.anomaly}"
        val textBangbooStats = view.findViewById<TextView>(R.id.textBangbooStats)
        textBangbooStats.text = bangbooStats

        val imageViewBangbooRank = view.findViewById<ImageView>(R.id.imageViewBangbooRank)
        val viewBangbooRank =
            view.findViewById<View>(R.id.viewBangbooRank)
        if (bangboo?.rarity != null) {

            when (bangboo?.rarity) {
                "A" -> {
                    Glide.with(view)
                        .load(R.drawable.arank)
                        .into(imageViewBangbooRank)
                    viewBangbooRank.setBackgroundColor(Color.parseColor("#AB3A4E"))
                }

                "S" -> {
                    Glide.with(view)
                        .load(R.drawable.srank)
                        .into(imageViewBangbooRank)
                    viewBangbooRank.setBackgroundColor(Color.parseColor("#F9A700"))
                }

                else -> {
                    Glide.with(view)
                        .load(R.drawable.srank)
                        .into(imageViewBangbooRank)
                    viewBangbooRank.setBackgroundColor(Color.parseColor("#F9A700"))
                }
            }
        }

    }

}