package zzzguide.ui.wengines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import zzzguide.databinding.FragmentWengineBinding
import zzzguide.models.api.wengines.WEngineResponseItem
import zzzguide.ui.characterdetail.CharacterDetailBottomSheetFragment
import zzzguide.ui.characterdetail.WengineBottomSheetFragment
import zzzguide.ui.common.WEngineListAdapter
import zzzguide.util.autoCleared
import java.util.Locale


class WEngineFragment : Fragment() {

    private lateinit var binding: FragmentWengineBinding
    private val viewModel by viewModel<WEngineViewModel>()
    private var weaponsAdapter by autoCleared<WEngineListAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentWengineBinding.inflate(
            inflater,
            container,
            false
        )
        binding = dataBinding

        binding.shimmerFrameLayoutWeapon.startShimmer()
        binding.weaponRecyclerView.setVisibility(View.GONE)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var response = viewModel.weaponsLiveData
        binding.weaponRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.searchWeaponView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        viewModel.viewModelScope.launch {
            initRecyclerView()
            delay(500)
            binding.shimmerFrameLayoutWeapon.setVisibility(View.GONE)
            binding.weaponRecyclerView.setVisibility(View.VISIBLE)
        }
    }

    private fun filterList(query: String?) {
        if (query != null) {
            viewModel.weaponsLiveData.observe(viewLifecycleOwner) { result ->

                val filteredList = ArrayList<WEngineResponseItem>()
                for (i in result) {
                    if (i.name.lowercase(Locale.ROOT).contains(query)) {
                        filteredList.add(i)
                    }
                }

                if (filteredList.isEmpty()) {
                    Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
                } else {
                    weaponsAdapter.setFilteredList(filteredList)
                }
            }
        }
    }

    private fun initRecyclerView() {
        viewModel.weaponsLiveData.observe(viewLifecycleOwner) { result ->
            this.weaponsAdapter = WEngineListAdapter(
                requireContext(),
                result
            ) { selectedItem: WEngineResponseItem ->
                listItemClicked(selectedItem)
            }
            binding.weaponRecyclerView.apply {
                adapter = weaponsAdapter
                itemAnimator?.changeDuration = 0
            }
        }
    }

    private fun listItemClicked(wengine: WEngineResponseItem){
        val bottomSheetFragment  = WengineBottomSheetFragment()

        val bundle = Bundle()
        var gson = Gson()
        var wengine = gson.toJson(wengine)

        bundle.putString("wengine", wengine.toString())
        bottomSheetFragment.arguments = bundle
        bottomSheetFragment.setCancelable(true)
        bottomSheetFragment.show(requireActivity().supportFragmentManager, WengineBottomSheetFragment::class.java.name)
    }
}