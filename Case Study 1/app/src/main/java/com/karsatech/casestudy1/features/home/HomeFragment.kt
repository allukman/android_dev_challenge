package com.karsatech.casestudy1.features.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.zxing.integration.android.IntentIntegrator
import com.karsatech.casestudy1.core.factory.BalanceViewModelFactory
import com.karsatech.casestudy1.core.util.Helper
import com.karsatech.casestudy1.core.util.Helper.addThousandSeparator
import com.karsatech.casestudy1.core.util.datastore.BalancePreferences
import com.karsatech.casestudy1.core.util.datastore.dataStore
import com.karsatech.casestudy1.databinding.FragmentHomeBinding
import com.karsatech.casestudy1.features.BalanceViewModel
import com.karsatech.casestudy1.features.transaction.TransactionActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var balance = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeBalanceViewModel()
        setOnClick()
    }

    private fun setOnClick() {
        binding.layoutQr.setOnClickListener {
            scanBarcode()
        }
        binding.layoutTopUp.setOnClickListener {
            toast()
        }
        binding.layoutTransfer.setOnClickListener {
            toast()
        }
        binding.layoutTopUp.setOnClickListener {
            toast()
        }
    }

    private fun toast() {
        Toast.makeText(activity, "This feature not implemented yet", Toast.LENGTH_SHORT).show()
    }

    private fun scanBarcode() {
        val integrator = IntentIntegrator.forSupportFragment(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Place code inside the box")
        integrator.setCameraId(0) // Use a specific camera of the device
        integrator.setBeepEnabled(false)
        integrator.initiateScan()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                if (Helper.isValidBarcodeFormat(result.contents, balance)) {
                    val intent = Intent(activity, TransactionActivity::class.java)
                    intent.putExtra("DETAIL_TRANSACTION", result.contents)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Format tidak sesuai", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun subscribeBalanceViewModel() {
        val pref = BalancePreferences.getInstance(activity?.application!!.dataStore)
        val balanceViewModel = ViewModelProvider(this, BalanceViewModelFactory(pref))[BalanceViewModel::class.java]

        balanceViewModel.getCurrentBalance().observe(viewLifecycleOwner) { currentBalance: Int ->
            balance = currentBalance
            binding.tvBalance.text = balance.addThousandSeparator()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}