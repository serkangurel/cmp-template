import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import di.commonModule
import di.platformModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.github.aakira.napier.log
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ui.screens.MainScreen
import ui.theme.AppTheme

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigator(
                screen = MainScreen(),
                onBackPressed = { currentScreen ->
                    true
                }
            ) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}

fun appInit(appDeclaration: KoinAppDeclaration = {}) {
    Napier.base(DebugAntilog())

    log(tag = "Napier") { "Application Started" }

    initKoin(
        appDeclaration
    )
}

private fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
) {
    startKoin {
        appDeclaration()
        modules(commonModule(), platformModule())
    }
}