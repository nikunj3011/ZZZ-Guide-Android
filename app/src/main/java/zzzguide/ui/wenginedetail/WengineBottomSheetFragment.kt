package zzzguide.ui.characterdetail

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.text.HtmlCompat
import androidx.core.text.bold
import androidx.core.text.color
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import zzzguide.R
import zzzguide.databinding.FragmentWengineBottomSheetBinding
import zzzguide.models.api.wengines.WEngineResponseItem
import zzzguide.models.api.wenginesNew.WEngineNewResponseItem


class WengineBottomSheetFragment :  BottomSheetDialogFragment() {

    private lateinit var binding: FragmentWengineBottomSheetBinding
    private val viewModel by viewModel<CharacterDetailsViewModel>()
    private lateinit var wengine : String
    private lateinit var wengineModel : WEngineNewResponseItem
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentWengineBottomSheetBinding.inflate(
            inflater,
            container,
            false
        )
        wengine = arguments?.getString("wengine").toString()
        var gson = Gson()
        wengineModel = gson.fromJson(wengine, WEngineNewResponseItem::class.java)

        binding = dataBinding

        view?.parent
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if(wengineModel != null){
            binding.textWengineNameTransparentBottomSheet.text = wengineModel?.name.toString()
            binding.txtWengineNameBottomSheet.text = wengineModel?.name.toString()
            binding.textWengineBottomDesSmall.text = wengineModel?.talentName
            binding.txtBestAddInfoBottomSheet.text = wengineModel?.stats?.stat

            var wengineAttribute = SpannableStringBuilder()
//            var wengineAttribute = ""
//            if(wengineModel.attributes.isNotEmpty()){
//                for (attribute in wengineModel.attributes){
//                    wengineAttribute = wengineAttribute.append()
//                        .bold{color(Color.WHITE, { append(attribute?.key) })}
//                        .append(" : ")
//                        .append(HtmlCompat.fromHtml(attribute.value, HtmlCompat.FROM_HTML_MODE_COMPACT))
//                        .append("\n\n")
//
////                    wengineAttribute = wengineAttribute + HtmlCompat.fromHtml(attribute?.key + " : " + attribute?.value + "\n\n", HtmlCompat.FROM_HTML_MODE_COMPACT);
//                }
//            }

            var wengineStats = "Stats- ATK: ${wengineModel.stats.base_atk}  MAX-ATK: ${wengineModel.stats.max_atk}  Special: ${wengineModel.stats.base_special}  MAX-Special: ${wengineModel.stats.max_special}"

            binding.textViewWengineAttributes.text = wengineStats

            if(wengineModel.name != null) {
                Glide.with(view)
                    .load("https://www.prydwen.gg${wengineModel.image.localFile.childImageSharp.gatsbyImageData.images.fallback.src}")
                    .into(binding.imageViewWengineBottomSheet)
            }

            val imageViewWengineRank = view.findViewById<ImageView>(R.id.imageViewWengineRank)
            when (wengineModel.rarity) {
                0 -> {
                    Glide.with(view)
                        .load(R.drawable.arank)
                        .into(binding.imageViewWengineElementBottomSheet)
                    binding.imageViewStarGradientWEngine.setBackgroundColor(Color.parseColor("#77AB3A4E"))
                }

                2 -> {
                    Glide.with(view)
                        .load(R.drawable.srank)
                        .into(binding.imageViewWengineElementBottomSheet)
                    binding.imageViewStarGradientWEngine.setBackgroundColor(Color.parseColor("#77F9A700"))
                }

                1 -> {
                    Glide.with(view)
                        .load(R.drawable.brank)
                        .into(binding.imageViewWengineElementBottomSheet)
                    binding.imageViewStarGradientWEngine.setBackgroundColor(Color.parseColor("#770FB8E5"))
                }

                else -> {
//                    Glide.with(view)
//                        .load(R.drawable.brank)
//                        .into(binding.imageViewWengineElementBottomSheet)
//                    binding.imageViewStarGradientWEngine.setBackgroundColor(Color.parseColor("#770FB8E5"))
                }
            }

            when (wengineModel.stats?.stat?.lowercase()) {
                "attack" -> {
                    Glide.with(view)
                        .load(R.drawable.attack)
                        .into(binding.imageViewWengineSpecialityBottomSheet)
                }

                "stun" -> {
                    Glide.with(view)
                        .load(R.drawable.stun)
                        .into(binding.imageViewWengineSpecialityBottomSheet)
                }

                "anomaly" -> {
                    Glide.with(view)
                        .load(R.drawable.anomaly)
                        .into(binding.imageViewWengineSpecialityBottomSheet)
                }

                "support" -> {
                    Glide.with(view)
                        .load(R.drawable.support)
                        .into(binding.imageViewWengineSpecialityBottomSheet)
                }

                "defense" -> {
                    Glide.with(view)
                        .load(R.drawable.defense)
                        .into(binding.imageViewWengineSpecialityBottomSheet)
                }

                else -> {
                    Glide.with(view)
                        .load(R.drawable.stun)
                        .into(binding.imageViewWengineSpecialityBottomSheet)
                }
            }

        }
    }
}