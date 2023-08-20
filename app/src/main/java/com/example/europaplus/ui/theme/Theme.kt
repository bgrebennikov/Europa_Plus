package com.example.europaplus.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

@Immutable
data class AppThemeColors(
    val selectedItem: Color,
    val selectedItemText: Color,
    val unselectedItem: Color,
    val text: Color,
    val textSecondary: Color,
    val shadow: Color,
    val shadowLow: Color,
    val divider: Color,
    val controlBtnBackground: Color,
    val backgroundSecondary: Color,
    val tagsColor: Color,
)

object AppTheme {
    val colors: AppThemeColors
        @Composable
        get() = LocalAppThemeColors.current
}

val LocalAppThemeColors = staticCompositionLocalOf {
    AppThemeColors(
        selectedItem = Blue,
        selectedItemText = LightBlue,
        unselectedItem = LightGray,
        text = Color.Black,
        shadow = Color.LightGray,
        shadowLow = Color(0xfff1f1f1),
        divider = LightGray100,
        controlBtnBackground = Red,
        textSecondary = Color(0xFF898989),
        backgroundSecondary = LightGray100,
        tagsColor = PurpleGrey80
    )
}

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Pink40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = White,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun EuropaPlusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val appThemeColorsLight = AppThemeColors(
        selectedItem = Blue,
        selectedItemText = LightBlue,
        unselectedItem = LightGray,
        text = Color.Black,
        shadow = Color.LightGray,
        shadowLow = Color(0xfff1f1f1),
        divider = LightGray100,
        controlBtnBackground = Red,
        textSecondary = Color(0xFF898989),
        backgroundSecondary = Color(0xFFF5F5F5),
        tagsColor = LightGray200
    )

    val appThemeColorsDark = AppThemeColors(
        selectedItem = LightBlue,
        selectedItemText = LightBlue,
        unselectedItem = Color.LightGray,
        text = Color.White,
        shadow = Color.Transparent,
        shadowLow = Color.Transparent,
        divider = DarkGray,
        controlBtnBackground = Color.Red,
        textSecondary = Color(0xFF525252),
        backgroundSecondary = PurpleGrey40,
        tagsColor = PurpleGrey80
    )

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalAppThemeColors provides if (darkTheme) appThemeColorsDark else appThemeColorsLight
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content,
            shapes = Shapes(
                extraSmall = RoundedCornerShape(18.dp)
            )
        )
    }

}

