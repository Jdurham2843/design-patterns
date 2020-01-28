import behavioral.strategy.DragonSlayer
import behavioral.strategy.MeleeStrategy
import behavioral.strategy.ProjectileStrategy
import behavioral.strategy.SpellStrategy

fun main() {
    val strategies = arrayOf(ProjectileStrategy(), SpellStrategy(), MeleeStrategy())
    val dragonSlayer = DragonSlayer(null)

    strategies.forEach {
        dragonSlayer.changeStrategy(it)
        dragonSlayer.goToBattle()
    }
}
