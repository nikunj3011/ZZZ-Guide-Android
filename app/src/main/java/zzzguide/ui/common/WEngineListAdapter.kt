package zzzguide.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import zzzguide.R
import zzzguide.models.api.wengines.WEngineResponseItem

class WEngineListAdapter (
    private val contextWeapon: Context,
    private var weaponsList:List<WEngineResponseItem>,
    private val clickListener:(WEngineResponseItem)->Unit
    ) : RecyclerView.Adapter<MyViewHolder2>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
            val layoutInflater = LayoutInflater.from(parent.context)
            val listItem = layoutInflater.inflate(R.layout.layout_wengine_list,parent,false)
            return MyViewHolder2(listItem)
        }

        override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
            val weapon = weaponsList[position]
            holder.bind(contextWeapon, weapon, clickListener)
        }

        fun setFilteredList(mList: List<WEngineResponseItem>){
            this.weaponsList = mList
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return weaponsList.size
        }

    }

    class MyViewHolder2(val view: View): RecyclerView.ViewHolder(view){
        fun bind(contextWeapon: Context, weapon: WEngineResponseItem, clickListener:(WEngineResponseItem)->Unit) {
            val myTextView = view.findViewById<TextView>(R.id.weaponName)
            myTextView.text = weapon.name

//            val rarityTextView = view.findViewById<TextView>(R.id.textRarityWeapon)
//            rarityTextView.text = "Rarity: " + weapon.rarity
//
//            val typeTextView = view.findViewById<TextView>(R.id.textWeaponType)
//            typeTextView.text = "" + weapon.type
//
//            val descriptionTextView = view.findViewById<TextView>(R.id.textDescriptionWeapon)
//            descriptionTextView.movementMethod = ScrollingMovementMethod()
//            descriptionTextView.text = "CD: " + weapon.description
//
//            val atkTextView = view.findViewById<TextView>(R.id.textAtkWeapon)
//            atkTextView.text =  "ATK (Lv.1): " + weapon.baseAtk.toString()
//
//            val bonusTextView = view.findViewById<TextView>(R.id.textWeaponSpAttribute)
//            bonusTextView.text = weapon.bonusStat
//
//            val echoImageView = view.findViewById<ImageView>(R.id.imageViewWeapon)
//            if(weapon.img != null){
//                Glide.with(view)
//                    .load(weapon.img)
//                    .into(echoImageView)
//
//                when (weapon.rarityDes) {
//                    "Star5" -> {
//                        echoImageView.background = ContextCompat.getDrawable(contextWeapon, R.drawable.five_star_gradient)
//                    }
//                    "Star4" -> {
//                        echoImageView.background = ContextCompat.getDrawable(contextWeapon, R.drawable.four_star_gradient)
//                    }
//                    "Star3" -> {
//                        echoImageView.background = ContextCompat.getDrawable(contextWeapon, R.drawable.three_star_gradient)
//                    }
//                    "Star2" -> {
//                        echoImageView.background = ContextCompat.getDrawable(contextWeapon, R.drawable.two_star_gradient)
//                    }
//                    "Star1" -> {
//                        echoImageView.background = ContextCompat.getDrawable(contextWeapon, R.drawable.one_star_gradient)
//                    }
//                    else -> {
//                        echoImageView.background = ContextCompat.getDrawable(contextWeapon, R.drawable.one_star_gradient)
//                    }
//                }
//            }
//
//            view.setOnClickListener {
//                clickListener(fruit)
//            }
        }
    }