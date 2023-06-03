package com.dev.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.viewpager.databinding.FragmentImageBinding

class ImageFragment : Fragment() {
    private var _binding : FragmentImageBinding? = null
    private val binding get() = _binding!!
    private var image : Int? = null

    //2. 저장한 키값에 값이 있다면 image 변수(컨테이너)에 넣는다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            image = it.getInt("image")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
//3. 컨테이너에 저장한 값을 레이아웃에 적용시키기

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivDobby.setImageResource(image!!)
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }
    // 1. fragment 인스턴스를 처음 만들 때 실행된다. 이 때 외부에서 이미지 파라미터를 하나를 받아서 image라는 키 값으로 저장한다.
    companion object {
        fun newInstance(img : Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt("image", img)
                }
            }
    }
}