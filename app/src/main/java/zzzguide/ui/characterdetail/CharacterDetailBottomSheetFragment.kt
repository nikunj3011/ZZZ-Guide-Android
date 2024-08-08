package zzzguide.ui.characterdetail

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.text.bold
import androidx.core.text.color
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import zzzguide.R
import zzzguide.databinding.FragmentCharacterDetailBottomSheetBinding
import zzzguide.models.api.character.AgentResponseItem


class CharacterDetailBottomSheetFragment :  BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCharacterDetailBottomSheetBinding
    private val viewModel by viewModel<CharacterDetailsViewModel>()
    private lateinit var characterId : String
    private lateinit var characterModel : AgentResponseItem
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentCharacterDetailBottomSheetBinding.inflate(
            inflater,
            container,
            false
        )
        characterId = arguments?.getString("characterId").toString()
        if(characterId == null)
        {
            characterId = "1"
        }
        var gson = Gson()
        characterModel = gson.fromJson(characterId, AgentResponseItem::class.java)
        binding = dataBinding

        view?.parent
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.id = characterModel.slug
        viewModel.characterDetailsLiveData.observe(viewLifecycleOwner) { result ->
            var character = result
            binding.txtCharacterNameBottomSheet.text = character?.fullName
            binding.textCharacterNameTransparentBottomSheet.text = characterModel?.name
            binding.textDescriptionBottomSheet.text = characterModel?.intro
//            binding.txtCharacterStyleBottomSheet.text = character?.style
            Glide.with(view)
                .load("https://www.prydwen.gg${character.cardImage.localFile.childImageSharp.gatsbyImageData.images.fallback.src}")
                .into(binding.imageViewCharacterBottomSheet)
            binding.textCharFactionSmall.text = character?.faction

            binding.textViewBestWEngineAgent.text = character?.build?.engines?.first()?.weapon;


            binding.textRatingsCharacterBottomSheet.text = "Shiyu Defence: " +character?.ratings?.shiyu?.toString()
            binding.textMainCategoryCharacterBottomSheet.text = "Main Role: " +character?.tierListCategory

            var characterTalents = SpannableStringBuilder()
            if(!character.talents.isNullOrEmpty()){
                for (attribute in character.talents){
                    characterTalents = characterTalents.append()
                        .bold{color(Color.WHITE, { append(attribute?.name) })}
                        .append(" : ")
                        .append(HtmlCompat.fromHtml(attribute.desc, HtmlCompat.FROM_HTML_MODE_COMPACT))
                        .append("\n\n")
                }
            }
            binding.textViewCharacterTalents.text = characterTalents

            var otherRoles = "Other Role: "
            if(!character.tierListTags.isNullOrEmpty()){
                for(tiertag in character.tierListTags){
                    otherRoles = "$otherRoles $tiertag"
                }
            }
            binding.textSubCategoryCharacterBottomSheet.text = otherRoles

            var stats1 = ""
            if(!character.build.main_4.isNullOrEmpty()){
                for(stat in character.build.main_4){
                    stats1 = "$stats1 ${stat.stat}"
                }
            }
            binding.textViewStat1.text = stats1

            var stats2 = ""
            if(!character.build.main_4.isNullOrEmpty()){
                for(stat in character.build.main_5){
                    stats2 = "$stats2 ${stat.stat}"
                }
            }
            binding.textViewStat2.text = stats2

            var stats3 = ""
            if(!character.build.main_4.isNullOrEmpty()){
                for(stat in character.build.main_6){
                    stats3 = "$stats3 ${stat.stat}"
                }
            }
            binding.textViewStat3.text = stats3

            binding.textViewCharacterSubStats.text = character?.build?.substats

            if (characterModel?.categories?.elementAt(0) != null) {

                when (characterModel.categories.elementAt(0).name) {
                    "a-rank" -> {
                        Glide.with(view)
                            .load(R.drawable.arank)
                            .into(binding.imageViewStarAgent)
                    }

                    "s-rank" -> {
                        Glide.with(view)
                            .load(R.drawable.srank)
                            .into(binding.imageViewStarAgent)
                    }

                    else -> {
                        Glide.with(view)
                            .load(R.drawable.srank)
                            .into(binding.imageViewStarAgent)
                    }
                }
            }

            if (characterModel?.categories?.elementAt(2) != null) {
                when (characterModel.categories.elementAt(2).name.lowercase()) {
                    "attack" -> {
                        Glide.with(view)
                            .load(R.drawable.attack)
                            .into(binding.imageViewWeaponTypeBottomSheet)
                    }

                    "stun" -> {
                        Glide.with(view)
                            .load(R.drawable.stun)
                            .into(binding.imageViewWeaponTypeBottomSheet)
                    }

                    "anomaly" -> {
                        Glide.with(view)
                            .load(R.drawable.anomaly)
                            .into(binding.imageViewWeaponTypeBottomSheet)
                    }

                    "support" -> {
                        Glide.with(view)
                            .load(R.drawable.support)
                            .into(binding.imageViewWeaponTypeBottomSheet)
                    }

                    "defense" -> {
                        Glide.with(view)
                            .load(R.drawable.defense)
                            .into(binding.imageViewWeaponTypeBottomSheet)
                    }

                    else -> {
                        Glide.with(view)
                            .load(R.drawable.stun)
                            .into(binding.imageViewWeaponTypeBottomSheet)
                    }
                }
            }
            
            if (characterModel?.categories?.elementAt(1) != null) {
                when (characterModel.categories.elementAt(1).name.lowercase()) {
                    "ice" -> {
                        Glide.with(view)
                            .load(R.drawable.ice)
                            .into(binding.imageViewCharacterElementBottomSheet)
                    }

                    "fire" -> {
                        Glide.with(view)
                            .load(R.drawable.fire)
                            .into(binding.imageViewCharacterElementBottomSheet)
                    }

                    "electric" -> {
                        Glide.with(view)
                            .load(R.drawable.electric)
                            .into(binding.imageViewCharacterElementBottomSheet)
                    }

                    "physical" -> {
                        Glide.with(view)
                            .load(R.drawable.physical)
                            .into(binding.imageViewCharacterElementBottomSheet)
                    }

                    "ether" -> {
                        Glide.with(view)
                            .load(R.drawable.ether)
                            .into(binding.imageViewCharacterElementBottomSheet)
                    }

                    else -> {
                        Glide.with(view)
                            .load(R.drawable.electric)
                            .into(binding.imageViewCharacterElementBottomSheet)
                    }
                }
            }
            
            if (characterModel?.categories?.elementAt(4) != null) {
                when (characterModel.categories.elementAt(4).name.lowercase()) {
                    "the-cunning-hares" -> {
                        Glide.with(view)
                            .load(R.drawable.the_cunning_hares)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    "victoria-housekeeping-co" -> {
                        Glide.with(view)
                            .load(R.drawable.victoria_housekeeping_co)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    "new-eridu-public-security" -> {
                        Glide.with(view)
                            .load(R.drawable.new_eridu_public_security)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    "belobog-heavy-industries" -> {
                        Glide.with(view)
                            .load(R.drawable.belobog_heavy_industries)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    "section-6" -> {
                        Glide.with(view)
                            .load(R.drawable.section_6)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    "sons-of-calydon" -> {
                        Glide.with(view)
                            .load(R.drawable.sons_of_calydon)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    "obols-obsidian" -> {
                        Glide.with(view)
                            .load(R.drawable.obols_obsidian)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }

                    else -> {
                        Glide.with(view)
                            .load(R.drawable.sons_of_calydon)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                        Glide.with(view)
                            .load(R.drawable.sons_of_calydon)
                            .into(binding.imageViewCharacterRegionBottomSheet)
                    }
                }
            }
            
//            binding.textCharDesSmall.text = characterModel?.bio.toString()

        }
    }
}