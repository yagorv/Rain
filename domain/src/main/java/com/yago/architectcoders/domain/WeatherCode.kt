package com.yago.architectcoders.domain

sealed class WeatherCode {
    object ThunderStormWithLightRain : WeatherCode()
    object ThunderStormWithRain : WeatherCode()
    object ThunderStormWithHeavyRain : WeatherCode()
    object ThunderStormWithLightDrizzle : WeatherCode()
    object ThunderStormWithDrizzle : WeatherCode()
    object ThunderStormWithHeavyDrizzle : WeatherCode()
    object ThunderStormWithHail : WeatherCode()
    object LightDrizzle : WeatherCode()
    object Drizzle : WeatherCode()
    object HeavyDrizzle : WeatherCode()
    object LightRain : WeatherCode()
    object ModerateRain : WeatherCode()
    object HeavyRain : WeatherCode()
    object FreezingRain : WeatherCode()
    object LightShowerRain : WeatherCode()
    object ShowerRain : WeatherCode()
    object HeavyShowerRain : WeatherCode()
    object LightSnow : WeatherCode()
    object Snow : WeatherCode()
    object HeavySnow : WeatherCode()
    object MixSnowRain : WeatherCode()
    object Sleet : WeatherCode()
    object HeavySleet : WeatherCode()
    object SnowShower : WeatherCode()
    object HeavySnowShower : WeatherCode()
    object Flurries : WeatherCode()
    object Mist : WeatherCode()
    object Smoke : WeatherCode()
    object Haze : WeatherCode()
    object SandDust : WeatherCode()
    object Fog : WeatherCode()
    object FreezingFog : WeatherCode()
    object ClearSky : WeatherCode()
    object FewClouds : WeatherCode()
    object ScatteredClouds : WeatherCode()
    object BrokenClouds : WeatherCode()
    object OvercastClouds : WeatherCode()
    object UnknownPrecipitation : WeatherCode()
    companion object {
        fun valueOf(code: Int): WeatherCode =
            when (code) {
                200 -> ThunderStormWithLightRain
                201 -> ThunderStormWithRain
                202 -> ThunderStormWithHeavyRain
                230 -> ThunderStormWithLightDrizzle
                231 -> ThunderStormWithDrizzle
                232 -> ThunderStormWithHeavyDrizzle
                233 -> ThunderStormWithHail
                300 -> LightDrizzle
                301 -> Drizzle
                302 -> HeavyDrizzle
                500 -> LightRain
                501 -> ModerateRain
                502 -> HeavyRain
                511 -> FreezingRain
                520 -> LightShowerRain
                521 -> ShowerRain
                522 -> HeavyShowerRain
                600 -> LightSnow
                601 -> Snow
                602 -> HeavySnow
                610 -> MixSnowRain
                611 -> Sleet
                612 -> HeavySleet
                621 -> SnowShower
                622 -> HeavySnowShower
                623 -> Flurries
                700 -> Mist
                711 -> Smoke
                721 -> Haze
                731 -> SandDust
                741 -> Fog
                751 -> FreezingFog
                800 -> ClearSky
                801 -> FewClouds
                802 -> ScatteredClouds
                803 -> BrokenClouds
                804 -> OvercastClouds
                else -> UnknownPrecipitation
            }

        fun valueOf(weather: WeatherCode): Int =
            when (weather) {
                ThunderStormWithLightRain -> 200
                ThunderStormWithRain -> 201
                ThunderStormWithHeavyRain -> 202
                ThunderStormWithLightDrizzle -> 230
                ThunderStormWithDrizzle -> 231
                ThunderStormWithHeavyDrizzle -> 232
                ThunderStormWithHail -> 233
                LightDrizzle -> 300
                Drizzle -> 301
                HeavyDrizzle -> 302
                LightRain -> 500
                ModerateRain -> 501
                HeavyRain -> 502
                FreezingRain -> 511
                LightShowerRain -> 520
                ShowerRain -> 521
                HeavyShowerRain -> 522
                LightSnow -> 600
                Snow -> 601
                HeavySnow -> 602
                MixSnowRain -> 610
                Sleet -> 611
                HeavySleet -> 612
                SnowShower -> 621
                HeavySnowShower -> 622
                Flurries -> 623
                Mist -> 700
                Smoke -> 711
                Haze -> 721
                SandDust -> 731
                Fog -> 741
                FreezingFog -> 751
                ClearSky -> 800
                FewClouds -> 801
                ScatteredClouds -> 802
                BrokenClouds -> 803
                OvercastClouds -> 804
                UnknownPrecipitation -> -1
            }
    }
}