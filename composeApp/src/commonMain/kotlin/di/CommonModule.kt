package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ui.screens.home.HomeScreenModel

fun commonModule(): Module = module {
    factoryOf(::HomeScreenModel)
}