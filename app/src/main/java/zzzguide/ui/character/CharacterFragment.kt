package zzzguide.ui.character

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import zzzguide.databinding.FragmentCharacterBinding
import zzzguide.models.api.character.AgentResponseItem
import zzzguide.ui.characterdetail.CharacterDetailBottomSheetFragment
import zzzguide.ui.common.CharacterListAdapter
import zzzguide.util.autoCleared
import java.util.Locale


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel by viewModel<CharacterViewModel>()
    private var characterAdapter by autoCleared<CharacterListAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentCharacterBinding.inflate(
            inflater,
            container,
            false
        )
        binding = dataBinding
        binding.shimmerFrameLayoutCharacter.startShimmer()
        binding.characterRecyclerView.setVisibility(View.GONE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var response = viewModel.charactersLiveData
        binding.characterRecyclerView.layoutManager = GridLayoutManager(context, 1)
        binding.searchCharacterView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText, false)
                return true
            }

        })

        binding.imageViewIce.setOnClickListener { filterList("ice", true) }
        binding.imageViewFire.setOnClickListener {filterList("fire", true)}
        binding.imageViewElectric.setOnClickListener {filterList("electric", true)}
        binding.imageViewPhysical.setOnClickListener {filterList("physical", true)}
        binding.imageViewEther.setOnClickListener {filterList("ether", true)}
        binding.imageViewFilterOff.setOnClickListener {filterList("", false)
            binding.searchCharacterView.setQuery("", true)}
        viewModel.viewModelScope.launch {
            initRecyclerView()
            delay(500)
            binding.shimmerFrameLayoutCharacter.setVisibility(View.GONE)
            binding.characterRecyclerView.setVisibility(View.VISIBLE)
        }
    }

    private fun filterList(query: String?, isElement: Boolean) {
        if (query != null) {
            viewModel.charactersLiveData.observe(viewLifecycleOwner) { result ->

                val filteredList = ArrayList<AgentResponseItem>()
                if(isElement){
                    for (i in result) {
                        if (i.categories.elementAt(1).name.lowercase(Locale.ROOT).contains(query)) {
                            filteredList.add(i)
                        }
                    }
                }
                else{
                    for (i in result) {
                        if (i.name.lowercase(Locale.ROOT).contains(query)) {
                            filteredList.add(i)
                        }
                    }
                }

                if (filteredList.isEmpty()) {
                    Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
                } else {
                    characterAdapter.setFilteredList(filteredList)
                }
            }
        }
    }

    private fun initRecyclerView() {
        viewModel.charactersLiveData.observe(viewLifecycleOwner) { result ->
            this.characterAdapter = CharacterListAdapter(requireContext(),
                result
            ) { selectedItem: AgentResponseItem ->
                listItemClicked(selectedItem)
            }
            binding.characterRecyclerView.apply {
                adapter = characterAdapter
                itemAnimator?.changeDuration = 0
            }
        }
    }

    private fun listItemClicked(character: AgentResponseItem){
        val bottomSheetFragment  = CharacterDetailBottomSheetFragment()

        val bundle = Bundle()
        var gson = Gson()
        var characterJson = gson.toJson(character)

        bundle.putString("characterId", characterJson)
        bottomSheetFragment.arguments = bundle
        bottomSheetFragment.setCancelable(true)
        bottomSheetFragment.show(requireActivity().supportFragmentManager, CharacterDetailBottomSheetFragment::class.java.name)
    }

}