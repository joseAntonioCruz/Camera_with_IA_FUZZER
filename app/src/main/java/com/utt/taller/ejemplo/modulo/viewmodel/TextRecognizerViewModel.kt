package com.utt.taller.ejemplo.modulo.viewmodel

import android.media.Image
import android.util.Log
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageProxy
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.utt.taller.ejemplo.modulo.domain.TextRecognizerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class TextRecognizerViewModel @Inject constructor()
    : ViewModel() {
    private val _respuestaReconocedor = MutableLiveData<String>()
    val respuestaReconocedor: LiveData<String> = _respuestaReconocedor



    fun getText(text: String){
        viewModelScope.launch {
            _respuestaReconocedor.value = text
        }
    }
}