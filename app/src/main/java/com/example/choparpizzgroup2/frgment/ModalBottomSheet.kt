package com.example.choparpizzgroup2.frgment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.choparpizzgroup2.R
import com.example.choparpizzgroup2.databinding.FragmentItemListDialogListDialogBinding
import com.example.choparpizzgroup2.databinding.ModalBottomSheetContentBinding
import com.example.choparpizzgroup2.model.ResultModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso

class ModalBottomSheet(val itemData: ResultModel.SubMember): BottomSheetDialogFragment(){
    private var _binding: ModalBottomSheetContentBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = ModalBottomSheetContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load("https://i.imgur.com/DvpvklR.png")
            .placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_baseline_23mp_24)
            .into(binding.imageView)
        binding.run {
            textView.text = itemData.title
            button.text = itemData.price
        }
        binding.button.setOnClickListener {
            binding.textView.text = "bla bal bla"
        }

    }
    companion object {
        const val TAG = "ModalBottomSheet"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}