package ui.screens.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeScreenModel : StateScreenModel<HomeScreenModel.State>(State.Init) {

    sealed class State {
        data object Init : State()
        data object Loading : State()
        data class Result(val itemCount: Int) : State()
    }

    init {
        screenModelScope.launch {
            mutableState.value = State.Loading
            delay(2000L)
            mutableState.value = State.Result(itemCount = 50)
        }
    }
}