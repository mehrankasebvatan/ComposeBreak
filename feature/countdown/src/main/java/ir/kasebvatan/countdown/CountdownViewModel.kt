package ir.kasebvatan.countdown

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.kasebvatan.countdown.model.CountdownState
import ir.kasebvatan.countdown.model.CounterState
import ir.kasebvatan.countdown.model.SECOND
import ir.kasebvatan.countdown.model.WORKING_DURATION
import ir.kasebvatan.countdown.model.WorkingState
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountdownViewModel : ViewModel() {
    private val _countdownState = MutableStateFlow(CountdownState())
    val countdownState: StateFlow<CountdownState> = _countdownState

    private var timerJob: Job = Job()


    fun startCountdown() {

        _countdownState.update {
            it.copy(
                counterState = CounterState.PLAY
            )
        }

        timerJob = viewModelScope.launch {
            while (true) {
                Log.d("RemainTime: ", "${_countdownState.value.remainTime}")
                if (_countdownState.value.remainTime > 0)
                    _countdownState.update {
                        it.copy(
                            remainTime = it.remainTime - 1
                        )
                    }
                else when (_countdownState.value.workingState) {
                    WorkingState.REST -> _countdownState.update {
                        it.copy(
                            workingState = WorkingState.WORK,
                            remainTime = WORKING_DURATION
                        )
                    }

                    WorkingState.WORK -> {
                        resetCountdownState()
                        this.cancel()
                    }
                }
                delay(SECOND)

            }

        }
    }


    fun resetCountdown() {
        if (timerJob.isActive) {
            resetCountdownState()
            timerJob.cancel()
        }
    }


    private fun resetCountdownState() {
        _countdownState.update {
            CountdownState()
        }
    }


}





